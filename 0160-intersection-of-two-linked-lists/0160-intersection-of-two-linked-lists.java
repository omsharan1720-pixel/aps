/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Base case: if either head is null, there can't be an intersection
        if (headA == null || headB == null) return null;

        ListNode pA = headA;
        ListNode pB = headB;

        // Loop until both pointers meet at the intersection node (or null)
        while (pA != pB) {
            // If pA reaches the end of list A, switch to the head of list B; otherwise move forward
            pA = (pA == null) ? headB : pA.next;
            
            // If pB reaches the end of list B, switch to the head of list A; otherwise move forward
            pB = (pB == null) ? headA : pB.next;
        }

        return pA;
    }
}