package designPattern.behavioralPattern.mementoPattern;

/**
 * @ClassName Originator
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/7 13:50
 * @Version 1.0
 */
public class Originator {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveStateToMemento(){
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento){
        state = memento.getState();
    }

}
