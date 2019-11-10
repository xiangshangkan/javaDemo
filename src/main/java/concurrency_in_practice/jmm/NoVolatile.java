package concurrency_in_practice.jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 不适用于volatile的场景
 */
public class NoVolatile implements Runnable{
    volatile  int a=0;
    AtomicInteger realA = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new NoVolatile();
        Thread thred1 = new Thread(r);
        Thread thread2 = new Thread(r);
        thred1.start();
        thread2.start();
        thred1.join();
        thread2.join();
        System.out.println(((NoVolatile)r).a);
        System.out.println(((NoVolatile)r).realA.get());
    }


    @Override
    public void run() {
        for (int i =0; i< 10000; i++) {
            a++;
            realA.incrementAndGet();
        }

    }
}
