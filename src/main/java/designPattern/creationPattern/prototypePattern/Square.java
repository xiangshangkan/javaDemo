package designPattern.creationPattern.prototypePattern;

/**
 * @Description:
 * @Auther: Administrator
 * @Date: 2018/9/12 16:17
 */
public class Square extends Shape {

    public Square(){
        type = "Square";
    }

    @Override
    void draw() {
        System.out.println("Square : draw() inside");
    }
}
