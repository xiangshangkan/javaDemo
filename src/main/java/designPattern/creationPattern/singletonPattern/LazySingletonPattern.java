package designPattern.creationPattern.singletonPattern;

/**
 * @Description:  懒汉式单例模式:这种方式最大的问题是不支持多线程，不算严格意义上的单例模式，在多线程下无法正常工作
 * @Auther: Administrator
 * @Date: 2018/9/13 08:51
 */
public class LazySingletonPattern {

    private static LazySingletonPattern instance =null;

    /*将构造函数隐藏，使类外无法通过new的方式创建该对象*/
    private LazySingletonPattern(){}


    public static LazySingletonPattern getInstance(){
        if(null == instance){
            instance = new LazySingletonPattern();
        }
        return instance;
    }
}