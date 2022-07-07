package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description: ${description}
 * @Author: zhouhui2
 * @Date: 2022/5/2 1:22 PM
 */
public class Demo {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.addAll(Arrays.asList(1,2,3,4));
        Integer[] arr = new Integer[set.size()];
        set.toArray(arr);
        // 冒泡排序
        bubbleSort(arr);
        for (int v : arr
        ) {
            System.out.println(v);
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(Integer[] arr) {
        int m;
        for (int i = 0; i < arr.length - 1; i++) {
            // 第一层循环控制遍历比较 n-1 轮
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 每一轮过后最大数都到达数列尾部
                if (arr[j] > arr[j + 1]) {
                    m = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = m;
                }
            }
        }
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertSort(Integer[] arr) {
        //注意：最后一个要插入数据的下表为arr.length -1,此时待插入有序数列的end下标为n-2
        for (int i = 0; i < arr.length - 1; i++) {
            // 这里end分隔已排有序序列与待排序列
            int end = i;
            //要插入的数据为有序序列的后一个位置
            int x = arr[end + 1];

            while (end >= 0) {
                // 将待插入数据x与有序数列从后往前逐个比较
                if (arr[end] >= x) {
                    // 有序数列后移
                    arr[end + 1] = arr[end];
                    end--;
                } else {
                    // 有序数列中遇到不大于数据X的数据，则插入
                    arr[end + 1] = x;
                    break;
                }
            }
        }
    }

    /**
     * 希尔排序
     *
     * @param arr
     */
    public static void shellSort(Integer[] arr) {
        // 多组预排 + 插排
        int n = arr.length;
        int gap = n;
        while (gap > 1) {
            // 保证最后一次分组gap == 1，即最后一次为直接插入排序
            // 也可以写成这样，gap = gap /3 +1;
            // 除3预排的效率相比于除2的好点
            gap /= 2;
            for (int i = 0; i < n - gap; i++) {
                int end = i;
                int x = arr[end + gap];
                while (end >= 0) {
                    if (arr[end] >= x) {
                        arr[end + gap] = arr[end];
                        end -= gap;
                    } else {
                        arr[end + gap] = x;
                        break;
                    }
                }
            }
        }
    }

    /**
     * 直接选择排序
     *
     * @param arr
     */
    public static void selectSort(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 初始化最小数据下标
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 遍历找到最小数据并记录下标
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            int m = arr[i];
            arr[i] = arr[min];
            arr[min] = m;
        }
    }

    public static void partition() {

    }

}
