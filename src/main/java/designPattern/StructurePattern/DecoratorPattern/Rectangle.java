package designPattern.StructurePattern.DecoratorPattern;

/**
 * @ClassName Rectangle
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/6 17:52
 * @Version 1.0
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape:Rectangle");
    }
}
