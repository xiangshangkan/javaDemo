package designPattern;

import designPattern.creationPattern.singletonPattern.LazySingletonPattern;

public class Test {


    @org.junit.Test
    public void name() {
//        LazySingletonPattern singletonPattern = LazySingletonPattern.getInstance();
        Thread t1 = new Thread(new T());
        Thread t2 = new Thread(new T());
        t1.start();
        t2.start();
        System.out.println("线程不安全！" );
    }
}
