package netty.time.upgrade;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Description: ${description}
 * @Author: Zohar
 * @Date: 2020/6/15 13:47
 * @Version: 1.0
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext cct, Object o) throws Exception {
        UnixTime m = (UnixTime)o;
        System.out.println(m);
        cct.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) throws Exception {

    }
}
