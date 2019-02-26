package designPattern.creationPattern.prototypePattern;

/**
 * @Description:
 * @Auther: Administrator
 * @Date: 2018/9/12 16:19
 */
public class Circle extends Shape {

    public Circle(){
        type = "Circle";
    }
    @Override
    void draw() {
        System.out.println("Circle : draw() inside");
    }
}
