package designPattern.behavioralPattern.statePattern;

/**
 * @ClassName StopState
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/7 15:05
 * @Version 1.0
 */
public class StopState implements State {
    @Override
    public void doAction(Context comtext) {
        System.out.println("Player is in stop state");
        comtext.setState(this);
    }

    @Override
    public String toString(){
        return "stop state";
    }
}
