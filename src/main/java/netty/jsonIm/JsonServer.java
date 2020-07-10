package netty.jsonIm;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.util.CharsetUtil;

import java.util.logging.Logger;

/**
 * @Description: 简单的客户端/服务器传输程序：服务器接收客户端的数据包，并解码成Json，再转换成POJO；客户端将POJO转换成JSON字符串，编码后发送到服务器端
 * @Author: Zohar
 * @Date: 2020/7/10 14:52
 * @Version: 1.0
 */
public class JsonServer {

    private int port;

    public JsonServer(int port) {
        this.port = port;
    }


    public void runServer() throws InterruptedException {

        //创建反应器线程组
        EventLoopGroup bossLoopGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerLoopGroup = new NioEventLoopGroup();


        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossLoopGroup,workerLoopGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel sc) throws Exception {
                            //流水线管理子通道中的Handler业务处理器
                            //向子通道流水线添加3个Handler 业务处理器
                            sc.pipeline().addLast(
                                    new LengthFieldBasedFrameDecoder(1024,0,4,0,4)
                                    ,new StringDecoder(CharsetUtil.UTF_8)
                                    ,new JsonMsgDecoder()
                            );
                        }
                    });

            ChannelFuture f = bootstrap.bind(port).sync();
            f.channel().closeFuture().sync();
        } finally {
            bossLoopGroup.shutdownGracefully();
            bossLoopGroup.shutdownGracefully();
        }
    }


    /**
     * 服务器端业务处理器
     */
    static class JsonMsgDecoder extends ChannelInboundHandlerAdapter {

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) {
            String json = (String)msg;
            JsonMsg jsonMsg = JsonMsg.parseFromJson(json);
            Logger.getGlobal().info("收到一个Json数据包 =》" + jsonMsg);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        new JsonServer(80).runServer();
    }
}
