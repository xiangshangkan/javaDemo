package designPattern.behavioralPattern.statePattern;

/**
 * @ClassName Context
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/7 15:02
 * @Version 1.0
 */
public class Context {

    private State state;

    public Context(){
        state = null;
}

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
