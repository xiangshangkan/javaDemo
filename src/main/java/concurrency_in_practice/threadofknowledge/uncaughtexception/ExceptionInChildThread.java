package concurrency_in_practice.threadofknowledge.uncaughtexception;

/**
 *  单线程，抛出，处理，有异常堆栈
 *  多线程:  子线程发生异常，会有什么不同？
 *  1、子线程抛出的异常不影响主线程的运行；
 *  2、主线程可以轻松发现异常，子线程却不行
 *  3、子线程异常无法用传统方法捕获
 */
public class ExceptionInChildThread implements Runnable{

    public static void main(String[] args) {
        new Thread(new ExceptionInChildThread()).start();
        for (int i = 0; i< 1000; i++) {
            System.out.println(i);
        }
    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}
