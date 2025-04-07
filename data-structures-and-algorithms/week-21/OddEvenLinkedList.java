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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddHead = head;
        ListNode evenHead = head.next;
 
        ListNode currentOdd = oddHead;
        ListNode currentEven = evenHead;
 
        while (currentEven != null && currentEven.next != null) {
            /*
                      /---------\    /---------\
             oh    eh/           \  /    co     \ce
            (@1)  (@2)  (@3)    (@4)    (@5) -> (@6) -> null
                \_________/ \___________/
            */
 
            currentOdd.next = currentEven.next;
            currentOdd = currentOdd.next;
 
            currentEven.next = currentOdd.next;
            currentEven = currentEven.next;
        }
 
        currentOdd.next = evenHead;
        return oddHead;
    }
}
