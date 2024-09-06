/*
 * @lc app=leetcode id=1143 lang=java
 *
 * [1143] Longest Common Subsequence
 */

// @lc code=start
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] memo = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                memo[i][j] = -1;
            }
        }
        return branchNext(text1, text2, n - 1, m - 1, memo);
    }

    private int branchNext(String text1, String text2, int i, int j, int[][] memo) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = 1 + branchNext(text1, text2, i - 1, j - 1, memo);
        } else {
            memo[i][j] = Math.max(branchNext(text1, text2, i - 1, j, memo),
                    branchNext(text1, text2, i, j - 1, memo));
        }

        return memo[i][j];
    }
}
// @lc code=end
