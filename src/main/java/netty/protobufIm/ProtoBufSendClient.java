package netty.protobufIm;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import netty.protobuf.protocol.MsgProtos;

import java.util.logging.Logger;

/**
 * @Description:
 * @Author: Zohar
 * @Date: 2020/7/10 20:03
 * @Version: 1.0
 */
public class ProtoBufSendClient {

    static String content = "疯狂创客圈：高性能学习社群！";

    private int port;
    private String ip;

    public ProtoBufSendClient (String ip,int port) {
        this.port = port;
        this.ip = ip;
    }

    public void runClient() {
        //创建反应器线程组
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            //1、设置反应器线程组
            b.group(workerGroup);
            //2、设置nio类型的通道
            b.channel(NioSocketChannel.class);
            //3、设置监听端口
            b.remoteAddress("localhost",80);
            //4、设置通道的参数
            b.option(ChannelOption.ALLOCATOR,
                    PooledByteBufAllocator.DEFAULT);
            //5、装配通道流水线
            b.handler(new ChannelInitializer<SocketChannel>() {

                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
                    socketChannel.pipeline().addLast(new ProtobufEncoder());
                }
            });

            ChannelFuture f = b.connect();
            //阻塞，直到连接完成
            f.sync();

            Channel channel = f.channel();

            //发送Protobuf对象
            for (int i = 0; i < 1000; i++) {
                MsgProtos.Msg user = build(i,i + "->" + content);
                channel.writeAndFlush(user);
                Logger.getGlobal().info("发送报文数：" + i);
            }
            channel.flush();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }




    }

    //构建ProtoBuf对象
    public MsgProtos.Msg build(int id, String content) {
        MsgProtos.Msg.Builder builder = MsgProtos.Msg.newBuilder();
        builder.setId(id);
        builder.setContent(content);
        return builder.build();
    }

    public static void main(String[] args) {
        new ProtoBufSendClient("localhost",80).runClient();
    }
}
