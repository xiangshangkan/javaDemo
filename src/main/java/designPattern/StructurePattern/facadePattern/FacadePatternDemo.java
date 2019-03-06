package designPattern.StructurePattern.facadePattern;

/**
 * @ClassName FacadePatternDemo
 * @Description 实用外观类画出各种类型的形状
 * @Author zhouhui
 * @Date 2019/3/6 18:28
 * @Version 1.0
 */
public class FacadePatternDemo {

    public static void main(String[] args){
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }


}
