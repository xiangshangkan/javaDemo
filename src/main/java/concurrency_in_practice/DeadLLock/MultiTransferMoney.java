package concurrency_in_practice.DeadLLock;

import java.util.Random;

/**
 * 描述 ： 多人同时转账，依然很危险
 */
public class MultiTransferMoney {

    private static final int NUM_ACCOUNTS = 500000;
    private static final int NUM_MONEDY = 1000;
    private static final int NUM_ITERATIONS = 100000;
    private static final int NUM_THREADS = 1000;


    public static void main(String[] args) {
        Random rnd  = new Random();
        Account[] accounts = new Account[NUM_ACCOUNTS];
        for (int i =1; i< accounts.length;i++){
            accounts[i] = new Account(NUM_MONEDY,"account"+i);
        }
        class TransferThread extends Thread {

            @Override
            public void run() {
               for (int i =0; i< NUM_ITERATIONS;i++) {
                   int fromAcct = rnd.nextInt(NUM_ACCOUNTS);
                   int toAcct = rnd.nextInt(NUM_ACCOUNTS);
                   int amount = rnd.nextInt(NUM_MONEDY);
                   transfer(accounts[fromAcct],accounts[toAcct],amount);
               }
            }
        }

        for (int i =0;i<NUM_THREADS;i++) {
            new TransferThread().start();

        }
    }

    static class Account{
        String name ;

        int balance;

        public String getName() {
            return name;
        }

        public int getBalance() {
            return balance;
        }

        public Account( int balance,String name) {
            this.name = name;
            this.balance = balance;
        }
    }

    public static void transfer(Account in , Account out, int count){
        synchronized (in) {
            System.out.println(Thread.currentThread().getName() + "拿到了"+in.getName()+"等待" +out.getName());
           /* try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            synchronized (out) {
                System.out.println(Thread.currentThread().getName()+"被拿到了！");
                if (out.balance - count < 0) {
                    System.out.println("余额不足,转账失败！");
                    return;
                }
                out.balance -= count;
                in.balance += count;
                System.out.println("转账成功！");
            }
        }

    }

}
