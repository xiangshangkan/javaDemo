package leetcode.datastructure.queue;




/**
 * @Description: ${description}
 * @Author: Zohar
 * @Date: 2020/6/3 13:45
 * @Version: 1.0
 */

 public class Solution {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        char[] chars = String.valueOf(x).toCharArray();
        for (int i =0,j=chars.length-1;i <= j;i++,j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        System.out.println(Solution.isPalindrome(-10));
    }
}
