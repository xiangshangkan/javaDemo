package thinkSome.泛型通配符;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Administrator
 * @date : 2019/2/12 10:27
 */
public class GenricTest {
    public static void main(String[] args){
        List<? extends Self> test1 = new ArrayList<>();
        List<? super Self> test2 = new ArrayList<>();
        List<?> test3 = new ArrayList<>();
       /* test1.add(new Super());
        test1.add(new Self());
        test1.add(new Son());
        test2.add(new Super());
        test2.add(new Self());
        test2.add(new Son());
        test3.add(new Super());
        test3.add(new Self());
        test3.add(new Son());*/
    }
}

class Super{}

class Self extends Super{}

class Son extends Self{}

