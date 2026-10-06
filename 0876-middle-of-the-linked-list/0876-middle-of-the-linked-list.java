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
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        // Traverse until 'fast' reaches the end of the list
        while (fast != null && fast.next != null) {
            slow = slow.next;       // Moves 1 step
            fast = fast.next.next;  // Moves 2 steps
        }
        
        // When fast reaches the end, slow is precisely at the middle node
        return slow;
    }
}