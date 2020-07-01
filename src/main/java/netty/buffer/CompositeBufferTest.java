package netty.buffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * @Description:  CompositeBuffer  组合Buffer
 * @Author: Zohar
 * @Date: 2020/6/23 14:11
 * @Version: 1.0
 */
public class CompositeBufferTest {

    static Charset utf8 = Charset.forName("UTF-8");

    public static void byteBufComposite(){
        CompositeByteBuf cBuf = ByteBufAllocator.DEFAULT.compositeBuffer();
        //消息头
        ByteBuf headerBuf = Unpooled.copiedBuffer("疯狂创客圈",utf8);
        //休息体1
        ByteBuf bodyBuf = Unpooled.copiedBuffer("高性能Netty",utf8);
        cBuf.addComponents(headerBuf,bodyBuf);
        sendMsg(cBuf);
        //在refCnt 为0前，retain
        headerBuf.retain();

        cBuf = ByteBufAllocator.DEFAULT.compositeBuffer();
        //消息体2
        bodyBuf = Unpooled.copiedBuffer("高性能学习社群",utf8);
        cBuf.addComponents(headerBuf,bodyBuf);
        sendMsg(cBuf);
        cBuf.release();
    }

    private static void sendMsg(CompositeByteBuf cBuf) {
        //处理整个休息
        for(ByteBuf b : cBuf) {
            int length = b.readableBytes();
            byte[] array = new byte[length];
            //将CompositeByteBuf 中的数据复制到数组中
            b.getBytes(b.readerIndex(),array);
            //处理一下数组中的数据
            System.out.println(new String(array,utf8));
        }
        System.out.println();
    }

    public static void intCompositeBufComposite(){
        CompositeByteBuf cbuf = Unpooled.compositeBuffer(3);
        cbuf.addComponent(Unpooled.wrappedBuffer(new byte[]{1,2,3}));
        cbuf.addComponent(Unpooled.wrappedBuffer(new byte[]{4}));
        cbuf.addComponent(Unpooled.wrappedBuffer(new byte[]{5,6}));
        //合并成一个缓冲区
        ByteBuffer nioBuffer = cbuf.nioBuffer(0,6);
        byte[] bytes = nioBuffer.array();
        System.out.println("byte = ");
        for (byte b : bytes) {
            System.out.println(b);
        }
        cbuf.release();
    }

    public static void main(String[] args) {

    }
}
