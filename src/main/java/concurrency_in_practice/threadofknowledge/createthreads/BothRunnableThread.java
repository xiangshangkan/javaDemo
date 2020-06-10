package concurrency_in_practice.threadofknowledge.createthreads;

/**
 * Thread 和 Runnable 两种方式同时实现
 */
public class BothRunnableThread {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
             System.out.println("我来自Runnable");
            }
        }){
            @Override
            public void run() {
               /* super.run();*/
                System.out.println("我来自Thread");
            }
        }.start();
    }
}
