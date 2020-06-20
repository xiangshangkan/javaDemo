package javazh.nio;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class FileChannelTest {
    public static void main(String args[]){
        File file = new File("D:\\test\\ByteBufferTest.java");
        //创建FileInputStream ，以该文见输入流创建FileChannel
        try {
            FileInputStream fi = new FileInputStream(file);
            System.out.println(file.length());
            FileOutputStream fo = new FileOutputStream(file);
            FileChannel inChannel = fi.getChannel();
            FileChannel outChannel = fo.getChannel();
            MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY,0,file.length());
            //使用GBK的字符集来创建解码器
            Charset charset = Charset.forName("GBK");
            //直接将buffer里的数据全部输出
            outChannel.write(buffer);
            //再次调用buffer的clear()方法，复原limit，position的位置
            buffer.clear();
            //创建解码器
            CharsetDecoder decoder = charset.newDecoder();
            //使用解码器将ByteBuffer转换成CharBuffer
            CharBuffer charBuffer = decoder.decode(buffer);
            System.out.println("fhdjfhdj\n"+charBuffer);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
