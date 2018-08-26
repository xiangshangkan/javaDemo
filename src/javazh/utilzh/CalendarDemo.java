package javazh.utilzh;

import java.util.Calendar;

public class CalendarDemo {

    public void CalendarDemo1(){
        Calendar c=Calendar.getInstance();
        System.out.println("取出年"+c.get(Calendar.YEAR));
        //月份从0开始
        System.out.println("取出月份 "+c.get(Calendar.MONTH)+1);
        System.out.println("取出日 "+c.get(Calendar.DATE));
        //分别设置年、月（从0开始）、日、小时、分钟、秒
        c.set(2018,2,15,20,32,12);
        System.out.println("设置的时间 :"+c.getTime());
        //将Calendar的年前推一年
        c.add(Calendar.YEAR,-1);
        System.out.println("前推一年的时间："+c.getTime());
        //将Calendar的月前推8个月
        c.add(Calendar.MONTH,-8);
        System.out.println("前推8个月的时间"+c.getTime());
    }
}
