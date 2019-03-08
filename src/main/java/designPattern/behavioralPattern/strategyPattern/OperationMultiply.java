package designPattern.behavioralPattern.strategyPattern;

/**
 * @ClassName OperationMultiply
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/8 09:05
 * @Version 1.0
 */
public class OperationMultiply implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
