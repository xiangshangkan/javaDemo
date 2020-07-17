package leetcode.arithmetic.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:  有效的括号 leetcode 20
 * @Author: Zohar
 * @Date: 2020/7/16 19:55
 * @Version: 1.0
 */
public class IsValid {

    public static void main(String[] args) {
        System.out.println(isValid("([]{}"));
    }

    /**
     * 使用队列，一系列入栈出栈操作后，栈仍然为空，则表示有效括号。
     * 判断逻辑，当前字符是否与上次入栈的字符配对，如果配对则将上次入栈字符出栈，否则入栈当前字符
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if ("".equals(s)) {
            return true;
        } else if (s.length()%2 == 1) {
            return false;
        }

        Map<Character,Character> dict = new HashMap<>();
        dict.put('{','}');
        dict.put('(',')');
        dict.put('[',']');
        Deque<Character> deque = new ArrayDeque<>();
        deque.push(s.charAt(0));

        int len = s.length();
        for (int i = 1; i < len; i++) {
            char c = s.charAt(i);
            if (!deque.isEmpty()
                    && dict.containsKey(deque.peek()) && dict.get(deque.peek()).equals(c)) {
                  deque.pop();
            } else {
                deque.push(c);
            }
        }
       return deque.isEmpty();
    }
}
