package designPattern.StructurePattern.bridgePattern;

import sun.security.provider.SHA;

/**
 * @Description:
 * @Auther: Administrator
 * @Date: 2018/9/14 21:05
 */
public class Circle extends Shape {
    private int x, y, radius;

    protected Circle(int x, int y, int radius,DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawAPI.draw(radius,x,y);
    }
}
