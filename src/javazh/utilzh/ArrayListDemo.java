package javazh.utilzh;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: Administrator
 * @Date: 2018/9/17 09:16
 */
public class ArrayListDemo {

    public void arrayListDemo1(){
        List<String> abc = new ArrayList<String>();
        abc.add("哈哈");
        abc.add("嘿嘿");
        //数组越界异常
        if(null !=abc.get(2) ){
            System.out.println("有值得");
        }
    }

    public void arrayListDemo2(){
        List<String> abc = new ArrayList<String>();
        //foreach遍历数组，数组长度可以为0不会发生数组越界异常，但不可为null，否则报NUllPointException
        for (String str:abc) {
            System.out.println(str);
        }
    }

    public void arrayListDemo3(){
        List<String> abc = new ArrayList<>();
        for(int i = 0; i < 10; i++ ){
            abc.add(i+"1");
        }
        System.out.println(abc.subList(0,4));
    }
}
