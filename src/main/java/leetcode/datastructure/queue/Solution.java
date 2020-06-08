package leetcode.datastructure.queue;


import java.util.*;

/**
 * @Description: ${description}
 * @Author: Zohar
 * @Date: 2020/6/3 13:45
 * @Version: 1.0
 */

 public class Solution {

    public int reverse(int x) {

        int max = (1<<32);
        int min = - max;

        String str = String.valueOf(x);
        int length = str.length();

        char first = str.charAt(0);
        StringBuilder str2 = new StringBuilder();
        for (int i = length; i > length; i--) {
            if (str2.length() == 0 && str.charAt(i) == '0') {
                continue;
            }
            str2.append(str.charAt(i));
        }
        str = first + str2.toString();
        int res = Integer.valueOf(str);

        return (res < min || res > max) ? 0 : res;
    }

    public static void main(String[] args) {
        System.out.println( 1<<31 );
        System.out.println((1<<31));
    }
}
