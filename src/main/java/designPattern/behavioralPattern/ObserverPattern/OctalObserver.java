package designPattern.behavioralPattern.ObserverPattern;

/**
 * @ClassName OctalObserver
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/7 14:28
 * @Version 1.0
 */
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String : " + Integer.toHexString(subject.getState()).toUpperCase());
    }
}
