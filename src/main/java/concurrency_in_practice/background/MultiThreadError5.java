package concurrency_in_practice.background;


/**
 *   描述 ： 观察者模式
 */
public class MultiThreadError5 {

    int count;

    public static void main(String[] args) {
        MySource source = new MySource();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //10秒胡出发监听器
                source.eventCome(new Event() {
                });
            }
        }).start();
        //注册监听器
        MultiThreadError5 multiThreadError5 = new MultiThreadError5(source);
    }

    public MultiThreadError5(MySource source) {
        //注册监听器，并定义监听器监听后的响应行为
        source.registerListener(new EventListener() {
            @Override
            public void onEvent(Event e) {
                System.out.println("\n我得到的数字是"+count);
            }
        });
        //在子线程中触发监听器，可能在count = 100 前响应打印，也可能是在count = 100 之后
        for (int i =0; i< 10000; i++) {
            System.out.print(i);
        }
        count = 100;
    }

    static class MySource{
        private EventListener listener;

        void registerListener(EventListener eventListener) {
                this.listener = eventListener;
        }

        void eventCome(Event event) {
            if (listener != null) {
                listener.onEvent(event);
            } else {
                System.out.println("还未初始化完毕！");
            }
        }


    }

    interface  EventListener{
        void onEvent(Event  e);

    }

    interface Event{}
}

