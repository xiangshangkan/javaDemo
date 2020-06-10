package designPattern.creationPattern.abstractFactoryPattern;

public class ColorFactory extends AbstractFactory {


    @Override
    Shape getShape(String shapeType) {
        return null;
    }

    @Override
    Color getColor(String colorType) {
        if("Red".equalsIgnoreCase(colorType)){
            return new Red();
        }if("Blue".equalsIgnoreCase(colorType)){
            return new Blue();
        }if("Green".equalsIgnoreCase(colorType)){
            return new Green();
        }
        return null;
    }
}
