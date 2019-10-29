package concurrency_in_practice.background;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 第一种  ： 运行结果出错
 *    演示计数不准确（减少），找出具体出错的位置。
 */
public class MultiThreadsError implements Runnable{
    static MultiThreadsError instance = new MultiThreadsError();
    final boolean[] marked = new boolean[1000000];

    //原子整数，满足CAS 原则(compare and swap)
    static AtomicInteger realIndex = new AtomicInteger();
    static AtomicInteger wrongCount = new AtomicInteger();

    //等待两个线程
    static volatile CyclicBarrier cyclicBarrier1 = new CyclicBarrier(2);
    static volatile CyclicBarrier cyclicBarrier2 = new CyclicBarrier(2);

    int index = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("叠加值：" + instance.index);
        System.out.println("真实次数"+realIndex.get());
        System.out.println("出错次数"+wrongCount.get());
    }

    @Override
    public void run() {
        marked[0] = true;

       for (int i =0; i< 100000;i++) {
           try {
               //所有线程执行到这步，再放开执行后续代码
               cyclicBarrier2.reset();
               cyclicBarrier1.await();
           } catch (InterruptedException e) {
               e.printStackTrace();
           } catch (BrokenBarrierException e) {
               e.printStackTrace();
           }
           index ++;
           try {
               cyclicBarrier1.reset();
               cyclicBarrier2.await();
           } catch (InterruptedException e) {
               e.printStackTrace();
           } catch (BrokenBarrierException e) {
               e.printStackTrace();
           }
           realIndex.incrementAndGet();
           synchronized (instance) {
               if(marked[index] && marked[index-1]){
                   System.out.println("发生错误" + index);
                   wrongCount.incrementAndGet();
               }
               marked[index] = true;
           }
       }
    }
}
