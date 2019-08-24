package designPattern.creationPattern.singletonPattern;

/**
 * @Description: 线程安全的懒汉模式：能够在多线程环境下云合作，在类第一次创建时才会初始化，节约了内存，但因为加锁影响效率，实际场景中大部分是不需要同步的
 * @Auther: Administrator
 * @Date: 2018/9/13 09:04
 */
public class LazySynchPattern {

    private static LazySynchPattern instance;

    private LazySynchPattern(){}

    public static synchronized LazySynchPattern getInstance(){
        if(null == instance){
            instance = new LazySynchPattern();
        }
        return null;
    }
}
