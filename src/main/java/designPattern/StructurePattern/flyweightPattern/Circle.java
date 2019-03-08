package designPattern.StructurePattern.flyweightPattern;

/**
 * @ClassName Circle
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/7 09:45
 * @Version 1.0
 */
public class Circle implements Shape {

    private String color;
    private int x;
    private int y;
    private int radius;

    public Circle(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle : Draw() [Color:" + color + ",x:" + x + ",y:" + y + ",radius:" + radius);
    }
}
