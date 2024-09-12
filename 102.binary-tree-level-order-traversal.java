/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
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
    class MyNode {
        int level;
        TreeNode node;

        public MyNode(TreeNode node, int level) {
            this.level = level;
            this.node = node;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<MyNode> queue = new LinkedList();

        queue.add(new MyNode(root, 0));

        List<List<Integer>> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            MyNode current = queue.poll();
            TreeNode node = current.node;
            int level = current.level;

            if (level == ans.size()) {
                ans.add(new ArrayList<>());
            }

            ans.get(level).add(node.val);
            if (node.left != null) {
                queue.add(new MyNode(node.left, level + 1));
            }
            if (node.right != null) {
                queue.add(new MyNode(node.right, level + 1));
            }

        }

        return ans;
    }
}
// @lc code=end
