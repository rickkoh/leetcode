/*
 * @lc app=leetcode id=1894 lang=java
 *
 * [1894] Find the Student that Will Replace the Chalk
 */

// @lc code=start
class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        while (true) {
            for (int i = 0; i < chalk.length; i++) {
                if (chalk[i] > k) {
                    return i;
                }
                k -= chalk[i];
            }
        }
    }
}
// @lc code=end
