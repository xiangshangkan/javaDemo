package designPattern.behavioralPattern.mediatorPattern;

/**
 * @ClassName MediatorPatternDemo
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/7 12:26
 * @Version 1.0
 */
public class MediatorPatternDemo {

    public static void main(String[] args){
        User robert = new User("Robert");
        User john = new User("John");
        robert.sendMessage("Hi! John");
        john.sendMessage("Hello!  Robert");

    }
}
