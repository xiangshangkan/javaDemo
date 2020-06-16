package netty.time.upgrade;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;


/**
 * @Description: ${description}
 * @Author: Zohar
 * @Date: 2020/6/13 16:55
 * @Version: 1.0
 */
public class TimeClient {

    public static void main(String[] args) throws Exception{
        //String host = args[0];
        //int port = Integer .parseInt(args[1]);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE,true);
            b.handler(new ChannelInitializer<SocketChannel>() {

                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new TimeDecoder(),new TimeClientHandler());
                }
            });

            //开启客户端
            ChannelFuture f = b.connect("localhost",8080).sync();
            //等待直到连接关闭
            f.channel().closeFuture().sync();

        } finally {
             workerGroup.shutdownGracefully();
        }
    }
}
