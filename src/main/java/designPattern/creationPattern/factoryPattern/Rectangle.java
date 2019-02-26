package designPattern.creationPattern.factoryPattern;
/**
 * 创建实现接口的实现类
 * */
public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Rectangle : draw()");
    }
}
