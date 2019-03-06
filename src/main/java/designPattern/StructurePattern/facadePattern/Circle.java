package designPattern.StructurePattern.facadePattern;

/**
 * @ClassName Circle
 * @Description 创建实现接口的实体类
 * @Author zhouhui
 * @Date 2019/3/6 18:21
 * @Version 1.0
 */
public class Circle implements  Shape{
    @Override
    public void draw() {
        System.out.println("Circle : draw()");
    }
}
