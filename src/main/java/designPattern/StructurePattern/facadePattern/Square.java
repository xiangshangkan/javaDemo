package designPattern.StructurePattern.facadePattern;

/**
 * @ClassName Square
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/6 18:23
 * @Version 1.0
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square : draw()");
    }
}
