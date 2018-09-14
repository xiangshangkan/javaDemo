package designPattern.StructurePattern.bridgePattern;

/**
 * @Description:
 * @Auther: Administrator
 * @Date: 2018/9/14 20:57
 */
public class GreenCircle implements DrawAPI{
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("Draw GreenCircle:[color:green,radius"+radius+",x:"+x+",y"+y+"]");
    }
}
