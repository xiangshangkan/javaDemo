package designPattern.behavioralPattern.strategyPattern;

/**
 * @ClassName StrategyPatternDemo
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/8 09:07
 * @Version 1.0
 */
public class StrategyPatternDemo {
    public static void main(String[] args){
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5" + context.executeStrategy(10,5));

        context = new Context(new OperationSubstract());
        System.out.println("10 - 5" + context.executeStrategy(10,5));

        context = new Context(new OperationMultiply());
        System.out.println("10 * 5" + context.executeStrategy(10,5));
    }
}
