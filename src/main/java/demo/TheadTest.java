package demo;

/**
 * @ClassName TheadTest
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/27 19:44
 * @Version 1.0
 */
public class TheadTest implements Runnable {

    private String name;

    public TheadTest(String name) {
        this.name = name;
    }

    @Override
    public void run() {
       /*for (int i= 0; i< 100; i++) {
           System.out.println(name + i);
       }*/
        System.out.println(name);
        CacheUtils.put1("name",name);
        System.out.println("线程输出：" + CacheUtils.get1("name"));
    }
}
