package concurrency_in_practice.threadofknowledge.stopthreads;

/**
 *  最佳实践2 ：在catch 子语句中调用Thread.currentThread().interrupt()
 *  来恢复设置中断状态以便于在后续的执行中，依然能够检查到刚才发生了中断
 *  回到刚才RightWayStopThreadInProb 不补中断， 让它跳出
 */
public class RightWayStopThreadProb2 implements Runnable{


    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted，程序运行结束");
                break;
            }
            thrInMethd();
        }
    }
    private void thrInMethd() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            //捕获异常，重新中断标志
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadProb2());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
