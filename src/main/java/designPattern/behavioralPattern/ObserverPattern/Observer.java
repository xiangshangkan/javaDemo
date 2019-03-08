package designPattern.behavioralPattern.ObserverPattern;

/**
 * @ClassName Observer
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/7 14:20
 * @Version 1.0
 */
public abstract class Observer {
    protected  Subject subject;
    public abstract  void update();
}
