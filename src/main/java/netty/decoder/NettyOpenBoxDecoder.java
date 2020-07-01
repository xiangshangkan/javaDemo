package netty.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * @Description: ${description}
 * @Author: Zohar
 * @Date: 2020/6/23 20:08
 * @Version: 1.0
 */
public class NettyOpenBoxDecoder {

    public static final int VERSION = 100;
    static String content = "疯狂创客圈：高性能学习社群";


    public void testLengthFieldBasedFrameDecoder1()  {

        final LengthFieldBasedFrameDecoder spliter = new LengthFieldBasedFrameDecoder(1024,0,4,0,4);
        ChannelInitializer i = new ChannelInitializer<EmbeddedChannel>() {
            @Override
            protected void initChannel(EmbeddedChannel channel) throws Exception {
                channel.pipeline().addLast(spliter);
                channel.pipeline().addLast(new StringDecoder(Charset.forName("UTF-8")));
            }
        };

        EmbeddedChannel channel = new EmbeddedChannel();
        try {
            for (int j = 1; j <= 100; j++) {
                ByteBuf buf = Unpooled.buffer();
                String s = j + "次发送->" + content;
                byte[] bytes = s.getBytes("UTF-8");
                buf.writeInt(bytes.length);
                buf.writeBytes(bytes);
               channel.writeInbound(buf);
            }
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
