/*
 * @lc app=leetcode id=3217 lang=java
 *
 * [3217] Delete Nodes From Linked List Present in Array
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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        ListNode ans = new ListNode();
        for (ListNode curr = head, prev = ans; curr != null; curr = curr.next) {
            if (!set.contains(curr.val)) {
                prev.next = new ListNode(curr.val);
                prev = prev.next;
            }
        }

        return ans.next;
    }
}
// @lc code=end
