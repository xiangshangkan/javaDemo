package leetcode.arithmetic.hard;

/**
 * @Description: 交错字符串 leetcode 97
 * @Author: Zohar
 * @Date: 2020/7/18 16:29
 * @Version: 1.0
 */
public class IsInterLeave {

    public static void main(String[] args) {
        System.out.println(isInterLeave("aabcc","dbbca","aadbbcbcac"));
    }


    /**
     * 假设 dp[i][j] 表示一个布尔值，代表的是“s3 的前 i+j 个字符 是否是由 s1 的前 i 个字符 和s2 的前 j 个字符交错组成的。”
     * 那么 dp[i][j] 转化成转移方程无非分成2 类：s2 的前 i+j 个字符 的最后一个字符取自谁？ s1 的前 i 个字符的末尾，还是 s2
     * 的前 j 个字符的末尾？
     */
    public static boolean isInterLeave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();

        if (n + m != t) {
            return false;
        }

        boolean[][] f = new boolean[n + 1][m + 1];

        f[0][0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }

        return f[n][m];
    }
}
