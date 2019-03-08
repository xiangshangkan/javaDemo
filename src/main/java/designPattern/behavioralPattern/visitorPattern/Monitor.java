package designPattern.behavioralPattern.visitorPattern;

/**
 * @ClassName Monitor
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/8 09:42
 * @Version 1.0
 */
public class Monitor implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
