package designPattern.behavioralPattern.interpreterPattern;

/**
 * @ClassName AndExpression
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/7 11:11
 * @Version 1.0
 */
public class AndExpression implements Expression {

    private Expression expre1 = null;
    private Expression expre2 = null;

    public AndExpression(Expression expre1, Expression expre2) {
        this.expre1 = expre1;
        this.expre2 = expre2;
    }

    @Override
    public boolean interpret(String context) {
        return expre1.interpret(context) && expre2.interpret(context);
    }

}
