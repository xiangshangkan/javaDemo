package netty.time.upgrade;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Description: ${description}
 * @Author: Zohar
 * @Date: 2020/6/15 13:52
 * @Version: 1.0
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter{
    @Override
    public void channelActive(final ChannelHandlerContext chc) {
        ChannelFuture f = chc.writeAndFlush(new UnixTime());
        f.addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable caouse) {
        caouse.printStackTrace();
        ctx.close();
    }

}
