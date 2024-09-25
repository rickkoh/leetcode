/*
 * @lc app=leetcode id=3043 lang=java
 *
 * [3043] Find the Length of the Longest Common Prefix
 */

// @lc code=start
class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();

        for (int val : arr1) {
            String str = val + "";
            int len = str.length();
            for (int i = 0; i < len; i++) {
                int curr = Integer.parseInt(str.substring(0, i + 1));
                set.add(curr);
            }
        }

        int ans = 0;
        for (int val : arr2) {
            String str = val + "";
            int len = str.length();

            for (int i = ans; i < len; i++) {
                int curr = Integer.parseInt(str.substring(0, i + 1));
                if (set.contains(curr)) {
                    ans = i + 1;
                }
            }

        }

        return ans;
    }
}
// @lc code=end
