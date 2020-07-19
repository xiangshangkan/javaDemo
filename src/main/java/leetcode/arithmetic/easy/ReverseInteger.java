package leetcode.arithmetic.easy;

/**
 * @Description: 整数反转 leetcode 7
 * @Author: Zohar
 * @Date: 2020/7/16 10:09
 * @Version: 1.0
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(123));

    }

    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int a = x % 10;
            x = x /  10;
            res = res * 10 + a;
            if (x != 0) {
                int b = x % 10;
               if ((x > 0 && res > (Integer.MAX_VALUE -b)/10)||
                       (x < 0 && res < (Integer.MIN_VALUE-b)/10)) {
                   return 0;
               }
            }
        }
        return res;
    }
}
