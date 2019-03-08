package designPattern.behavioralPattern.mementoPattern;

/**
 * @ClassName Memento
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/7 13:48
 * @Version 1.0
 */
public class Memento {

    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
