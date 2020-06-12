package concurrency_in_practice.DeadLLock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 描述   用ThreadMXBean 检测死锁
 */
public class ThreadMXBeanDetection implements Runnable{
    int flag = 1;

    static  Object o1  = new Object();
    static  Object o2 = new Object();

    @Override
    public void run() {
        System.out.println("flag=" + flag);
        if (flag == 1) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"拿到了第二把锁，等待第一把锁！");
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + "拿到了第一把锁！");
                }
            }
        }
        if (flag == 2) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "拿到了第一把锁，等待第二把锁！");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName()+"拿到了第二把锁");
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadMXBeanDetection r1 = new ThreadMXBeanDetection();
        ThreadMXBeanDetection r2 = new ThreadMXBeanDetection();
        r1.flag = 1;
        r2.flag = 2;
        new Thread(r1).start();
        new Thread(r2).start();
        Thread.sleep(1000);

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] deadlockedThreadss = threadMXBean.findDeadlockedThreads();
        if (deadlockedThreadss != null && deadlockedThreadss.length > 0) {
            for (int i =0; i < deadlockedThreadss.length; i++) {
                ThreadInfo threadInfo = threadMXBean.getThreadInfo(deadlockedThreadss[i]);
                System.out.println("发现死锁" + threadInfo.getThreadName());
            }
        }
    }
}
