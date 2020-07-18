package leetcode.arithmetic.medium;

/**
 * @Description: 最长回文子串 leetCode 5
 * @Author: Zohar
 * @Date: 2020/7/18 9:55
 * @Version: 1.0
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome1("aba"));
    }

    /**
     * 暴力解法
     * @param s
     * @return
     */
    public static String longestPalindrome1(String s) {
        if (s.length() < 2) {
            return s;
        }
        int len = s.length();
        for (int i = len; i >= 1; i-- ) {
            //遍历母串，取连续i个字符的子串
            for (int j = 0;j <=  len-i; j++) {
                String subS = s.substring(j,j+i);
                boolean flag = true;
                //判断取到的子串是否是回文串
                for (int k = 0; k < subS.length()>>1; k++) {
                    if (subS.charAt(k) != subS.charAt(subS.length()-k-1)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    //若找到则反回
                   return subS;
                }
            }
        }
        return "";
    }

}
