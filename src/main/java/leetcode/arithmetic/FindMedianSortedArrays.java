package leetcode.arithmetic;

/**
 * @Description: 寻找两个正序数组的中位数
 * @Author: Zohar
 * @Date: 2020/7/15 17:55
 * @Version: 1.0
 */
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length-1;
        int len2 = nums2.length-1;
        int i = 0;
        int j = 0;
        int value = 0;

        while (i != len1 && j != len2) {
            if (nums1[i] < nums2[j]) {
                if (i != len1) {
                    i++;
                }
            } else {
                if (j != len2) {
                    j++;
                }
            }

            if (nums1[len1] > nums2[len2]) {
                if (i != len1) {
                    len1--;
                }
            } else {
                if (j != len2) {
                    len2--;
                }
            }
        }

        return 0;
    }
}
