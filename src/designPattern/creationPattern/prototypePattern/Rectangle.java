package designPattern.creationPattern.prototypePattern;

/**
 * @Description:
 * @Auther: Administrator
 * @Date: 2018/9/12 16:12
 */
public class Rectangle extends Shape {

    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Rectangle ::draw() inside");
    }
}
