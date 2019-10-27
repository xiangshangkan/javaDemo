package concurrency_in_practice.threadofknowledge.threadobjectclasscommonmethods;

/**
 * 通过讲解join 原理，分析join的代替写法
 */
public class JoinPrinciple {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("Thread 1 运行结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        System.out.println("开始等待子线程运行完毕");
        thread1.join();
        System.out.println("所有子线程执行完毕！");
    }
}
