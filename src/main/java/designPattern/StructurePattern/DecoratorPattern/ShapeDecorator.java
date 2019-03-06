package designPattern.StructurePattern.DecoratorPattern;

/**
 * @ClassName ShapeDecorator
 * @Description 创建实现了Shape接口的抽象装饰类
 * @Author zhouhui
 * @Date 2019/3/6 17:54
 * @Version 1.0
 */
public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape ;

    public ShapeDecorator(Shape shape){
        this.decoratedShape = shape;
    }

    public void draw(){
        this.decoratedShape.draw();
    }
}
