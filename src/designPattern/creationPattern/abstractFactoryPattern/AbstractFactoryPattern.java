package designPattern.creationPattern.abstractFactoryPattern;
/*
*抽象工厂模式,使用FactoryProducer来获取AbstractFactory,通过传递类型信息来获取实体类的对象
*/
public class AbstractFactoryPattern {
    public static void main(String[] args)
    {
        //获取形状工厂
        AbstractFactory shapeFactory=FactoryProducer.getFactory("SHAPE");

        //获取形状为Circle的对象，调用它的draw方法
        Shape shape1=shapeFactory.getShape("Circle");
        shape1.draw();

        //获取形状为Rectangle的对象，调用它的draw方法
        Shape shape2=shapeFactory.getShape("Rectangle");
        shape2.draw();

        //获取形状为Square的对象，调用它的draw方法
        Shape shape3=shapeFactory.getShape("Square");
        shape3.draw();



        //获取颜色工厂
        AbstractFactory colorFactory=FactoryProducer.getFactory("Color");

        //获取颜色为Red的对象，调用它的fill方法
        Color color1=colorFactory.getColor("Red");
        color1.fill();

        //获取颜色为Green 的对象，调用它的fill方法
        Color color2=colorFactory.getColor("Green");
        color2.fill();

    }
}
