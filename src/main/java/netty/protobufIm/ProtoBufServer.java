package netty.protobufIm;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import netty.protobuf.protocol.MsgProtos;

import java.util.logging.Logger;

/**
 * @Description:
 * @Author: Zohar
 * @Date: 2020/7/10 19:37
 * @Version: 1.0
 */
public class ProtoBufServer {

    private int port;

    public ProtoBufServer(int port) {
        this.port = port;
    }

    public void runServer(){
        EventLoopGroup bossLoopGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerLoopGroup = new NioEventLoopGroup();

        ServerBootstrap b = new ServerBootstrap();
        b.group(bossLoopGroup,workerLoopGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel sc) throws Exception {
                        // 流水线管理子通道中的 Handler 业务处理器
                        // 向子通道流水线添加3个 Handler 业务处理器
                        sc.pipeline().addLast(new ProtobufVarint32FrameDecoder());
                        sc.pipeline().addLast(new ProtobufDecoder(MsgProtos.Msg.getDefaultInstance()));
                        sc.pipeline().addLast(new ProtobufBussinessDecoder());
                    }
                });
    }

    //服务器端的业务处理器
    static class ProtobufBussinessDecoder extends ChannelInboundHandlerAdapter {

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) {
            MsgProtos.Msg protoMsg = (MsgProtos.Msg)msg;
            //经过流水线的各个解码器，到此Person 类型已经可以断定
            Logger.getGlobal().info("收到一个MsgProtos.Msg 数据包=》");
            Logger.getGlobal().info("protoMsg.getId():=" + protoMsg.getId());
            Logger.getGlobal().info("protoMsg.getContent():=" + protoMsg.getContent());
        }
    }

    public static void main(String[] args) {
        new ProtoBufServer(80).runServer();
    }
}
