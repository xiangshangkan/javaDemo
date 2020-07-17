package leetcode.arithmetic.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 罗马数字转整数   leetcode 13
 * @Author: Zohar
 * @Date: 2020/7/16 14:03
 * @Version: 1.0
 */
public class RomanToInt {

    public static Map<Character,Integer> romans = new HashMap();
    public static Map<String,Integer> special = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    static {
        romans.put('I',1);
        romans.put('V',5);
        romans.put('X',10);
        romans.put('L',50);
        romans.put('C',100);
        romans.put('D',500);
        romans.put('M',1000);

        special.put("IV",4);
        special.put("IX",9);
        special.put("XL",40);
        special.put("XC",90);
        special.put("CD",400);
        special.put("CM",900);
    }

    public static int romanToInt(String s) {
        char[] ss = s.toCharArray();
        int res = 0;
        for (int i = 0; i < ss.length; i++) {
            if ((i+1) < ss.length) {
                Integer va = dict(ss[i]+""+ss[i+1]);
                if (va == null) {
                    va = dict(ss[i]+"");
                } else {
                    i++;
                }
                res += va;
            } else {
                res += dict(ss[i]+"");
            }
        }
        return res;
    }

    public static Integer dict(String key) {
        switch (key) {
            case "I" :  return 1;
            case "V" :  return 5;
            case "X" : return 10;
            case "L" : return 50;
            case "C" : return 100;
            case "D" : return 500;
            case "M" : return 1000;
            case "IV": return 4;
            case "IX": return 9;
            case "XL": return 40;
            case "XC": return 90;
            case "CD": return 400;
            case "CM": return 900;
            default:return null;
        }
    }
}
