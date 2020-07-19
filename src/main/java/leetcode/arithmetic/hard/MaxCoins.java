package leetcode.arithmetic.hard;

import java.util.LinkedList;
import java.util.List;

public class MaxCoins {

    private static int[] fib;

    public static void main(String[] args) {
     test1();
    }

    public static int maxCoins(int[] nums) {
        List<Integer> list = new LinkedList();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            list.add(nums[i]);
        }
        //排序算法
        for (int i = 0; i < len; i++){
            for (int j = i+1;j < len; j++ ) {
                if (nums[i] > nums[j]) {
                    int mid = nums[i];
                    nums[i] = nums[j];
                    nums[j] = mid;
                }
            }
        }

        int res = 0;
        for (int k = 0; k < len; k++) {
            int index = list.indexOf(Integer.valueOf(nums[k]));
            int left = 1, right = 1;
            if (index != 0) {
                left = list.get(index-1);
            }
            if (index != list.size() -1) {
                right = list.get(index + 1);
            }
            res = res + (left * right *  nums[k]);
            list.remove(index);
        }

        return res;
    }

    public static void  test1() {
        fib = new int[10];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < 10; i++) {
            fib[i] = -1;
        }
        fib(9);
        for (int i=0; i<9; i++ ) {
            System.out.println(fib[i]);
        }
    }

    public static int fib(int n) {
        if (fib[n] != -1) return fib[n];
        return fib[n] = fib(n-1) + fib(n-2);
    }
}
