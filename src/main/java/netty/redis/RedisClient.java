package netty.redis;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.redis.RedisArrayAggregator;
import io.netty.handler.codec.redis.RedisBulkStringAggregator;
import io.netty.handler.codec.redis.RedisDecoder;
import io.netty.handler.codec.redis.RedisEncoder;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Description: 用Netty实现 redis 客户端
 * @Author: Zohar
 * @Date: 2020/6/16 11:37
 * @Version: 1.0
 */
public class RedisClient {

    private static final String HOST = System.getProperty("host","192.168.1.77");
    private static final int PORT = Integer.parseInt(System.getProperty("port","6379"));

    public static void main(String[] args) throws Exception{
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel sc) throws Exception {
                            ChannelPipeline p = sc.pipeline();
                            p.addLast(new RedisDecoder())
                                    .addLast(new RedisBulkStringAggregator())
                                    .addLast(new RedisArrayAggregator())
                                    .addLast(new RedisEncoder())
                                    .addLast(new RedisClientHandler());
                        }
                    });

            //start the connection attempt.
            Channel ch = b.connect(HOST,PORT).sync().channel();

            //read commands from the stdin
            System.out.println("Enter Redis commands (quit to end)");
            ChannelFuture lastWriteFuture = null;
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            for (;;) {
                final String input = in.readLine();
                final String line = input != null ? input.trim() : null;
                if (line == null || "quit".equalsIgnoreCase(line)) {//EOF or "quit"
                    ch.close().sync();
                    break;
                } else if (line.isEmpty()) {
                    continue;
                }
                //Sends the received line to the server
                lastWriteFuture = ch.writeAndFlush(line);
                lastWriteFuture.addListener(new GenericFutureListener<Future<? super Void>>() {
                    @Override
                    public void operationComplete(Future<? super Void> future) throws Exception {
                        if (!future.isSuccess()) {
                            System.out.println("write failed：");
                            future.cause().printStackTrace(System.err);
                        }
                    }
                });
            }
            //wait until all message are flushed before closing the channel.
            if (lastWriteFuture != null) {
                lastWriteFuture.sync();
            }
        } finally {
            group.shutdownGracefully();
        }
    }
}
