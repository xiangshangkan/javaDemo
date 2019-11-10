package concurrency_in_practice.jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *    volatile的适用情况1
 */
public class UseVolatile1 implements Runnable{
    volatile  boolean down=false;
    AtomicInteger realA = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new UseVolatile1();
        Thread thred1 = new Thread(r);
        Thread thread2 = new Thread(r);
        thred1.start();
        thread2.start();
        thred1.join();
        thread2.join();
        System.out.println(((UseVolatile1)r).down);
        System.out.println(((UseVolatile1)r).realA.get());
    }


    @Override
    public void run() {
        for (int i =0; i< 10000; i++) {
            flipeDown();
            realA.incrementAndGet();
        }

    }

    public void setDown() {
        down = true;
    }

    public void flipeDown(){
        down = !down;
    }
}
