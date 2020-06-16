package netty.time;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import netty.time.upgrade.UnixTime;

/**
 * @Description: ${description}
 * @Author: Zohar
 * @Date: 2020/6/15 14:00
 * @Version: 1.0
 */
public class TimeEncoder extends ChannelOutboundHandlerAdapter{

    @Override
    public void write(ChannelHandlerContext chc, Object msg, ChannelPromise promise) {
        UnixTime m = (UnixTime)msg;
        ByteBuf encoded = chc.alloc().buffer(4);
        encoded.writeInt((int)m.value());
        chc.write(encoded,promise);
    }
}
