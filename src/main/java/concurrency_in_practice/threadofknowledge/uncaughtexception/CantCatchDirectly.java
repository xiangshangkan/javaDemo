package concurrency_in_practice.threadofknowledge.uncaughtexception;

/**
 * 描述
 * 1、不加try catch 抛出4个异常，都带线程名字
 * 2、加了try catch ,期望捕获到第一个线程的异常，线程 234不应该运行，希望看到打印出Caught Exception
 * 3、执行时发现，根本没有Caught Exception, 线程234依然运行并且抛出异常
 * 说明线程的异常不能用传统方式捕获
 */
public class CantCatchDirectly implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        try {
            new Thread(new CantCatchDirectly(),"MyThread-1").start();
            Thread.sleep(300);
            new Thread(new CantCatchDirectly(),"MyThread-2").start();
            Thread.sleep(300);
            new Thread(new CantCatchDirectly(),"MyThread-3").start();
            Thread.sleep(300);
            new Thread(new CantCatchDirectly(),"MyThread-4").start();
            Thread.sleep(300);

        }catch (RuntimeException e) {
            //这里时捕获不到子线程中抛出的异常的，因为try catch 操作是在主线程中
           System.out.println();
        }
    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}
