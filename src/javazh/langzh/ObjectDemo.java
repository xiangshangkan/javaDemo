package javazh.langzh;


import sun.rmi.server.UnicastServerRef;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @auther: Administrator
 * @date: 2018/10/22 20:56
 */
public class ObjectDemo {

    public static void main(String[] args){
        Integer a = null;
        Integer b = 3;
        Integer c = null;

        System.out.println(Objects.equals(null,3));
        System.out.println(a == b);
        System.out.println(a != null);
        System.out.println(Objects.equals(a,c));

        User user = new User();
        System.out.println(user.getNumber());
        System.out.println(Objects.equals(user.getNumber(),2));
        //System.out.println(user.getNumber() != 2);
    }

    //Object List 泛型 添加不同类型数据
    public void ObjectDemo1(){
        List<Object> objectList = new ArrayList<>();
        objectList.add(new Integer(2));
        objectList.add("3");
        objectList.add(true);
        User user = new User();
        Thing thing = new Thing();

        objectList.add(user);
        objectList.add(thing);
        System.out.println(objectList);
    }

    public void ObjectDemo2(){
        List<Object> objectList = new ArrayList<>();

        User user = new User();
        user.setNumber(1);
        Thing thing = new Thing();
        thing.setNumber(2);


        objectList.add(thing);
        objectList.add(user);
        System.out.println(objectList);

    }


}


class User{

    private String name;

    private Integer number= null;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}

class Thing{
    private String name;

    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Thing{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
