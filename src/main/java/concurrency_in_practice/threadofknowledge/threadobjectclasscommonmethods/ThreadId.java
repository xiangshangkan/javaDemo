package concurrency_in_practice.threadofknowledge.threadobjectclasscommonmethods;

/**
 * 描述 ： ID 从1开始，JVM运行起来后，我们自己创建的线程的ID早已不是2,而且jvm背后就创建了很多其他线程
 */
public class ThreadId {


    public static void main(String[] args) {
        Thread thread = new Thread();
        System.out.println("主线程的ID" + Thread.currentThread().getId());
        System.out.println("子线程的ID"+ thread.getId());
    }
}
