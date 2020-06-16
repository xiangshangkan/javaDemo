package concurrency_in_practice.tools;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description: ${description}
 * @Author: Zohar
 * @Date: 2020/6/15 20:53
 * @Version: 1.0
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        new CyclicBarrierDemo().go();
    }


    public void go(){
        //初始化栅栏的参与者数为3
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        //依次创建3个线程并启动
        new Thread(new Task(cyclicBarrier),"Thread1").start();
        new Thread(new Task(cyclicBarrier),"Thread2").start();
        new Thread(new Task(cyclicBarrier),"Thread3").start();
        System.out.println("全部线程已到达");
    }


    class Task implements Runnable {
        private CyclicBarrier cyclicBarrier;

        public Task(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }
        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "已到达，" + System.currentTimeMillis());
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("CyclicBarrier 与CountDownLatch不同， 子线程会被阻塞，直到计数器为0" + Thread.currentThread().getName() + "已到达，" + System.currentTimeMillis());
        }
    }
}
