package designPattern.creationPattern.abstractFactoryPattern;
/**
 * 创建扩展了AbstractFactory的工厂类，基于给定的信息生成实体类对象
 * */
public class ShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType) {
        if("Circle".equalsIgnoreCase(shapeType)){
            return new Circle();
        }else if("Rectangle".equalsIgnoreCase(shapeType)){
            return new Rectangle();
        }else if("Square".equalsIgnoreCase(shapeType)){
            return new Square();
        }
        return null;
    }

    @Override
    public Color getColor(String colorType) {
        return null;
    }
}
