package designPattern.behavioralPattern.visitorPattern;

/**
 * @ClassName Keyboard
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/8 09:42
 * @Version 1.0
 */
public class Keyboard implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
