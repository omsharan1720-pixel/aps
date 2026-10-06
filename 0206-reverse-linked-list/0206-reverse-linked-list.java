class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode nextTemp = current.next; // Store the next node
            current.next = prev;              // Reverse the current node's pointer
            prev = current;                   // Move the prev pointer forward
            current = nextTemp;               // Move the current pointer forward
        }
        
        return prev; // 'prev' will be the new head of the reversed list
    }
}