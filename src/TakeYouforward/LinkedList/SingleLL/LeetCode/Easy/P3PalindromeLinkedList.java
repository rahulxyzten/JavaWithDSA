package TakeYouforward.LinkedList.SingleLL.LeetCode.Easy;
//Problem
/*
234. Palindrome Linked List

Given the head of a singly linked list, return true if it is a
palindrome
 or false otherwise.



Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false


Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9


Follow up: Could you do it in O(n) time and O(1) space?
 */

public class P3PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        ListNode head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        System.out.println(isPalindrome(head));
    }

    //T(C) = O(2N) & S(C) = O(1)
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode mid = middleNode(head);
        ListNode last = reverse(mid);
        ListNode curr = head;
        while (last != null) {
            if (curr.val != last.val) return false;
            curr = curr.next;
            last = last.next;
        }
        return true;
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        ListNode headNext = head.next;
        headNext.next = head;
        head.next = null;

        return newHead;
    }

}
