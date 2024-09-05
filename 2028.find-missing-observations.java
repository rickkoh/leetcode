/*
 * @lc app=leetcode id=2028 lang=java
 *
 * [2028] Find Missing Observations
 */

// @lc code=start
class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] ans = new int[n];

        int total = mean * (n + rolls.length);
        int nTotal = total - Arrays.stream(rolls).sum();
        double nAvg = (double) nTotal / n;
        if (nAvg < 1 || nAvg > 6) {
            return new int[] {};
        }

        // Find the number of n dices that makes up nAvg
        int nRem = nTotal % n;
        for (int i = 0; i < n; i++) {
            if (i < nRem) {
                ans[i] = (int) nAvg + 1;
            } else {
                ans[i] = (int) nAvg;
            }
        }

        return ans;
    }
}
// @lc code=end
