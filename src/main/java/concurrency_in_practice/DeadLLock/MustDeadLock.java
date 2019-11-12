package concurrency_in_practice.DeadLLock;

/**
 *   描述 ： 必定发生死锁的情况
 */
public class MustDeadLock implements Runnable{

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

    public static void main(String[] args) {
        MustDeadLock r1 = new MustDeadLock();
        MustDeadLock r2 = new MustDeadLock();
        r1.flag = 1;
        r2.flag = 2;
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}
