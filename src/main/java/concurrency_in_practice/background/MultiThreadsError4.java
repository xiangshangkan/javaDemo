package concurrency_in_practice.background;


/**
 * 描述  ： 初始化未完成，就this 赋值
 */
public class MultiThreadsError4 {

    static Point point;

    public static void main(String[] args) {
        new PointMaker().start();
        try {
            Thread.sleep(105);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (point != null) {
            //point 因打印的时间不同，而出现不同的结果(1,0) 或(1,1)
            System.out.println(point);
        }
    }

}

class Point {
    private final int x, y;



    public Point(int x, int y) throws InterruptedException {
        this.x = x;
        MultiThreadsError4.point = this;
        Thread.sleep(100);
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class PointMaker extends Thread{

    @Override
    public void run(){
        try {
            new Point(1,1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

