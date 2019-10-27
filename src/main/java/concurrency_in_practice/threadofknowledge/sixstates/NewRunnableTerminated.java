package concurrency_in_practice.threadofknowledge.sixstates;

/**
 *  展示线程的NEW、RUNNAble、Terminated状态。即使是正在运行，
 *  也是Runnable状态，而不是Running
 */
public class NewRunnableTerminated implements Runnable{

    public static void main(String[] args) {
        Thread thread = new Thread(new NewRunnableTerminated());
        //打印出NEW的状态
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出Runnable状态，即使是正在运行，也是Runnable，而不是Running
        System.out.println(thread.getState());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出terminated 状态,
        System.out.println(thread.getState());
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000;i++) {
            System.out.println(i);
        }
    }
}
