/*
 * @lc app=leetcode id=2022 lang=java
 *
 * [2022] Convert 1D Array Into 2D Array
 */

// @lc code=start
class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][0];
        }

        int[][] res = new int[m][n];

        for (int i = 0; i < original.length; i++) {
            int x = i / n;
            int y = i % n;
            res[x][y] = original[i];
        }

        return res;
    }
}
// @lc code=end
