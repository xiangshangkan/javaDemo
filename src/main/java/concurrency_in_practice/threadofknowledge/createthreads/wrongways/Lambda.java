package concurrency_in_practice.threadofknowledge.createthreads.wrongways;

/**
 *  lambda表达式创建线程
 */
public class Lambda {

    public static void main(String[] args) {
        new Thread(()->System.out.println(Thread.currentThread().getName())).start();
    }
}
