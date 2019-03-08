package designPattern.behavioralPattern.ObserverPattern;

/**
 * @ClassName HexaObserver
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/7 14:37
 * @Version 1.0
 */
    public class HexaObserver extends Observer {

    public HexaObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String : " + Integer.toHexString(subject.getState()).toUpperCase());
    }
}
