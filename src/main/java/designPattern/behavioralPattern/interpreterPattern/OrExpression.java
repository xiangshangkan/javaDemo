package designPattern.behavioralPattern.interpreterPattern;

/**
 * @ClassName OrExpression
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/7 11:08
 * @Version 1.0
 */
public class OrExpression implements  Expression {

    private Expression expre1 = null;
    private Expression expre2 = null;

    public OrExpression(Expression expre1, Expression expre2) {
        this.expre1 = expre1;
        this.expre2 = expre2;
    }

    @Override
    public boolean interpret(String context) {
        return expre1.interpret(context) || expre2.interpret(context);
    }
}
