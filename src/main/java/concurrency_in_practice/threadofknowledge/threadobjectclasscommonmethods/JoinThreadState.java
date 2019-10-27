package concurrency_in_practice.threadofknowledge.threadobjectclasscommonmethods;

/**
 * 描述 ：    先join 再mainThread.getState()
 *  通过debugger 看线程join 前后状态的对比
 */
public class JoinThreadState {

    public static  void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println(mainThread.getState());
                    System.out.println("Thread 0 运行结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        System.out.println("等待子线程运行完毕！");
        thread1.join();
        System.out.println("子线程运行完毕！");
    }
}
