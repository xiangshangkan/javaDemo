package demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @auther: Administrator
 * @date: 2018/12/28 09:39
 */
public class SimpleDemo {


    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        /*String dateText = "2019-01-14";
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

        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,0);
        System.out.println(sdf.format(calendar.getTime()));
        calendar.set(Calendar.DAY_OF_MONTH,1);
        System.out.println(sdf.format(calendar.getTime()));*/

/*
        BigDecimal bonuse = new BigDecimal(12321.32);
        BigDecimal balance = new BigDecimal(12.88);
        BigDecimal some = new BigDecimal(-2222);
        BigDecimal total = balance.add(bonuse).subtract(new BigDecimal(30000));
        System.out.println(total + "嘿嘿" + some);
        System.out.println("比较大小" + total.compareTo(some));

        System.out.println(total.abs().setScale(2,BigDecimal.ROUND_UP));
        System.out.println(Double.parseDouble(total.abs().setScale(2,BigDecimal.ROUND_UP).toString()));*/

        /*SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat fg = new SimpleDateFormat("yyyy-MM-dd");
        String datetext = "1/1/2019";

        Date date = sdf.parse(datetext);

        System.out.println(fg.format(date));
*/

        /*String test = "8888,909090";
        String hj = "1221212";
        System.out.println(test.split(",").length);
        System.out.println(hj.split(",").length);*/

        /*Map<String,Object> map = new HashMap<>();
        System.out.println(map.get("hh"));*/
       /* System.out.println(map.get("dd").toString());*/


      /*  List<String> strList = new ArrayList<>();
        strList.add("first");
        strList.add("second");
        strList.add("third");
        System.out.println(strList.size());
        List<String> subList = strList.subList(1,strList.size());
        System.out.println("------------------------");
        strList.forEach(model->System.out.println(model));
        System.out.println("------------------------");
        subList.forEach(model->System.out.println(model));
        System.out.println("------------------------");*/

       /* Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        System.out.println(calendar.getTime());*/

       /* Map<String,Object> some = new HashMap<>();
        some.put("some","hahahhaa");
        Date date = (Date)some.get("hshshs");
        System.out.println(date);
        System.out.println(some.get("some"));*/



     /*  String start = "2018-06-12";

       String end = "2018-09-12";

        Date startDate = sdf.parse(start);

        Date endDate = sdf.parse(end);
*/

     /*String some = " / ";
     String[] a = some.split("/");
     System.out.println(a.length);*/

    /* String some = "489555.22";
     System.out.println(Double.valueOf(some) == 489555.22);*/


    String some = "67";
    /*Integer dd = Integer.valueOf(some.substring(0,some.indexOf(".")));*/
    System.out.println(some.indexOf("."));

    }
}
