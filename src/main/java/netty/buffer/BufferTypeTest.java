package netty.buffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

import java.nio.charset.Charset;
import java.util.logging.Logger;

/**
 * @Description: 堆缓冲区和直接缓冲区
 * @Author: Zohar
 * @Date: 2020/6/23 11:47
 * @Version: 1.0
 */
public class BufferTypeTest {

    final static Charset UTF_8 = Charset.forName("UTF-8");
    //堆缓冲区

    public static void testHeapBuffer(){
        //取得堆内存
        ByteBuf heapBuf = ByteBufAllocator.DEFAULT.heapBuffer();
        heapBuf.writeBytes("周辉".getBytes(UTF_8));
        if (heapBuf.hasArray()) {
            //取得内部数组
            byte[] array = heapBuf.array();
            int offset = heapBuf.arrayOffset() + heapBuf.readerIndex();
            int length = heapBuf.readableBytes();
            Logger.getGlobal().info(new String(array,offset,length,UTF_8));
        }
        heapBuf.release();
    }

    //直接缓存区
    public static void testDirectBuffer(){
        ByteBuf directBuf = ByteBufAllocator.DEFAULT.directBuffer();
        directBuf.writeBytes("周辉".getBytes(UTF_8));
        if (!directBuf.hasArray()) {
            int length = directBuf.readableBytes();
            byte[] array = new byte[length];
            //把数据读取到堆内存
            directBuf.getBytes(directBuf.readerIndex(),array);
            Logger.getGlobal().info(new String(array,UTF_8));
        }
        directBuf.release();
    }

    public static void main(String[] args) {
        testHeapBuffer();
    }
}
