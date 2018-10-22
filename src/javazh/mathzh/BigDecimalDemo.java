package javazh.mathzh;

import java.math.BigDecimal;

/**
 * @auther: Administrator
 * @date: 2018/10/15 15:48
 */
public class BigDecimalDemo {

    public void bigDecimalDemo1(){
        String str = "2.30";
        BigDecimal deci = new BigDecimal(str);
        System.out.println(str +"String转为BigDecimal"+ deci);
    }
}
