package designPattern.behavioralPattern.strategyPattern;

/**
 * @ClassName OperationAdd
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/8 09:02
 * @Version 1.0
 */
public class OperationAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
