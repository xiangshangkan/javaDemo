package netty.time.upgrade;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @Description: ${description}
 * @Author: Zohar
 * @Date: 2020/6/15 13:42
 * @Version: 1.0
 */
public class TimeDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> list) throws Exception {
        if (in.readableBytes() < 4) {
            return;
        }
        list.add(new UnixTime(in.readUnsignedInt()));
    }
}
