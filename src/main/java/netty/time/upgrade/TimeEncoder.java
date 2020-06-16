package netty.time.upgrade;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @Description: ${description}
 * @Author: Zohar
 * @Date: 2020/6/15 14:06
 * @Version: 1.0
 */
public class TimeEncoder extends MessageToByteEncoder<UnixTime>{
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, UnixTime msg, ByteBuf buf) throws Exception {
        buf.writeInt((int)msg.value());
    }
}
