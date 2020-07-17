package leetcode.arithmetic;

/**
 * @Description: 正数反转
 * @Author: Zohar
 * @Date: 2020/7/16 10:09
 * @Version: 1.0
 */
public class ReverseInteger {

    public static void main(String[] args) {

    }

    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int a = x % 10;
            x = x /  10;
            res = res * 10 + a;
        }
        return x;
    }
}
