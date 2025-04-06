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
    public boolean isPalindrome(ListNode head) {
        // Edge case: An empty list or a single node is always a palindrome.
        if (head == null || head.next == null) {
            return true;
        }
 
        // Step 1: Find the middle of the linked list using the fast and slow pointer technique.
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move slow pointer by one.
            fast = fast.next.next;    // Move fast pointer by two.
        }
        // After the loop, slow is at the middle of the list.
 
        // Step 2: Reverse the second half of the list.
        ListNode secondHalfHead = reverseList(slow);
 
        // Step 3: Compare the first half and the reversed second half.
        ListNode firstHalfPointer = head;
        ListNode secondHalfPointer = secondHalfHead;
        while (secondHalfPointer != null) {
            // If values don't match, it's not a palindrome.
            if (firstHalfPointer.val != secondHalfPointer.val) {
                return false;
            }
            firstHalfPointer = firstHalfPointer.next;
            secondHalfPointer = secondHalfPointer.next;
        }
 
        // If all nodes matched, the list is a palindrome.
        return true;
    }
 
    private ListNode copyList(ListNode head) {
        ListNode result = new ListNode();
        ListNode newHead = result;
        ListNode current = head;
        while (current != null) {
            result.val = current.val;
            result.next = current.next != null ? new ListNode() : null;
            result = result.next;
            current = current.next;
        }
        return newHead;
    }
 
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
 
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        // head = prev;
        return prev;
    }
}
