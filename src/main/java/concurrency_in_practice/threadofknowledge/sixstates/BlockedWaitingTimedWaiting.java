package concurrency_in_practice.threadofknowledge.sixstates;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Date;

/**
 * 打印 Blocked、Waiting、TimedWaiting三种线程状态
 */
public class BlockedWaitingTimedWaiting implements Runnable{

    public static void main(String[] args) {
        BlockedWaitingTimedWaiting runnable = new BlockedWaitingTimedWaiting();
        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread thread2 = new Thread(runnable);
        thread2.start();
        try {
            //这里加个主线程睡眠是
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出TimedWaiting状态，因为正在执行Thread.sleep(1000)；
        System.out.println(thread1.getState());
        //打印出BLOCKED状态，因为thread2想拿到syn()的锁却拿不到
        System.out.println(thread2.getState());
        try {
            Thread.sleep(1300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出Waiting 状态，因为执行了Object.wait()方法
        System.out.println(thread1.getState());
    }

    @Override
    public void run() {
        syn();
    }

    private  synchronized void syn(){
        try {
            Thread.sleep(1000);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
