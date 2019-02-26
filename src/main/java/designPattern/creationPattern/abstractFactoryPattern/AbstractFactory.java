package designPattern.creationPattern.abstractFactoryPattern;
/**
 * 为Color和Shape 创建抽象类来获取工厂
 * */
public abstract class AbstractFactory {
    abstract Shape getShape(String shapeType);
    abstract Color getColor(String colorType);
}
