package concurrency_in_practice.threadofknowledge.uncaughtexception;

/**
 * 使用自己写的全局处理器 MyUncaughtExceptionHandler
 */
public class UseOwnUncaughtExceptionHandler implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler("异常处理器1"));

        new Thread(new UseOwnUncaughtExceptionHandler(),"MyThread-2").start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandler(),"MyThread-3").start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandler(),"MyThread-4").start();
        Thread.sleep(300);
    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}
