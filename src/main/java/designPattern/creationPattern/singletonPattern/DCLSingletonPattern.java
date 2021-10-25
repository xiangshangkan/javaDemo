package designPattern.creationPattern.singletonPattern;

/**
 * @Description: 双检锁/双重检验锁单例模式：根据java内存模型：执行java程序时会将使用的数据加到内存cache中，cpu运行时会
 * 使用volatile关键字可以强制将某一线程对共享变量做的修改快速的存到主存中，其他线程对应cpu缓存中的数据无效，需要从主存中
 * 重新读取
 * @Auther: Administrator
 * @Date: 2018/9/13 11:43
 */
public class DCLSingletonPattern {

    private static volatile  DCLSingletonPattern instance;

    public void show(){
        System.out.println("创建一个对象");
    }

    private DCLSingletonPattern(){}

    public static  DCLSingletonPattern getInstance(){
        if (null == instance) {
            synchronized (DCLSingletonPattern.class){
                if(null == instance){
                    instance = new DCLSingletonPattern() ;
                }
            }
        }
        return instance;
    }

    public static  void main(String[] args){
        DCLSingletonPattern.getInstance().show();
    }
}
