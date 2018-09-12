package designPattern.creationPattern.prototypePattern;

/**
 * @Description:  原型模式：用于创建重复的对象，又提高了性能，实体类需实现Cloneable接口，并重载父类Object的clone方法，在实际生产环境中可能有持续创建
 *                对象，或经常性的对某一类对象进行改变但又需要保存该对象的原始状态的场景；通过原型模式创建的对象可保存原始对象的一些特性或值
 * @Auther: Administrator
 * @Date: 2018/9/12 16:41
 */
public class PrototypePatternDemo {

    public static void main(String[] args ){
        //添加缓存
        ShapeCache.loadCache();

        Square square = (Square) ShapeCache.getShape("1");
        square.draw();

        Circle circle = (Circle) ShapeCache.getShape("2");
        circle.draw();

        Rectangle rectangle = (Rectangle) ShapeCache.getShape("3");
        rectangle.draw();
    }
}
