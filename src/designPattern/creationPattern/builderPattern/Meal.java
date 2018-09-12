package designPattern.creationPattern.builderPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 创建一个套餐类
 * @Auther: Administrator
 * @Date: 2018/9/12 11:07
 */
public class Meal {

    //套餐内食物集合
    private List<Item> itemList = new ArrayList<>();

    /**
    * @Description  定义套餐内食物
    * @author      作者姓名
    * @param
    * @return
    * @exception
    * @date        2018/9/12 11:18
    */
    public void addItem(Item item){
        if(null != item){
            itemList.add(item);
        }
    }

    /**
    * @Description   计算套餐总价
    * @author      作者姓名
    * @param
    * @return
    * @exception
    * @date        2018/9/12 11:19
    */
    public float totalPrice(){
        float total = 0.0f;
        if(null != itemList && itemList.size() >0){
            for (Item item:itemList) {
                total += item.price();
            }
        }
        return total;
    }

    /**
    * @Description   套餐展示
    * @author      作者姓名
    * @param
    * @return
    * @exception
    * @date        2018/9/12 11:19
    */
    public void showMeal(){
        if(null != itemList && itemList.size() >0){
            for (Item item:itemList) {
                System.out.println(item.name() + " 包装：" + item.packing().pack() + " 单价：" + item.price());
            }
            System.out.println("总价：" + totalPrice());
        }
    }


}
