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

        if (count == 0) {
            return new ListNode[k];
        }

        int size = count / k;
        int remainder = count % k;
        ListNode[] ans = new ListNode[k];
        int idx = 0;
        ListNode curr = head;
        while (idx < k) {
            ans[idx] = curr;
            int partSize = size + (remainder > 0 ? 1 : 0);
            remainder--;

            for (int i = 0; i < partSize - 1; i++) {
                if (curr != null) {
                    curr = curr.next;
                }
            }

            if (curr.next != null) {
                ListNode next = curr.next;
                curr.next = null;
                curr = next;
            } else {
                break;
            }

            idx++;
        }

        return ans;
    }
}
// @lc code=end
