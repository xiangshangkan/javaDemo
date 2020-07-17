package leetcode.arithmetic.easy;

/**
 * @Description: 最长公共前缀 leetcode 14
 * @Author: Zohar
 * @Date: 2020/7/16 16:02
 * @Version: 1.0
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix1(strs));
    }


    /**
     * 横向扫描, 依次遍历每个字符串，更新最长公共前缀
     * @param strs
     * @return
     */
    public static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        //初始化公共前缀
        String res = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            int length = Math.min(res.length(), strs[i].length());
            int index = 0;
            while (index < length && res.charAt(index) == strs[i].charAt(index)) {
                index++;
            }
            if (index == 0) {
                return "";
            } else {
                res = res.substring(0,index);
            }
        }
        return res;
    }

    /**
     * 纵向扫描 从前往后遍历所有字符串的每一列，比较相同列上的字符是否相同，相同才继续遍历下一列
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int len = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < len; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || c != strs[j].charAt(i)) {
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

    /**
     * 不开心
     * @param strs
     * @return
     */
    public static String longestCommonPrefix3(String[] strs){

        return null;
    }

}
