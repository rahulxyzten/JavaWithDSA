package TakeYouforward.LinkedList.SingleLL.LeetCode.Easy;
//problem
/*
206. Reverse Linked List

Given the head of a singly linked list, reverse the list, and return the reversed list.


Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:


Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []


Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000


Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?


 */

public class P1ReverseLinkedList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        head = reverseList(head);
        traverse(head);
    }


    /* Iterative Approach T(C) = O(N) and S(C) = O(1) */
//    public static ListNode reverseList(ListNode head) {
//        ListNode curr = head;
//        ListNode prev = null;
//        while (curr != null) {
//            ListNode temp = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = temp;
//        }
//        return prev;
//    }


    /* Recursive Approach T(C) = O(N) and S(C) = O(1) or if u take space of
    recursion stack then it will be O(N) */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        ListNode headNext = head.next;
        headNext.next = head;
        head.next = null;

        return newHead;
    }

    public static void traverse(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }


}
