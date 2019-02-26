package javazh.utilzh;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @auther: Administrator
 * @date: 2018/12/6 20:19
 */
public class DateDemo {

    public static  void main(String[] args) throws ParseException {
        String str1 = "2017-05-21";
        String str2 = "2017/05/21";
        String str3 = "2017.05.21";
        String str4 = "2017-05-21 18:45:10";
        System.out.println(textParseToDate(str1));
        System.out.println(textParseToDate(str2));
        System.out.println(textParseToDate(str3));

    }


    public static Date textParseToDate(String text) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy.MM.dd");
        if(text.lastIndexOf("-") > -1){
            return sdf1.parse(text);
        }
        if(text.lastIndexOf("/") > -1){
            return sdf2.parse(text);
        }
        if(text.lastIndexOf(".") > -1){
            return sdf3.parse(text);
        }
        return null;
    }
}
