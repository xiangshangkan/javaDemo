package designPattern.behavioralPattern.CommandPattern;
/**
 * 创建命令调用类
 * */
import java.util.ArrayList;
import java.util.List;

public class Broker {
    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order){
        //定义对象数组，添加不同的动作或命令
        orderList.add(order);
    }
    //执行动作或命令
    public void placeOrders(){
        for(Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
