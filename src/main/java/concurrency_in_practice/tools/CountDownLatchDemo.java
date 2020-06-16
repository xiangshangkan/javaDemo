package concurrency_in_practice.tools;

import java.util.concurrent.CountDownLatch;

/**
 * @Description:
 * @Author: Zohar
 * @Date: 2020/6/15 20:39
 * @Version: 1.0
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        new CountDownLatchDemo().go();
    }


    private void go() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        //依次创建三个线程，并启动
        new Thread(new Task(countDownLatch),"Thread1").start();
        Thread.sleep(1000);
        new Thread(new Task(countDownLatch),"Thread2").start();
        Thread.sleep(1000);
        new Thread(new Task(countDownLatch),"Thread3").start();
        countDownLatch.await();
        System.out.println("所有线程已到达，主线程开始执行，" + System.currentTimeMillis());

    }

    class Task implements  Runnable{

        private CountDownLatch countDownLatch;

        public Task(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "已经到达，" + System.currentTimeMillis());
            countDownLatch.countDown();
            System.out.println("CountDownLatch 和 CyclicBarrier不同，子线程不阻塞继续执行，name = " + Thread.currentThread().getName());
        }
    }
}
