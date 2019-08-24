package concurrency_in_practice.threadofknowledge.stopthreads;

/**
 * 最佳实践:catch 了InterruptedException 之后的优先选择
 * ：在方法签名中抛出异常，那么run方法就会强制try/catch
 */
public class RightWayStopThreadInProb implements Runnable {
    @Override
    public void run() {
        while (true && Thread.currentThread().isInterrupted()) {
            System.out.println("go");
            try {
                thrInMethd();
            } catch (InterruptedException e) {
                //保存日志，停止程序
                System.out.println("保存日志");
                e.printStackTrace();
            }
        }
    }

    private void thrInMethd() throws InterruptedException {
        Thread.sleep(2000);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProb());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }

}
