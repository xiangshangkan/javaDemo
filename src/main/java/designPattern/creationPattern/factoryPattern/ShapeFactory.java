package designPattern.creationPattern.factoryPattern;
/**
 * 创建一个工厂类，根据给定类型创建对应类对象
 * */
public class ShapeFactory {
    public static Shape getShape(String shapeType){
        if("Rectangle".equalsIgnoreCase(shapeType)){
            return new Rectangle();
        }else if("Circle".equalsIgnoreCase(shapeType)){
            return new Circle();
        }else if("Square".equalsIgnoreCase(shapeType)){
            return new Square();
        }
        return null;
    }
}
