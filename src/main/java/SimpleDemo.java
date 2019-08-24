import java.math.BigDecimal;
import java.text.ParseException;

/**
 * @auther: Administrator
 * @date: 2018/12/28 09:39
 */
public class SimpleDemo {

    public static void main(String[] args) throws ParseException {

      int[] nums = new int[]{2,7,11,15};
      int[] result = twoSum(nums,9);
        for (int so:result) {
            System.out.print(so);
        }

    }

    public static int[] twoSum(int[] nums, int target) {
        int[] mark = new int[2];
        int n = nums.length;
        for(int i = 0; i < n; i++) {
           for(int j = n-1; j > i; j--) {
               if (nums[i] + nums[j] == target) {
                   n = j;
                   mark[0] = i;
                   mark[1] = j;
                   return mark;
               }
           }
        }
        return null;
    }



}
