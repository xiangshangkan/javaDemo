package leetcode.arithmetic.easy;

/**
 * @Description:  搜索插入位置 leetcode 35
 * @Author: Zohar
 * @Date: 2020/7/17 9:54
 * @Version: 1.0
 */
public class SearchInsert {

    public static void main(String[] args) {
        int[] ints = new int[]{1,3,5,6};
        System.out.println(searchInsert2(ints,7));
    }


    /**
     * 数组遍历查找
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert2(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     * 二分查找法
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert1(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n -1, mid = 0;
        while (left <= right) {
            mid = ((right - left) >>1 ) + left;
            if (target <= nums[mid]) {
                right = mid -1;
            } else {
                left = mid +1;
            }
        }
        return mid;
    }
}
