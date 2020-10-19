package leetcode.arithmetic.medium;

/**
 * @Description: 最小路径和 leetcode 64
 * @Author: Zohar
 * @Date: 2020/7/23 11:28
 * @Version: 1.0
 */
public class MinPathSum {

    /** 转化为左上角到每个元素的最小路径，包括右下角
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length==0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        // 因为只能向下或向右，对于第一列上的元素，路径固定
        for (int i = 1; i < row; i++) {
            dp[i][0] =dp[i-1][0] + grid[i][0];
        }
        //对于第一行上的元素，路径也固定
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        //其他位置元素的最小路径曲该位置上面元素的（最小路径和左边元素的最小路径）决定
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j]) + grid[i][j];
            }
        }
        return dp[row-1][col-1];
    }
}
