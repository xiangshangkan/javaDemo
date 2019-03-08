package designPattern.behavioralPattern.strategyPattern;

/**
 * @ClassName OperationSubstract
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/8 09:04
 * @Version 1.0
 */
public class OperationSubstract implements  Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
