package designPattern.behavioralPattern.chainOfResponsibilityPattern;

/**
 * @ClassName ErrorLogger
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/7 10:20
 * @Version 1.0
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console :: Logger" + message);
    }
}
