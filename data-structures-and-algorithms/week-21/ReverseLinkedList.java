class Solution {
    public ListNode reverseList(ListNode head) {
        //recursive solution//
        return reverseListRecursive(head, null);
    }

    //Before the first call linked list looks like below 
    // head -> head.next -> head.next.next -> head.next.next.next -> ... -> head.(many) -> null

    //First call
    // reverseListRecursive(head, null)
    // null <- head head.next -> head.next.next -> head.next.next.next -> ... -> head.(many) -> null

    //Second call
    //reverseListRecursive(head, null)
    // null <- head <- head.next  head.next.next -> head.next.next.next -> ... -> head.[many] -> null

    //Third call
    //null <- head <- head.next <- head.next.next   head.next.next.next -> ... -> head.[many] -> null

    // And so on... until last call reverseListRecursive(null, head.[many]) is called
    // null <- <- head <- head.next <- head.next.next <- head.next.next.next <- ... <- head.[many] null
    // when then return head.[many] and it is going back to line 14,  because it is the new head.

    private ListNode reverseListRecursive( ListNode currentNode, ListNode newNext) {
        if (currentNode == null ) return newNext;
        ListNode oldNext = currentNode.next;
        currentNode.next = newNext;
        return reverseListRecursive( oldNext, currentNode);
    }
}
