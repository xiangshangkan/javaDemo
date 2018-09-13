package designPattern.creationPattern.singletonPattern;

/**
 * @Description: 饿汉模式 : 没有加锁，执行效率会提高，类加载时就初始化浪费内存
 * @Auther: Administrator
 * @Date: 2018/9/13 09:26
 */
public class HangrySingletonPattern {
    private static  HangrySingletonPattern instance = new HangrySingletonPattern();

    private HangrySingletonPattern(){}

    public static  HangrySingletonPattern getInstance(){
        return  instance;
    }
}
