package designPattern.behavioralPattern.visitorPattern;

/**
 * @ClassName VisitorPatternDemo
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/8 11:54
 * @Version 1.0
 */
public class VisitorPatternDemo {

    public static void main(String[] args){
        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }

}
