package concurrency_in_practice.threadofknowledge.threadobjectclasscommonmethods;

/**
 * 描述  两个线程交替打印 0 ~ 100 奇偶数，用wati和notify
 */
public class WaitNotifyPrintOddEven {

    private static int count;

    private static  final Object lock = new Object();

    public static  void main(String[] args) {
         new Thread(new TurningRunner(),"偶数").start();
         new Thread(new TurningRunner(),"奇数").start();
    }

    //1、拿到锁我们就打印
    //2、打印完，唤醒其他线程，自己就休眠
    static class TurningRunner implements  Runnable {

        @Override
        public synchronized void run() {
            while (count <= 100) {
                synchronized (lock) {
                    //拿到锁就打印
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
                    lock.notify();
                    if (count <= 100) {
                        try {
                            //如果任务还没有结束，就让出当前的锁，并休眠
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
