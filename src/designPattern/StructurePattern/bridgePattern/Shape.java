package designPattern.StructurePattern.bridgePattern;

import sun.security.provider.SHA;

/**
 * @Description:  使用DrawAPI接口创建抽象类Shape
 * @Auther: Administrator
 * @Date: 2018/9/14 21:00
 */
public abstract class Shape {
    protected  DrawAPI drawAPI;
    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }
    public abstract  void draw();
}
