class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // Create a dummy node that points to the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Use 'prev' to track the node BEFORE the one we are checking
        ListNode prev = dummy;
        
        while (prev.next != null) {
            if (prev.next.val == val) {
                // Skip the node with the target value
                prev.next = prev.next.next;
            } else {
                // Only move 'prev' forward if we DIDN'T delete a node
                prev = prev.next;
            }
        }
        
        // Return the actual head (which dummy.next points to)
        return dummy.next;
    }
}
