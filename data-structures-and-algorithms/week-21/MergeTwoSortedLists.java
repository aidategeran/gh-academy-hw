class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if (l1 == null) {
            // If l1 has ended, return the remaining chain of l2.
            return l2;
        }
        if (l2 == null) {
            // If l2 has ended, return the remaining chain of l1.
            return l1;
        }
        if (l1.val < l2.val) {
            // If the current node from l1 has a smaller value, then
            // let l1.val be the first node of the merged lists and attach
            // after it (l1.next = ...) the rest of the l1 merged with l2.
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        // Otherwise,
        // let l2.val be the first node of the merged lists and attach
        // after it (l2.next = ...) the rest of the l2 merged with l1.
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
}
