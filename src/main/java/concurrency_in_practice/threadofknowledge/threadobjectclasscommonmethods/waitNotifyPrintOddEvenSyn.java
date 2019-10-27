package concurrency_in_practice.threadofknowledge.threadobjectclasscommonmethods;

/**
 * 描述 ： 两个线程交替打印0~100的奇偶数，用synchronized 关键字实现
 */
public class waitNotifyPrintOddEvenSyn {
    private static int count;
    private static Object lock = new Object();

    //新建两个线程
    //一个只处理偶数，另一个处理奇数
    //用synchronized 来通信
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count <= 100) {
                    synchronized (lock) {
                        if ((count & 1) == 0) {
                            System.out.println(Thread.currentThread().getName() +
                            ":" + count++);
                        }
                    }
                }
            }
        },"偶数").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count <= 100) {
                    synchronized (lock) {
                        if ((count & 1) == 1) {
                            System.out.println(Thread.currentThread().getName()
                                    +":" + count++);
                        }
                    }
                }
            }
        },"奇数").start();
    }
}
