package main.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @auther: Administrator
 * @date: 2018/12/28 09:39
 */
public class SimpleDemo {

    public static void main(String[] args) throws ParseException {
        /*String dateText = "2019-01-14";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dateText);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println("原时间：" + sdf.format(date));*/

       /* calendar.add(Calendar.DAY_OF_MONTH,1);
        date = calendar.getTime();
        System.out.println("DAY_OF_MONTH:" + sdf.format(date));
        calendar.add(Calendar.DAY_OF_YEAR,1);
        date = calendar.getTime();
        System.out.println("DAY_OF_YEAR:" + sdf.format(date));
        calendar.add(Calendar.DAY_OF_WEEK,1);
        date = calendar.getTime();
        System.out.println("DAY_OF_WEEK:" + sdf.format(date));
        calendar.add(Calendar.DAY_OF_WEEK_IN_MONTH,2);
        date = calendar.getTime();
        System.out.println("DAY_OF_WEEK_IN_MONTH:" + sdf.format(date));*/
       /*calendar.add(Calendar.MONTH,1);
       date = calendar.getTime();
       System.out.println(sdf.format(date));*/
       /*int some = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
       calendar.set(Calendar.DATE,some);
       date = calendar.getTime();
       System.out.println(sdf.format(date));*/


        /*List<String> test1 = new ArrayList<>();
        test1.add("哈哈");
        test1.add("嘻嘻");
        List<String> test2 = new ArrayList<>();
        test2.add("嘿嘿");
        test2.add("哈哈");
        test1.addAll(test2);
        test1.forEach(System.out::println);
        test2.addAll(new ArrayList<>());
        test2.forEach(System.out::println);
        System.out.println(test2.size());*/

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,0);
        System.out.println(sdf.format(calendar.getTime()));
        calendar.set(Calendar.DAY_OF_MONTH,1);
        System.out.println(sdf.format(calendar.getTime()));





    }



}
