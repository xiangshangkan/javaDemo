package concurrency_in_practice.threadofknowledge.stopthreads;

/**
 * 如果在执行过程中，每次循环都会调用sleep 或 wait方法，那么
 * 不需要每次迭代都检查是否已中断
 */
public class RightWayStopThreadWithSleepEveryLoop {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = ()->{
            try {
                int num = 0;
                while (num <= 100000) {
                    System.out.println(num++ + "是100的倍数");
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
    }
}
