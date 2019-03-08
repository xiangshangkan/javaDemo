package designPattern.StructurePattern.flyweightPattern;

/**
 * @ClassName FlyweightPatternDemo
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/7 09:55
 * @Version 1.0
 */
public class FlyweightPatternDemo {

    private static  final String colors[] = {"Red","Green","Blue","White","Black"};

    public static void main(String[] args){
        for(int i = 0; i < 20; i++) {
            Circle circle = (Circle) ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomXY());
            circle.setY(getRandomXY());
            circle.setRadius(100);
            circle.draw();
        }

    }

    private static String getRandomColor(){
        return colors[(int)(Math.random()*colors.length)];
    }

    private static int getRandomXY(){
        return (int)(Math.random()*100);
    }

}
