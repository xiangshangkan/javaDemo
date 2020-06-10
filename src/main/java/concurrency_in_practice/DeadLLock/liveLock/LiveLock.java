package concurrency_in_practice.DeadLLock.liveLock;

/**
 * 活锁演示：一直工作，但毫无进展（谦让）
 */
public class LiveLock {

    static class Spon{
        Dinner owner;

        public Spon(Dinner owner) {
            this.owner = owner;
        }

        public Dinner getOwner() {
            return owner;
        }

        public void setOwner(Dinner owner) {
            this.owner = owner;
        }

        public synchronized void user(){
            System.out.printf("%s has eaten" ,owner.name);
        }

    }
    static class Dinner {
       private String name;
       private boolean isHungry = true;

        public Dinner(String name) {
            this.name = name;
        }

        public void eatWith(Spon spon, Dinner spouse) {
           while (isHungry) {
               if (spon.owner != this) {
                   try {
                       Thread.sleep(1);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   continue;
               }
               //获取到勺子，判断对象是否饿
               if (spouse.isHungry) {
                   System.out.println(name + "：亲爱的"+spouse.name+"你先吃吧");
                   //将勺子让给对象
                   spon.setOwner(spouse);
                   continue;
               }
               //自己使用
               spon.user();
               isHungry = false;
               System.out.println(name + "我吃完了");
               spon.setOwner(spouse);
           }
       }
    }

    public static void  main(String args[]) {
        Dinner husband = new Dinner("牛郎");
        Dinner wife = new Dinner("织女");
        Spon spon = new Spon(husband);
        new Thread(()->{
            husband.eatWith(spon,wife);
        }).start();
        new Thread(()->{
            wife.eatWith(spon,husband);
        }).start();
    }
}
