package netty.time;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * @Description:  基于流的数据传输协议，例如TCP/IP,数据保存在套接字缓存内，且存储形式是一系列字节队列，这就意味着，如果发送两个单独的数据包，
 *                  不会看作两条单独数据，而是已串字节流，所以不能保证客户端准确读到远程对等写入的数据
 * @Author: Zohar
 * @Date: 2020/6/13 17:01
 * @Version: 1.0
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter{

    @Override
    public void channelRead(ChannelHandlerContext ctc, Object msg) {
        ByteBuf m = (ByteBuf)msg;
        try {
            long currentTimeMillis = (m.readUnsignedInt() - 2208988800L) * 1000L;
            System.out.println(new Date(currentTimeMillis));
            ctc.close();
        }finally {
            m.release();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
