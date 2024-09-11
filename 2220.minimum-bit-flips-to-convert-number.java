/*
 * @lc app=leetcode id=2220 lang=java
 *
 * [2220] Minimum Bit Flips to Convert Number
 */

// @lc code=start
class Solution {
    public int minBitFlips(int start, int goal) {
        String result = Integer.toBinaryString(start ^ goal);
        result = result.replaceAll("0", "");
        return result.length();

    }
}
// @lc code=end
