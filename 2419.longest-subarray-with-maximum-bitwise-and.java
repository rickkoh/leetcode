/*
 * @lc app=leetcode id=2419 lang=java
 *
 * [2419] Longest Subarray With Maximum Bitwise AND
 */

// @lc code=start
class Solution {
    public int longestSubarray(int[] nums) {
        int result = 0, length = 0, max = 0;
        for (int ele : nums) {
            max = Math.max(max, ele);
        }

        for (int ele : nums) {
            if (ele == max) {
                result = Math.max(result, ++length);
            } else
                length = 0;
        }
        return result;
    }
}
// @lc code=end
