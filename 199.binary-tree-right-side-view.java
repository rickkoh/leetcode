/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> output = new ArrayList<>();

        right(root, output, 0);

        return output;
    }

    private void right(TreeNode curr, List<Integer> output, int depth) {
        if (curr == null) {
            return;
        }

        if (depth == output.size()) {
            output.add(curr.val);
        }

        right(curr.right, output, depth + 1);
        right(curr.left, output, depth + 1);
    }
}
// @lc code=end
