package concurrency_in_practice.background;


import java.util.HashMap;
import java.util.Map;

/**
 *  描述： 构造函数中新建线程
 */
public class MultiThreadsError6 {

    private Map<String,String> states;

    public MultiThreadsError6() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                states = new HashMap<>();
                states.put("1","周一");
                states.put("2","周二");
                states.put("3","周三");
                states.put("4","周四");
            }
        }).start();
}

    public Map<String,String> getStates(){
        return states;
    }

    public static void main(String[] args) throws InterruptedException {
        MultiThreadsError6 multiThreadsError6 = new MultiThreadsError6();
        //加入没有加延时处理，MultiThreadsError6构造函数中的子线程中还未对states初始化，下一步获取的states是 null ,就会产生异常
        Thread.sleep(100);
        Map<String,String> states = multiThreadsError6.getStates();
        System.out.println(states.get("1"));
       /* states.remove("1");
        System.out.println(states.get( "1"));*/
    }
}
