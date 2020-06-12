package concurrency_in_practice.DeadLLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实际工程中如何避免死锁
 * 1、设置超时时间，使用trylock避免死锁
 */
public class TryLockDeadLock implements Runnable{
    private int flag;
    static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();
    @Override
    public void run() {
        for (int i=0; i<100;i++){
            if (flag == 1) {
                try {
                if (lock1.tryLock(800, TimeUnit.MILLISECONDS)) {
                    System.out.println("线程1获取锁1成功");
                    Thread.sleep((long) (Math.random()*1000));
                        if (lock2.tryLock(800,TimeUnit.MILLISECONDS)) {
                            System.out.println("线程1获取两把锁");
                            lock1.unlock();
                            lock2.unlock();
                        } else {
                            System.out.println("线程1获取锁2失败");
                            lock1.unlock();
                            Thread.sleep((long) (Math.random()*1000));
                        }
                } else {
                    System.out.println("线程1获取锁1失败，已充实");
                }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (flag == 2) {
                try {
                    if (lock2.tryLock(800, TimeUnit.MILLISECONDS)) {
                        System.out.println("线程2获取锁2成功");
                        Thread.sleep((long) (Math.random()*1000));
                        if (lock1.tryLock(800,TimeUnit.MILLISECONDS)) {
                            System.out.println("线程2获取两把锁");
                            lock2.unlock();
                            lock1.unlock();
                        } else {
                            System.out.println("线程2获取锁1失败");
                            lock2.unlock();
                            Thread.sleep((long) (Math.random()*1000));
                        }
                    } else {
                        System.out.println("线程2获取锁2失败，已充实");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String args[]) {
        TryLockDeadLock deadLock1 = new TryLockDeadLock();
        deadLock1.flag = 1;
        TryLockDeadLock deadLock2 = new TryLockDeadLock();
        deadLock2.flag = 2;
        new Thread(deadLock1).start();
       new Thread(deadLock2).start();

    }
}
