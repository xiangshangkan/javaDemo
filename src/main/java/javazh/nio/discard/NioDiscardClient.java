package javazh.nio.discard;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.logging.Logger;

/**
 * @Description: ${description}
 * @Author: Zohar
 * @Date: 2020/6/20 15:50
 * @Version: 1.0
 */
public class NioDiscardClient {

    public static void startClient() throws IOException {
        InetSocketAddress address = new InetSocketAddress("127.0.0.1",8888);

        //1、获取通道
        SocketChannel socketChannel = SocketChannel.open(address);
        //2、切换成非阻塞模式
        socketChannel.configureBlocking(false);
        //不断的自旋、等待连接完成，或者做一些其他的事情
        while (!socketChannel.finishConnect()) {

        }
        Logger.getGlobal().info("客户端连接成功");
        //3、分配指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1204);
        byteBuffer.put("hello world".getBytes());
        byteBuffer.flip();
        //4、发送到服务器
        socketChannel.write(byteBuffer);
        socketChannel.shutdownOutput();
        socketChannel.close();
    }

    public static void main(String[] args) throws IOException {
        startClient();
    }
}
