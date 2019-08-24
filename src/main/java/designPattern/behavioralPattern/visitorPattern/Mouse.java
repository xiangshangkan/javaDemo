package designPattern.behavioralPattern.visitorPattern;

/**
 * @ClassName Mouse
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/8 09:43
 * @Version 1.0
 */
public class Mouse implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
