package designPattern.StructurePattern.facadePattern;

/**
 * @ClassName Rectangle
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/6 18:22
 * @Version 1.0
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle : draw()");
    }
}
