package designPattern.behavioralPattern.visitorPattern;

/**
 * @ClassName ComputerPartVisitor
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/8 09:50
 * @Version 1.0
 */
public interface ComputerPartVisitor {

    public void visit(Computer computer);
    public void visit(Mouse mouse);
    public void visit(Keyboard keyboard);
    public void visit(Monitor monitor);

}
