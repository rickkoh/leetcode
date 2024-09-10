/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 */

// @lc code=start

import java.util.List;
import java.util.Queue;

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
    public boolean isValidBST(TreeNode root) {
        List<Integer> check = new ArrayList<>();

        addInorder(root, check);

        for (int i = 0; i < check.size(); i++) {
            if (i > 0 && check.get(i - 1) >= check.get(i)) {
                return false;
            }

            if (i < check.size() - 1 && check.get(i) > check.get(i + 1)) {
                return false;
            }
        }

        return true;
    }

    public void addInorder(TreeNode root, List<Integer> temp) {
        if (root == null) {
            return;
        }

        addInorder(root.left, temp);
        temp.add(root.val);
        addInorder(root.right, temp);
    }

}
// @lc code=end
