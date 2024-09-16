/*
 * @lc app=leetcode id=539 lang=java
 *
 * [539] Minimum Time Difference
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] minutes = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            int h = Integer.parseInt(timePoints.get(i).substring(0, 2));
            int m = Integer.parseInt(timePoints.get(i).substring(3));
            minutes[i] = h * 60 + m;
        }

        Arrays.sort(minutes);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < minutes.length; i++) {
            int diff = ((minutes[(i + 1) % minutes.length] - minutes[i]) + 1440) % 1440;
            min = Math.min(min, diff);
        }

        return min;
    }
}
// @lc code=end
