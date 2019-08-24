package designPattern.StructurePattern.DecoratorPattern;

/**
 * @ClassName Circle
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/6 17:53
 * @Version 1.0
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape:Circle");
    }
}
