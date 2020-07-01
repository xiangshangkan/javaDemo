package netty.pipeline;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.embedded.EmbeddedChannel;

import java.util.logging.Logger;

/**
 * @Description: Pipeline出站迅速，与处理器添加顺序相反
 * @Author: Zohar
 * @Date: 2020/6/23 10:46
 * @Version: 1.0
 */
public class OutPipeline {

    static class SimpleOutHandlerA extends ChannelOutboundHandlerAdapter {
        @Override
        public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
            Logger.getGlobal().info("出站处理器 A：被调用" );
            super.write(ctx,msg,promise);
        }
    }
    static class SimpleOutHandlerB extends ChannelOutboundHandlerAdapter {
        @Override
        public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
            Logger.getGlobal().info("出站处理器 B：被调用" );
            super.write(ctx,msg,promise);
        }
    }
    static class SimpleOutHandlerC extends ChannelOutboundHandlerAdapter {
        @Override
        public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
            Logger.getGlobal().info("出站处理器 C：被调用" );
            super.write(ctx,msg,promise);
        }
    }

    public static void main(String[] args){
        ChannelInitializer i = new ChannelInitializer<EmbeddedChannel>() {
            @Override
            protected void initChannel(EmbeddedChannel channel) throws Exception {
                channel.pipeline().addLast(new SimpleOutHandlerA());
                channel.pipeline().addLast(new SimpleOutHandlerB());
                channel.pipeline().addLast(new SimpleOutHandlerC());
            }
        };
        EmbeddedChannel channel = new EmbeddedChannel(i);
        ByteBuf buf = Unpooled.buffer();
        buf.writeInt(1);
        //向通道写一个出站报文（或数据包）
        channel.writeOutbound(buf);
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
