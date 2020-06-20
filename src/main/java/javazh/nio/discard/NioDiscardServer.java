package javazh.nio.discard;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Iterator;
import java.util.logging.Logger;

/**
 * @Description: ${description}
 * @Author: Zohar
 * @Date: 2020/6/20 15:26
 * @Version: 1.0
 */
public class NioDiscardServer {

    public static void startServer() throws IOException {
        //1、获取选择器
        Selector selector = Selector.open();
        //2、获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //3、设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        //4、绑定连接
        serverSocketChannel.bind(new InetSocketAddress(8888));

        Logger.getGlobal().info("服务器启动成功！");
        //5、将通道注册的“接收新连接”IO事件，注册到选择器上
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //6、轮询感兴趣的IO就绪事件（选择键集合）
        while (selector.select() > 0) {
            //7、获取选择键集合
            Iterator<SelectionKey> keys = selector.selectedKeys().iterator();

            while (keys.hasNext()) {
                //8、获取单个的选择键，并处理
                SelectionKey selectedKey = keys.next();
                //9、判断key是具体的什么事件
                if (selectedKey.isAcceptable()) {
                    //10、若选择的IO事件是“连接就绪”事件，就获取客户端连接
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    //11、切换为非阻塞模式
                    socketChannel.configureBlocking(false);
                    //12、将该新连接的通道的可读事件，注册到选择器上
                    socketChannel.register(selector,SelectionKey.OP_READ);
                } else if (selectedKey.isReadable()) {
                    //13、若选择键的IO事件是“可读”事件，读取数据
                    SocketChannel socketChannel = (SocketChannel) selectedKey.channel();

                    //14、读取数据，然后丢弃
                    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
                    int length = 0;
                    while ((length = socketChannel.read(byteBuffer)) > 0){
                        byteBuffer.flip();
                        //Logger.getGlobal().info(new String(byteBuffer.array(),0,length));
                        Charset charset = Charset.forName("GBK");
                        //创建解码器
                        CharsetDecoder decoder = charset.newDecoder();
                        //使用解码器将ByteBuffer转换成CharBuffer
                        CharBuffer charBuffer = decoder.decode(byteBuffer);
                        Logger.getGlobal().info("接收到客户端信息："+ charBuffer);
                        byteBuffer.clear();
                    }
                }
                //15、移除选择键
                keys.remove();
            }
        }
        //16、关闭连接
        serverSocketChannel.close();
    }

    public static void main(String[] args) throws IOException {
        startServer();
    }
}
