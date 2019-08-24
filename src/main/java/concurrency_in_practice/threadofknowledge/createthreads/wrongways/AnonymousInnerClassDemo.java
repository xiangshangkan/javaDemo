package concurrency_in_practice.threadofknowledge.createthreads.wrongways;


/**
 * 以匿名内部类的方式创建线程
 */
public class AnonymousInnerClassDemo {

    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
              System.out.println(
                      Thread.currentThread().getName());
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
    }

}
