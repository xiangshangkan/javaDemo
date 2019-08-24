package concurrency_in_practice.threadofknowledge.stopthreads;

/**
 * 带有sleep 的中断编程的写法
 */
public class RightWayStopThreadWithSleep   {


    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = ()->{
            try {
                int num = 0;
                while (!Thread.currentThread().isInterrupted() && num <= 300) {
                    System.out.println(num++ + "是100的倍数");
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }
}
