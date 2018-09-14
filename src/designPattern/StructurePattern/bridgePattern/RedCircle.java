package designPattern.StructurePattern.bridgePattern;

/**
 * @Description:
 * @Auther: Administrator
 * @Date: 2018/9/14 20:54
 */
public class RedCircle implements DrawAPI {
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("Draw RedCircle[color:red,radius:"+radius+",x:"+x+",y:"+y+ "]");
    }
}
