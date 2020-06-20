package javazh.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @ProjectName: javaDemo
 * @Package: javazh.nio
 * @ClassName: Demo
 * @Description: ${description}
 * @Author: Zohar
 * @Date: 2020/6/20 15:05
 * @Version: 1.0
 */
public class SelectorDemo {

    public static void main(String[] args) throws IOException {
        //1、调用静态工厂方法open()来获取Selector实例
        Selector  selector = Selector.open();
        //2、获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //3、设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        //4、绑定连接
        serverSocketChannel.bind(new InetSocketAddress(8888));
        //5、将通道注册到选择器上，并制定监听事件为：“接收连接”事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //轮询，选出感兴趣的IO就绪事件（选择键集合）
        while(selector.select() > 0) {
            Set selectedKeys = selector.selectedKeys();
            Iterator keyIterator = selectedKeys.iterator();
            while(keyIterator.hasNext()) {
                SelectionKey key = (SelectionKey) keyIterator.next();
                //根据具体的IO事件类型，执行对应的业务操作
                if (key.isAcceptable()) {
                    //IO事件：ServerSocketChannel 服务器监听通道有新连接

                } else if (key.isConnectable()) {
                    //IO事件：传输通道连接成功
                } else if (key.isReadable()) {
                    //IO事件：传输通道可读
                } else if (key.isWritable()) {
                    //IO事件：传输通道可写
                }
                //处理完成后，移除选择键
                keyIterator.remove();
            }
        }
    }

}
