package designPattern.behavioralPattern.chainOfResponsibilityPattern;

/**
 * @ClassName ConsoleLogger
 * @Description 创建扩展了抽象记录器类的实体类
 * @Author zhouhui
 * @Date 2019/3/7 10:17
 * @Version 1.0
 */
public class ConsoleLogger extends AbstractLogger{

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console ::Logger" + message);
    }
}
