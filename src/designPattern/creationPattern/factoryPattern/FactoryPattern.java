package designPattern.creationPattern.factoryPattern;

public class FactoryPattern {

    public static void main(String[] args){
        Shape circle = ShapeFactory.getShape("Circle");
        Shape square = ShapeFactory.getShape("Square");
        Shape rectangle = ShapeFactory.getShape("Rectangle");

        circle.draw();
        square.draw();
        rectangle.draw();
    }

}
