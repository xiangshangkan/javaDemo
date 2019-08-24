package designPattern.behavioralPattern.visitorPattern;

/**
 * @ClassName Computer
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/8 09:44
 * @Version 1.0
 */
public class Computer implements ComputerPart {

    ComputerPart[]  parts;

    public Computer() {
        this.parts = new ComputerPart[]{new Mouse(),new Keyboard(),new Monitor()};
    }


    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        for (int i = 0; i < parts.length; i++){
            parts[i].accept(computerPartVisitor);
        }
        computerPartVisitor.visit(this);
    }
}
