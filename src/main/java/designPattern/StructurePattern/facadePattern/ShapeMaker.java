package designPattern.StructurePattern.facadePattern;

/**
 * @ClassName ShapeMaker
 * @Description 外观类
 * @Author zhouhui
 * @Date 2019/3/6 18:25
 * @Version 1.0
 */
public class ShapeMaker {

    private Circle circle;
    private Square square;
    private Rectangle rectangle;

    public ShapeMaker(){
        circle = new Circle();
        square = new Square();
        rectangle = new Rectangle();
    }

    public void drawCircle(){
        this.circle.draw();
    }

    public void drawSquare(){
        this.square.draw();
    }

    public void drawRectangle(){
        this.rectangle.draw();
    }
}
