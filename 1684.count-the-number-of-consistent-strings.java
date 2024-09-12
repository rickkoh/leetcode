/*
 * @lc app=leetcode id=1684 lang=java
 *
 * [1684] Count the Number of Consistent Strings
 */

// @lc code=start
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] allowedChars = new boolean[26];
        for (char c : allowed.toCharArray()) {
            allowedChars[c - 'a'] = true;
        }

        int count = 0;
        for (String word : words) {
            boolean isConsistent = true;
            for (char c : word.toCharArray()) {
                if (!allowedChars[c - 'a']) {
                    isConsistent = false;
                    break;
                }
            }
            if (isConsistent) {
                count++;
            }
        }

        return count;
        // int count = 0;
        // for (String word : words) {
        // for (String c : allowed.split("")) {
        // word = word.replaceAll(c, "");
        // }
        // if (word.length() == 0) {
        // count += 1;
        // }
        // }
        // return count;
    }
}

// @lc code=end
