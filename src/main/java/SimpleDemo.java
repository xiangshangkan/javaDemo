import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.text.ParseException;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @auther: Administrator
 * @date: 2018/12/28 09:39
 */
public class SimpleDemo {

    public static void main(String[] args) throws ParseException {
      String some = ",";
      String[] s = some.split(",");
      HashMap map = new HashMap();
      TreeMap treeMap = new TreeMap();

      PageInfo pageInfo = new PageInfo();
      PageHelper pageHelper = new PageHelper();
    }

    @interface  some {

    }

    @some
    class addd{

    }
    @FunctionalInterface
    interface filter<T,D,L>{
       void  apply(T t,D d,L l);
    }







}
