package designPattern.StructurePattern.flyweightPattern;

import java.util.HashMap;

/**
 * @ClassName ShapeFactory
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/7 09:49
 * @Version 1.0
 */
public class ShapeFactory {

    public static  final HashMap<String,Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        Circle circle = (Circle) circleMap.get(color);
        if(circle == null) {
            circle = new Circle(color);
            circleMap.put(color,circle);
            System.out.println("Creating circle of color:" + color);
        }
        return circle;
    }
}
