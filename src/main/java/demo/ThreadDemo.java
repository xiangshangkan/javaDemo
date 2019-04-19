package demo;

/**
 * @ClassName ThreadDemo
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/4/19 11:21
 * @Version 1.0
 */
public class ThreadDemo {

    public static void main(String[] args) {
        Thread t0 = Thread.currentThread();
        Thread t1 = new Thread(new TheadTest("thread 1"));
        Thread t2 = new Thread(new TheadTest("thread 2"));
        Thread t3 = new Thread(new TheadTest("thread 3"));
       /* for(int i = 0; i < 100; i++) {
            System.out.println(t0.getName());
        }*/
        t1.start();
        t2.start();
        t3.start();
    }
}
