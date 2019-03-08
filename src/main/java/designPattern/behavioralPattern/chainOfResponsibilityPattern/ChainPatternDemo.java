package designPattern.behavioralPattern.chainOfResponsibilityPattern;

/**
 * @ClassName ChainPatternDemo
 * @Description 创建不同类型的记录器，赋予他们不同的错误级别，并在每个记录器中设置下一个记录器，每个记录器中的下一个记录器代表的
 *              是链的一部分
 * @Author zhouhui
 * @Date 2019/3/7 10:24
 * @Version 1.0
 */
public class ChainPatternDemo {

    private static AbstractLogger getChainOfLoggers(){

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.error);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.debug);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.info);

        errorLogger.setNextLooger(fileLogger);
        fileLogger.setNextLooger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.info,"This is an information");

        loggerChain.logMessage(AbstractLogger.debug,"This is an debug level information");

        loggerChain.logMessage(AbstractLogger.error,"this is an error information");
    }

}
