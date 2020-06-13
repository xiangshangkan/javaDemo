package netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * @Description:   DiscardServerHandler 继承于 ChannelInboundHandlerAdapter， ChannelInboundHandlerAdapter 实现了 ChannelInboundHandler 和 ChannelInboundHandler，
 *                  它们提供了不同可重写的时间处理器方法。如今只需要继承继承 ChannelInboundHandlerAdapter 而无需自己实现处理器接口
 * @Author: Zohar
 * @Date: 2020/6/13 11:38
 * @Version: 1.0
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter{

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        /** Discard（抛弃协议）：接收到什么就丢弃什么
        ((ByteBuf)msg).release();
         */
      //控制台打印
      ByteBuf in = (ByteBuf)msg;
      try {
          while(in.isReadable()) {
              System.out.println((char)in.readByte());
              System.out.flush();
          }
      }finally {
          ReferenceCountUtil.release(msg);
      }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        //Close the connection when an exception is raised
        cause.printStackTrace();
        ctx.close();
    }

}
