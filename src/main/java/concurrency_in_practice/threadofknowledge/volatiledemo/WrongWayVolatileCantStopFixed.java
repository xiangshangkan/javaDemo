package concurrency_in_practice.threadofknowledge.volatiledemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *   用中断来修复刚才的无尽等待问题
 */
public class WrongWayVolatileCantStopFixed {

    public static void main(String[] args) throws InterruptedException {
        WrongWayVolatileCantStopFixed body = new WrongWayVolatileCantStopFixed();
        ArrayBlockingQueue storage = new ArrayBlockingQueue(10);
        Producer producer = body.new Producer(storage);
        Thread thread = new Thread(producer);
        thread.start();
        Thread.sleep(1000);

        Consumer consumer = body.new Consumer(storage);
        while (consumer.needMore()) {
            System.out.println(consumer.store.take() + "被消费了");
            Thread.sleep(100);
        }
        System.out.println("消费者不需要更多数据了。");

        //一旦消费者不消费了，生产者也要停止生产，但是实际情况仍然在生产
        thread.interrupt();
        producer.canceled = true;
    }


    class Producer implements Runnable {

        public volatile boolean canceled = false;

        BlockingQueue storage;

        public Producer(BlockingQueue storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            int num = 0;
            try {
                while (num <= 10000 && !Thread.currentThread().isInterrupted()) {
                    if(num%100 == 0) {
                        //这里阻塞，不会判断while条件，但在阻塞后会响应Thread.interrupted的中断
                        storage.put(num);
                        System.out.println(num+"是100的倍数。被放到仓库了");
                    }
                    num++;
                    Thread.sleep(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("生产停止了");
            }
        }
    }

    class Consumer{

        BlockingQueue store;

        public Consumer(BlockingQueue store) {
            this.store = store;
        }

        public boolean needMore(){
            return (Math.random() > 0.95);
        }
    }

}
