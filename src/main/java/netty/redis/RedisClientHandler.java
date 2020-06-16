package netty.redis;

import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.CodecException;
import io.netty.handler.codec.redis.*;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: Redis 客户端处理器
 * @Author: Zohar
 * @Date: 2020/6/16 11:16
 * @Version: 1.0
 */
public class RedisClientHandler extends ChannelDuplexHandler{


    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        String[] commands = ((String)msg).split("\\s+");
        List<RedisMessage> children = new ArrayList<RedisMessage>(commands.length);
        for(String cmdString : commands) {
            children.add(new FullBulkStringRedisMessage(ByteBufUtil.writeUtf8(ctx.alloc(),cmdString)));
        }
        RedisMessage request = new ArrayRedisMessage(children);
        ctx.write(request,promise);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        RedisMessage redisMessage = (RedisMessage) msg;
        printAggregatedRedisResponse(redisMessage);
        ReferenceCountUtil.release(redisMessage);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

    private static void printAggregatedRedisResponse(RedisMessage msg) {
        if (msg instanceof SimpleStringRedisMessage) {

            System.out.println(((SimpleStringRedisMessage)msg).content());
        } else if (msg instanceof ErrorRedisMessage) {

            System.out.println(((ErrorRedisMessage)msg).content());
        } else if (msg instanceof IntegerRedisMessage) {

            System.out.println(((IntegerRedisMessage)msg).value());
        } else if (msg instanceof FullBulkStringRedisMessage) {

            System.out.println(getString((FullBulkStringRedisMessage)msg));
        } else if (msg instanceof ArrayRedisMessage) {

            for (RedisMessage child : ((ArrayRedisMessage)msg).children()) {
                printAggregatedRedisResponse(child);
            }
        } else {

            throw  new CodecException("unknown message type：" + msg);
        }
    }

    private static String getString(FullBulkStringRedisMessage msg) {
        if(msg.isNull()) {
            return "(null)";
        }
        return msg.content().toString(CharsetUtil.UTF_8);
    }
}
