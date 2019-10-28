package concurrency_in_practice.threadofknowledge.uncaughtexception;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 通过实现Thread.UncaughtExceptionHandler接口，实现全局异常处理
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    private String name;

    public MyUncaughtExceptionHandler(String name) {
        this.name = name;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.WARNING,"线程异常，中止了"+t.getName() ,e);
        System.out.println(name + "捕获了异常"+t.getName() + "异常"+ e);
    }
}
