/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = nums[0] + nums[1] + nums[2];
        int min = Math.abs(ans - target);
        // sort the array
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                int diff = Math.abs(sum - target);
                if (diff < min) {
                    min = diff;
                    ans = sum;
                }
                if (sum < target) {
                    l++;
                } else if (sum > target) {
                    r--;
                } else {
                    return sum;
                }
            }
        }
        return ans;
    }
}
// @lc code=end
