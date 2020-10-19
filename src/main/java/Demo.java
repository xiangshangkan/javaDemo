import java.util.concurrent.*;

/**
 * @ProjectName: javaDemo
 * @Package: PACKAGE_NAME
 * @ClassName: Demo
 * @Description: ${description}
 * @Author: Zohar
 * @Date: 2020/6/17 15:57
 * @Version: 1.0
 */
public class Demo {

    private static ExecutorService executorService = Executors.newCachedThreadPool();



}

class Task implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
