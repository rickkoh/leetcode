/*
 * @lc app=leetcode id=2326 lang=java
 *
 * [2326] Spiral Matrix IV
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] result = new int[m][n];

        int t = 0;
        int b = m;
        int l = -1;
        int r = n;

        int direction = 1;
        int x = 0;
        int y = 0;

        for (int i = 0; i < (m * n); i++) {
            if (head != null) {
                result[x][y] = head.val;
                head = head.next;
            } else {
                result[x][y] = -1;
            }

            if (direction % 4 == 0) {
                if (x - 1 != t) {
                    x--;
                } else {
                    t++;
                    direction++;
                    y++;
                }
            } else if (direction % 4 == 1) {
                if (y + 1 != r) {
                    y++;
                } else {
                    r--;
                    direction++;
                    x++;
                }
            } else if (direction % 4 == 2) {
                if (x + 1 != b) {
                    x++;
                } else {
                    b--;
                    direction++;
                    y--;
                }
            } else {
                if (y - 1 != l) {
                    y--;
                } else {
                    l++;
                    direction++;
                    x--;
                }
            }

        }

        return result;
    }
}
// @lc code=end
