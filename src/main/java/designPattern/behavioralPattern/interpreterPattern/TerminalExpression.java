package designPattern.behavioralPattern.interpreterPattern;

/**
 * @ClassName TerminalExpression
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/7 11:04
 * @Version 1.0
 */
public class TerminalExpression implements Expression{

    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        if(context.contains(data)) {
            return true;        }
        return false;
    }
}
