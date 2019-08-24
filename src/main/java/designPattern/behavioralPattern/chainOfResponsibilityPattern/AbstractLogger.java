package designPattern.behavioralPattern.chainOfResponsibilityPattern;

/**
 * @ClassName AbstractLogger
 * @Description 创建抽象的记录器类
 * @Author zhouhui
 * @Date 2019/3/7 10:11
 * @Version 1.0
 */
public abstract class AbstractLogger {

    public static int info = 1;
    public static int debug = 2;
    public static int error = 3;

    protected int level;

    //责任链中的下一个元素
    protected  AbstractLogger nextLogger;

    public void setNextLooger(AbstractLogger nextLogger){
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if(this.level <= level) {
            write(message);
        }
        if(nextLogger != null) {
            nextLogger.logMessage(level,message);
        }
    }

    abstract protected void write(String message);
}
