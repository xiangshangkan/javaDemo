package concurrency_in_practice;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {

    private static volatile Object resourceA = new Object();
    public static void main(String[] args) {

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    try {
                        System.out.println("threadA begin wait");
                        resourceA.wait();
                        System.out.println("threadA end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    try {
                        System.out.println("threadB begin wait");
                        resourceA.notify();
                        Thread.sleep(3000);
                        System.out.println("threadB end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        a.start();
        b.start();
    }
}
