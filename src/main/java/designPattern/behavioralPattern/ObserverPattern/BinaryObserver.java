package designPattern.behavioralPattern.ObserverPattern;

/**
 * @ClassName BinaryObserver
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/7 14:25
 * @Version 1.0
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String :" + Integer.toBinaryString(subject.getState()));
    }
}
