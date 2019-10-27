package concurrency_in_practice.threadofknowledge.threadobjectclasscommonmethods;

/**
 * 演示join 期间被中断的效果
 */
public class JoinInterrupt {

    public static void main(String[] args){
        Thread mainThread = Thread.currentThread();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    //在子线程里中断主线程，子线程仍然继续执行
                    mainThread.interrupt();
                    System.out.println("子线程"+Thread.currentThread().getName() + "finished");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        System.out.println("等待子线程运行完毕！");
        try {
            thread1.join();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "主线程中断了！");
            //这里在主线程中断后，要同时中断子线程，否则就不一致
            thread1.interrupt();
            e.printStackTrace();
        }
        //输出语句还能运行时因为主线程中断异常被catch掉了
        System.out.println("子线程已运行完毕！");
    }
}
