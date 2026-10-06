/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Check if there are at least k nodes in the current list
        ListNode cursor = head;
        int count = 0;
        while (cursor != null && count < k) {
            cursor = cursor.next;
            count++;
        }
        
        // If fewer than k nodes remain, return head as is
        if (count < k) {
            return head;
        }
        
        // Reverse the first k nodes
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        
        for (int i = 0; i < k; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        // Recursively reverse the remaining list and connect
        head.next = reverseKGroup(curr, k);
        
        // `prev` becomes the new head of the reversed k-group
        return prev;
    }
}