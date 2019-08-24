package concurrency_in_practice.threadofknowledge.stopthreads;

/**
 * run方法内没有sleep或wait方法时，停止线程
 */
public class RightWayStopThreadsWithoutSleep implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        Thread thread =new Thread(new RightWayStopThreadsWithoutSleep());
        thread.start();
        thread.sleep(2000);
        thread.interrupt();

    }

    @Override
    public void run() {
        int num = 0 ;
        while (!Thread.currentThread().isInterrupted() && num/2 <= Integer.MAX_VALUE/2) {
            if(num%10000 == 0) {
                System.out.println(num + "是一万的倍数！");
            }
            num++;
        }
        System.out.println("任务运行结束了！");
    }
}
