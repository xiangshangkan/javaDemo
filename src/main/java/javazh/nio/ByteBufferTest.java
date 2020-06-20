package javazh.nio;

import java.nio.ByteBuffer;

public class ByteBufferTest {

    public static void main(String args[]) {
        ByteBuffer buffer = ByteBuffer.allocateDirect(12);
        System.out.println("初始值：position = " + buffer.position() + "，limit = " + buffer.limit());
        byte a = 2;
        byte b = 9;
        byte c = 3;
        buffer.put(a);
        buffer.put(b);
        buffer.put(c);
        System.out.println("加入三个元素后：position = " + buffer.position() + "，limit = " + buffer.limit() + ",capacity = " +buffer.capacity());
        buffer.flip();
        System.out.println("执行flip()方法后：position = " + buffer.position() + "，limit = " + buffer.limit()+ ",capacity = " +buffer.capacity());
        System.out.println("取出一个值：value = " + buffer.get() + "，position = " + buffer.position() + "，limit = " + buffer.limit()+ ",capacity = " +buffer.capacity());
        buffer.clear();
         buffer.compact();
        System.out.println("执行clear()方法后：position = " + buffer.position() + "，limit = " + buffer.limit()+ ",capacity = " +buffer.capacity());

    }
}
