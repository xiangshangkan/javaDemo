package designPattern.behavioralPattern.visitorPattern;

/**
 * @ClassName ComputerPart
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/8 09:41
 * @Version 1.0
 */
public interface ComputerPart {

    public void accept(ComputerPartVisitor computerPartVisitor);

}
