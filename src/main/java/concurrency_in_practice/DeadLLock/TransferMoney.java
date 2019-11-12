package concurrency_in_practice.DeadLLock;

import org.apache.poi.poifs.crypt.DataSpaceMapUtils;

/**
 *  描述：转账时遇到死锁，一旦打开注释，就会发生死锁
 */
public class TransferMoney implements  Runnable{
    static Account a = new Account(500,"周");
    static  Account b = new Account(500,"辉");
    int flag = 0;

    @Override
    public void run() {
        if (flag == 1) {
            transfer(a,b,200);
        }
        if (flag == 2) {
            transfer(b,a,200);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TransferMoney r1 = new TransferMoney();
        TransferMoney r2 = new TransferMoney();
        r1.flag = 1;
        r2.flag = 2;

        Thread t1 = new Thread(r1);
        t1.start();
        t1.join();
        Thread t2 = new Thread(r2);
        t2.start();
        t2.join();
        System.out.println("a 的余额"+ r1.a.balance);
        System.out.println("b 的余额"+ r1.b.balance);
    }

    public static void transfer(Account in ,Account out,int count){
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
}
