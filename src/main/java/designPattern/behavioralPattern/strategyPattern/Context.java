package designPattern.behavioralPattern.strategyPattern;

/**
 * @ClassName Context
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/8 09:05
 * @Version 1.0
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1,num2);
    }

}
