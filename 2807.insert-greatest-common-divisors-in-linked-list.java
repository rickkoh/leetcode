/*
 * @lc app=leetcode id=2807 lang=java
 *
 * [2807] Insert Greatest Common Divisors in Linked List
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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode result = head;
        while (head != null && head.next != null) {
            int gcd = gcd(head.val, head.next.val);
            ListNode n = new ListNode(gcd, head.next);
            head.next = n;
            head = head.next.next;
        }
        return result;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
// @lc code=end
