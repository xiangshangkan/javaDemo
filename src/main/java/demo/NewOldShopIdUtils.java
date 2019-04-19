package demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class  NewOldShopIdUtils {

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    /** 老系统计算id 日期计算基准*/
    public static final String dateMark  = "2006-01-01";
    /** 老系统 */
    public static final String DBID = "77";
    /** 老系统机构id 总长度*/
    public static final int len = 22;

    public static final String some = "000000000000000000000000000000000000000000000000";

    public static String UfNewId() {
        StringBuilder idPart = new StringBuilder();
        Calendar calendar = Calendar.getInstance();
        try {
            //取当前时间与2006年1月1日相差的天数（老系统最多取6位即相差2百多年，所以无需截取）
            Date date = sdf.parse(dateMark);
            idPart.append(NewOldShopIdUtils.calDateByDay(date,calendar.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //求当天已过多少秒（老系统最多取10位，而实际最大值90060）
        String ufnewid  = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY) * 3600  + calendar.get(Calendar.MINUTE)*60 + calendar.get(Calendar.SECOND));
        idPart.append(ufnewid);
        //固定参数（老系统 select * from cm_dbparm where ParmName='DBID'）
        idPart.append(DBID);

        //随机取值
        String r4 = NewOldShopIdUtils.v_Tool_id().substring(2,6);
        idPart.append(r4);

        int replicate = len - idPart.length();
        //随机取值
        String othrer =  some.substring(0,replicate) + NewOldShopIdUtils.v_Tool_id();
        //从后截取
        idPart.append(othrer.substring(othrer.length() - replicate));

        return idPart.toString();

    }

    /**
     * @description //求两个日期之间相差的天数
     * @param  startDate
     * @param  endDate
     * @return 天数之差
     * @author      zhouhui
     * @date        2019/4/10 15:25
    */
    public static int calDateByDay(Date startDate, Date endDate) throws ParseException {

        Calendar calendar = Calendar.getInstance();
        startDate = sdf.parse(sdf.format(startDate));
        endDate = sdf.parse(sdf.format(endDate));
        calendar.setTime(startDate);
        long time1 = calendar.getTimeInMillis();
        calendar.setTime(endDate);
        long time2 = calendar.getTimeInMillis();
        return   Integer.valueOf(new Long(Math.abs((time2 - time1)/(1000*3600*24))).toString());
    }

    /**
     * @description //获取随机数的前6位数
     * @param
     * @return
     * @author      zhouhui
     * @date        2019/4/10 16:17
    */
    public static String v_Tool_id(){
        double randValue = Math.random();
        return String.valueOf(randValue).replace(".","").substring(0,6);
    }

}