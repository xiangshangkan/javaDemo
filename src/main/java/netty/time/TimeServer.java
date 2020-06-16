package netty.time;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Description:
 * @Author: Zohar
 * @Date: 2020/6/15 11:35
 * @Version: 1.0
 */
public class TimeServer {


    private int port;

    public TimeServer(int port) {
        this.port = port;
    }

    public void run()throws  Exception{
        //用以接收过来的连接
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //一旦bossGroup接收到连接并且注册接收连接给workerGroup,workerGroup负责处理连接数据传输
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            //创建服务器
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workerGroup)
                    //实例化新的Channel
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel sc) throws Exception {
                            //添加自定义处理器
                            sc.pipeline().addLast(new TimeServerHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG,128)
                    .childOption(ChannelOption.SO_KEEPALIVE,true);

            //绑定并且开始接收过来的连接
            ChannelFuture f = b.bind(port).sync();

            //等待直到服务端套接字关闭
            //在这个例子中，这种情况不会发生，但是你可以这样优雅的关闭你的服务端
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) throws Exception {
        int port = 8080;
        if(args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        new TimeServer(port).run();
    }
}
