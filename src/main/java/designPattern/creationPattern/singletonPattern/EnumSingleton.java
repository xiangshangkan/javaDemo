package designPattern.creationPattern.singletonPattern;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * @Description:   目前来说最好的单例模式
 * @Auther: Administrator
 * @Date: 2018/9/13 11:35
 */
public enum EnumSingleton {
    INSTANCE;

    public void show(){
        System.out.println("枚举类实现单例方式");
    }

    public static void main(String[] args){
        EnumSingleton.INSTANCE.show();
    }
}
