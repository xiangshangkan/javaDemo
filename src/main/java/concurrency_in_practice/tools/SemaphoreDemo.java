package concurrency_in_practice.tools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Description: Semaphore 只允许规定数量的线程访问，当线程到达限制数时，新的线程需要等待正在访问的其中之一线程的线程释放，才可继续执行
 * @Author: Zohar
 * @Date: 2020/6/15 21:02
 * @Version: 1.0
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        //线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        //只能5个线程同时访问
        final Semaphore semaphore = new Semaphore(5);
        //模拟20个客户端访问
        for (int i = 0; i < 20; i++) {
            final int NO = i;
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
                        //获取许可
                        semaphore.acquire();
                        System.out.println("Accessing:" + NO);
                        Thread.sleep((long) (Math.random() * 10000));
                        //访问完后，释放
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            exec.execute(run);
        }
        //退出线程池
        exec.shutdown();
    }
}
