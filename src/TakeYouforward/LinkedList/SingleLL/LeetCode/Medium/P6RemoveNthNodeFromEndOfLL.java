package TakeYouforward.LinkedList.SingleLL.LeetCode.Medium;
//Problem
/*
19. Remove Nth Node From End of List

Given the head of a linked list, remove the nth node from the end of the list and return its head.



Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]


Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz


Follow up: Could you do this in one pass?
 */

public class P6RemoveNthNodeFromEndOfLL {
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
        n5.next = null;
//        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode head = n1;
//        n1.next = n2;
//        n2.next = null;
        head = removeNthFromEnd(head, 2);
        traverse(head);
    }


    //Optimal Solution
    //T(C) = O(N)
    //S(C) = O(1)
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) return head.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }


    //Brute Force Approach
    //T(C) = O(N) + O(N-n)
    //In worst cse T(C) = O(N) + O(N) = O(2N)
    //S(C) = O(1)
//    public static ListNode removeNthFromEnd(ListNode head, int n) {
//        int length = count(head);
//        int pos = length - n;
//        if (pos == 0) {
//            head = head.next;
//            return head;
//        }
//        ListNode prev = head;
//        for (int i = 1; i < pos; i++) {
//            prev = prev.next;
//        }
//        prev.next = prev.next.next;
//        return head;
//    }
//
//    public static int count(ListNode head) {
//        ListNode curr = head;
//        int count = 0;
//        while (curr != null) {
//            count++;
//            curr = curr.next;
//        }
//        return count;
//    }

    public static void traverse(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
