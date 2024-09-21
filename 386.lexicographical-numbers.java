/*
 * @lc app=leetcode id=386 lang=java
 *
 * [386] Lexicographical Numbers
 */

// @lc code=start
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>(n);
        ans.add(1);
        for (int i = 1, prev = 1; i < n; ++i) {
            if (prev * 10 <= n) {
                prev *= 10;
            } else {
                while (prev % 10 == 9 || prev == n)
                    prev /= 10;
                prev++;
            }
            ans.add(prev);
        }
        return ans;
    }
}
// @lc code=end
