package designPattern.StructurePattern.DecoratorPattern;

/**
 * @ClassName RedShapeDecorator
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/6 17:59
 * @Version 1.0
 */
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
       decoratedShape.draw();
       setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decorateShape) {
        System.out.println("Border Color:Red");
    }
}
