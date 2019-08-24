package concurrency_in_practice.threadofknowledge.createthreads;

/**
 * 用Thread 方式创建线程
 */
public class ThreadStyle extends Thread {

    public static void main(String[] args) {
        Thread thread =new ThreadStyle();
        thread.start();
    }

    @Override
    public void run(){
        System.out.print("用Thread 方式创建线程");
    }
}
