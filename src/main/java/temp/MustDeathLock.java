package temp;

public class MustDeathLock  implements Runnable{

    int flag = 1;
    static Object o1 = new Object();
    static Object o2 = new Object();


    @Override
    public void run() {
        if (flag == 1) {
            synchronized (o1) {
                System.out.println("拿到了第一把锁，等待第二把锁");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("两把锁都拿到了");
                }
            }
        } else {
            synchronized (o2) {
                System.out.println("拿到了第二把锁，等待第一把锁");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("拿到了两把锁");
                }
            }
        }
    }

    public static void main(String args[]) {
        MustDeathLock death1 = new MustDeathLock();
        MustDeathLock death2 = new MustDeathLock();
        death1.flag = 1;
        death2.flag = 2;
        new Thread(death1).start();
        new Thread(death2).start();
    }
}
