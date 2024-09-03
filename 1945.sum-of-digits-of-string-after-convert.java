/*
 * @lc app=leetcode id=1945 lang=java
 *
 * [1945] Sum of Digits of String After Convert
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public int getLucky(String s, int k) {
        String str = "abcdefghijklmnopqrstuvwxyz";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), i + 1);
        }

        // Convert
        String sb = "";
        for (Character c : s.toCharArray()) {
            sb += map.get(c);
        }

        // Transform
        Integer ans = 0;
        while (k-- > 0) {
            ans = 0;
            for (Character c : sb.toCharArray()) {
                ans += Character.getNumericValue(c);
            }
            sb = String.valueOf(ans);
        }

        return ans;
    }
}
// @lc code=end
