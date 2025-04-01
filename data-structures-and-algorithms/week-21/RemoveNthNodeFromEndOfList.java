class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Assume that linked list is as below
        // (0) -> (1) -> (2) -> (3) -> (4) -> (5) -> (6) -> null
        // and n = 3.
        // 
        // Now, create two pointers `slow` and `fast` and
        // initialize both to be at the head node.
        // slow, fast (0) -> (1) -> (2) -> (3) -> (4) -> (5) -> (6) -> null
        // 
        // Then, move `fast` pointer n = 3 nodes further to 
        // slow (0) -> (1) -> (2) -> fast (3) -> (4) -> (5) -> (6) -> null
        // and then start walking both `slow` and `fast` one step at a time
        // until fast.next is null.
        //
        // slow (0) -> (1) -> (2) -> fast (3) -> (4) -> (5) -> (6) -> null
        // (0) -> slow (1) -> (2) -> (3) -> fast (4) -> (5) -> (6) -> null
        // (0) -> (1) -> slow (2) -> (3) -> (4) -> fast (5) -> (6) -> null
        // (0) -> (1) -> (2) -> slow (3) -> (4) -> (5) -> fast (6) -> null
        //
        // As you can see, `slow` pointer stopped one element before the one
        // which should be removed (`slow.next` should be removed).
        // Now, we remove `slow.next` by doing `slow.next = slow.next.next`,
        // practically removing `slow.next` from the list.
        ListNode fast=head, slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // The only corner case is that if n == length of the linked list, then
        // we need to remove the head node. `fast` will be initially moved to the null
        // after the tail element. If that's the case, practically remove the `head` node
        // by returning the rest of the linked list (head.next) after `head`. 
        if(fast == null ){
            return head.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
