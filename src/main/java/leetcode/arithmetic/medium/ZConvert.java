package leetcode.arithmetic.medium;


/**
 * @Description: Z 字形变换  leetcode 6
 * @Author: Zohar
 * @Date: 2020/7/23 13:55
 * @Version: 1.0
 */
public class ZConvert {

    /**
     * @param s
     * @param numRows
     * @return
     */
    public static String convert1(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        int len = s.length();
        //用于收集 Z 字形每行字符串
        StringBuilder[] strs = new StringBuilder[numRows];
        for (int k = 0; k < numRows; k++) {
            strs[k] = new StringBuilder();
        }

        boolean flag = true;
        int j = 0;
        for (int i = 0; i < len; i++) {
            strs[j].append(s.charAt(i));
            if (flag) {

                if (j < numRows-1) {
                    j++;
                } else {
                    //变换方向向上
                    flag = false;
                    j--;
                }
            } else {
                if (j > 0) {
                    j--;
                } else {
                    //变换方向向下
                    flag = true;
                    j++;
                }
            }
        }
        for (int i = 1; i < numRows; i++ ) {
            strs[0].append(strs[i]);
        }
        return strs[0].toString();
    }

    public String convert2(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int circleLen = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j +i < n; j += circleLen) {
                sb.append(s.charAt(j+i));
                if (i != 0 || i != numRows-1 || j + circleLen -j < n) {
                    sb.append(s.charAt(j + circleLen - j));
                }
            }
        }
        return sb.toString();
    }

}
