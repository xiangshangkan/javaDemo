package concurrency_in_practice.threadofknowledge.createthreads;

/**
 * 用Runnable方式创建线程
 */
public class RunnableStyle implements Runnable{

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableStyle());
        thread.start();

    }

    @Override
    public void run() {
       System.out.print("用Runnable方式创建线程");
    }
}
