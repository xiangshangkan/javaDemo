package javazh.langzh;


public class IntegerDemo {
    /*Integer 中已经将-128~127之间的证整数自动装箱成Integer实例，并存储在缓存中*/
    public void IntegerDemo1() {
        Integer a = 1;
        Integer b = 1;
        System.out.println(a == b);
        Integer c = 129;
        Integer d = 129;
        System.out.println(c == d);
        System.out.println(c.equals(d));
    }
}