package netty.pipeline;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.embedded.EmbeddedChannel;

import java.util.logging.Logger;

/**
 * @Description: Pipeline入站顺序 与添加处理器的顺序相同
 * @Author: Zohar
 * @Date: 2020/6/23 10:09
 * @Version: 1.0
 */
public class Inpipeline {

    static class SimpleInHandlerA extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            Logger.getGlobal().info("入站处理器 A：被调用" );
            super.channelRead(ctx,msg);
        }
    }
    static class SimpleInHandlerB extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            Logger.getGlobal().info("入站处理器 B：被调用");
            super.channelRead(ctx,msg);
        }
    }
    static class SimpleInHandlerC extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            Logger.getGlobal().info("入站处理器 C：被调用");
            super.channelRead(ctx,msg);
        }
    }
    public static void main(String[] args){
        ChannelInitializer i = new ChannelInitializer() {
            @Override
            protected void initChannel(Channel channel) throws Exception {
                channel.pipeline().addLast(new SimpleInHandlerA());
                channel.pipeline().addLast(new SimpleInHandlerB());
                channel.pipeline().addLast(new SimpleInHandlerC());
            }
        };
        EmbeddedChannel channel = new EmbeddedChannel(i);
        ByteBuf buf = Unpooled.buffer();
        buf.writeInt(1);
        //向通道写一个入站报文（数据包）
        channel.writeInbound(buf);
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
