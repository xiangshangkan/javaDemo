package javazh.langzh;


import java.util.Arrays;
import java.util.function.Supplier;

public class IntegerDemo {

    public static void main(String[] args){
        Supplier<String[]> supplier = ()->new String[5];
        String[] strings = supplier.get();
        Object[] objects = Arrays.stream(strings).map(str->str = "1").toArray();

        String[] some = new String[objects.length];
        for(int i =0; i < objects.length ; i++){
            some[i] = (String)objects[i];
        }

        Arrays.stream(objects).forEach(System.out::println);
        Arrays.stream(strings).forEach(System.out::println);
        Arrays.stream(some).forEach(System.out::println);
    }




    /*Integer 中已经将-128~127之间的证整数自动装箱成Integer实例，并存储在缓存中*/
    public static String IntegerDemo1(String shopStatus) {
            switch (shopStatus) {
                case "1": return "未签铺";
                case "2": return "已签未交";
                case "3": return  "已交铺";
                case "4": return "装修中";
                case "5": return "营业中";
                default: return "jljljl";
            }
    }






}