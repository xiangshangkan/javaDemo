import java.util.ArrayList;
import java.util.List;

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

    public static  void main(String[] args) {
        List<Integer> lst2 = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.parallelStream().forEach(mo->{
            if (mo == 2) {
                run();
            }
            System.out.println(mo);
            lst2.add(mo);
        });
        lst2.forEach(System.out::println);
    }

    public static void run(){
        for (int i = 0; i < 10000; i++) {

        }
    }





}
