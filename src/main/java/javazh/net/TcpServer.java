package javazh.net;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

    public static void main(String args[]) throws IOException {
        //创建一个Serversocket， 用于监听客户端Socket的连接请求
        ServerSocket ss = new ServerSocket(3000);
        while (true) {
            //每当接收到客户端socket的请求时，服务端也对应产生一个Socket
            Socket socket = ss.accept();
            //将Socket对应的输出流包装成PrintStream
            PrintStream ps = new PrintStream(socket.getOutputStream());
            //进行普通IO操作
            ps.println("您好，您收到了服务区的新年祝福！");
            ps.close();
            socket.close();
        }
    }

}
