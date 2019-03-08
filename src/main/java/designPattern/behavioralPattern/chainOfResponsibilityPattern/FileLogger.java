package designPattern.behavioralPattern.chainOfResponsibilityPattern;

/**
 * @ClassName FileLogger
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/7 10:23
 * @Version 1.0
 */
public class FileLogger extends AbstractLogger {

    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File :: Logger" + message);
    }
}
