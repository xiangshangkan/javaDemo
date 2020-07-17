package leetcode.arithmetic.hard;

/**
 * @Description: 寻找两个正序数组的中位数 leetcode4
 * @Author: Zohar
 * @Date: 2020/7/15 17:55
 * @Version: 1.0
 */
public class FindMedianSortedArrays {

    public static void main(String args[]) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] nums = new int[len1+len2];
        int i = 0, j = 0, k = 0;
        while (k < len1+ len2) {
            if (len1 == 0 || i == len1) {
                nums[k++] = nums2[j++];
                continue;
            }
            if (len2 == 0 || j == len2) {
                nums[k++] = nums1[i++];
                continue;
            }
            if (nums1[i] < nums2[j]) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }
        return (nums[k>>1] + nums[(k-1)>>1])/2.0;
    }

}
