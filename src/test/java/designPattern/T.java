package designPattern;

import designPattern.creationPattern.singletonPattern.LazySingletonPattern;

public class T implements  Runnable {
    @Override
    public void run() {
        LazySingletonPattern singletonPattern = LazySingletonPattern.getInstance();
        System.out.println("多线程： "+ singletonPattern);
    }
}
