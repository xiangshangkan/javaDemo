package concurrency_in_practice.threadofknowledge.stopthreads;

/**
 *  描述：    如果while里面放try/catch，会导致中断失效
 */
public class CantInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = ()->{
                int num = 0;
                while (num <= 100) {
                    System.out.println(num++ + "是100的倍数");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        //只会捕捉到一次异常，因为发生一次中断(Thread抛出InterruptedException异常)后会
                        //抹去中断标记，Thread.currentThread().isInterrupted()会显示为false
                        e.printStackTrace();
                    }
                }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(100);
        //通知中断，线程在运行中，一般不响应中断通知
        thread.interrupt();
    }
}
