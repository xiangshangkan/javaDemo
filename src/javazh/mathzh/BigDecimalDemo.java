package javazh.mathzh;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @auther: Administrator
 * @date: 2018/10/15 15:48
 */
public class BigDecimalDemo {

    public static void main(String[] args){
        BigDecimal val = new BigDecimal(4);
        System.out.print(val);
        DecimalFormat decimalFormat = new DecimalFormat();
        System.out.println(val.setScale(4));
        System.out.println(val.compareTo(null));
    }

    public void bigDecimalDemo1(){
        String str = "2.30";
        BigDecimal deci = new BigDecimal(str);
        System.out.println(str +"String转为BigDecimal"+ deci);
    }

}
