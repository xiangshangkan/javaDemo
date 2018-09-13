package designPattern.creationPattern.singletonPattern;

/**
 * @Description:  这种方式同样利用了 classloader 机制来保证初始化 instance 时只有一个线程,当加载 登记式_静态内部类时，并没有初始化实例对象，
 *                而是在调用getInstance()方法时加载静态内部类SingleHolder，从而初始化单例对象
 * @Auther: Administrator
 * @Date: 2018/9/13 11:16
 */
public class 登记式_静态内部类 {

    public void show(){
        System.out.println("成功使用该单例模式");
    }

    private static  class  SingleHolder{
        private static final 登记式_静态内部类 instance = new 登记式_静态内部类();
    }

    private 登记式_静态内部类(){}

    public static 登记式_静态内部类 getInstance(){
        return  SingleHolder.instance;
    }

    public static  void main(String[] args){
        登记式_静态内部类 instance = 登记式_静态内部类.getInstance();
        instance.show();
    }
}
