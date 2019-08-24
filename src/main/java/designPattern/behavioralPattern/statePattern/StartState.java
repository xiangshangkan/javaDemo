package designPattern.behavioralPattern.statePattern;

/**
 * @ClassName StartState
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/7 15:01
 * @Version 1.0
 */
public class StartState implements  State {
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }

    @Override
    public String toString(){
        return "Start state";
    }
}
