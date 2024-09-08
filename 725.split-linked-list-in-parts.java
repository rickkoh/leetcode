/*
 * @lc app=leetcode id=725 lang=java
 *
 * [725] Split Linked List in Parts
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int size = count / k;
        int remainder = count % k;
        ListNode[] ans = new ListNode[k];
        ListNode curr = head;
        for (int i = 0; i < k && head != null; i++) {
            ans[i] = head;
            for (int j = 0; j < (size + (i < remainder ? 1 : 0)) - 1; j++) {
                head = head.next;
            }
            curr = head.next;
            head.next = null;
            head = curr;
        }

        return ans;
    }
}
// @lc code=end
