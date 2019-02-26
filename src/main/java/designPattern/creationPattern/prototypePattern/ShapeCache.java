package designPattern.creationPattern.prototypePattern;


import java.util.HashMap;

/**
 * @Description:  创建一个类，从数据库中获取实体，保存在HashMap中
 * @Auther: Administrator
 * @Date: 2018/9/12 16:23
 */
public class ShapeCache {

    public static HashMap<String,Shape> shapeMap = new HashMap<String,Shape>();

    public static Shape getShape(String id){
        Shape cacheShape = shapeMap.get(id);
        return (Shape) cacheShape.clone();
    }

    /**
    * @Description   添加缓存
    * @author      作者姓名
    * @param
    * @return
    * @exception
    * @date        2018/9/12 16:28
    */
    public static void loadCache(){
        Square square = new Square();
        square.setId("1");
        shapeMap.put(square.getId(),square);

        Circle circle = new Circle();
        circle.setId("2");
        shapeMap.put(circle.getId(),circle);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(),rectangle);
    }
}
