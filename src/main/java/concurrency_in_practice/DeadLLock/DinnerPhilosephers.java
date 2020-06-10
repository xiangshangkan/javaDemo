package concurrency_in_practice.DeadLLock;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * 演示哲学家就餐问题导致的死锁
 */
public class DinnerPhilosephers {

    public  static class Philosepher implements Runnable {

        private Object leftChopstick;
        private Object rightChopstick;

        public Philosepher(Object leftChopstick, Object rightChopstick) {
            this.leftChopstick = leftChopstick;
            this.rightChopstick = rightChopstick;
        }

        @Override
        public void run() {
            try {
                doAction("just thingking");
                while (true) {
                    synchronized (leftChopstick)  {
                        doAction("get leftChopstick");
                        synchronized (rightChopstick) {
                            doAction("get rightChopstick");
                        }
                    }
                    doAction("just esating");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void doAction(String action) throws InterruptedException {
            Thread.sleep((long) (Math.random()*10));
            System.out.println(Thread.currentThread().getName() + " " +action);
        }

        public static void main(String args[]) {
            Philosepher[] philosepher = new Philosepher[5];
            Object[] chopsticks = new Object[philosepher.length];
            for (int i = 0; i< 5 ;i++) {
                chopsticks[i] = new Object();
            }
            for (int i =0; i<5;i++) {
                philosepher[i] = new Philosepher(chopsticks[i],chopsticks[(i+1)%5]);
                new Thread(philosepher[i],"哲学家" + (i+1)).start();
            }

        }
    }
}
