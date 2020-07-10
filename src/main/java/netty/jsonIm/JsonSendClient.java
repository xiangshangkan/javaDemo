package netty.jsonIm;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

import java.util.logging.Logger;

/**
 * @Description: ${description}
 * @Author: Zohar
 * @Date: 2020/7/10 15:36
 * @Version: 1.0
 */
public class JsonSendClient {

    static String content = "疯狂创客圈：高性能学习社群！";

    private String ip;
    private int port;

    public JsonSendClient(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void runClient() {
        //创建反应器线程组
        EventLoopGroup workerLoopGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            //1 设置反应器线程组
            b.group(workerLoopGroup);
            //2、设置nio类型的通道
            b.channel(NioSocketChannel.class);
            //3、设置监听端口
            b.remoteAddress("localhost",80);
            //4、设置通道的参数
            b.option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
            //5、装配通道流水线
            b.handler(new ChannelInitializer<SocketChannel>() {
                //初始化客户端通道
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    //客户端通道流水线添加2个Handler业务处理器
                    ch.pipeline().addLast(new LengthFieldPrepender(4));
                    ch.pipeline().addLast(new StringEncoder(CharsetUtil.UTF_8));
                }
            });

            ChannelFuture f = b.connect();
            f.addListener((ChannelFuture future) ->{
                if (future.isSuccess()) {
                    Logger.getGlobal().info("EchoClient 客户端连接成功！");
                } else {
                    Logger.getGlobal().info("EchoClient 客户端连接失败！");
                }
            });

            //阻塞，直到连接完成
            f.sync();
            Channel channel = f.channel();

            //发送Json 字符串对象
            for (int i = 0; i < 1000; i++) {
                JsonMsg user = build(i,i + "->" + content);
                channel.writeAndFlush(user.convertToJson());
                Logger.getGlobal().info("发送报文：" + user.convertToJson());
            }

            channel.flush();
            //7、等待通道关闭的异步任务结束
            //服务监听通道会一直等待通道关闭的异步任务结束
            ChannelFuture closeFuture = channel.closeFuture();
            closeFuture.sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //从容关闭 EventLoopGroup
            //释放掉所有资源，包括创建的线程
            workerLoopGroup.shutdownGracefully();
        }

    }

    public JsonMsg build(int id, String content) {
        JsonMsg user = new JsonMsg();
        user.setId(id);
        user.setContent(content);
        return user;
    }

    public static void main(String[] args) {
        new JsonSendClient("localhost",80).runClient();
    }
}
