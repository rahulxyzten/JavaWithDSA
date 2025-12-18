package TakeYouforward.LinkedList.SingleLL.LeetCode.Medium;
// Problem
/*
148. Sort List

Given the head of a linked list, return the list after sorting it in ascending order.



Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []


Constraints:

The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105


Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 */

public class P7SortList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        ListNode head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        head = sortList(head);
        traverse(head);
    }

    // Optimal Solution (Merge Sort)
    // T(C) = O(NlogN)
    // S(C) = O(1)
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode middle = middleNode(head);
        ListNode leftHead = head, rightHead = middle.next;
        middle.next = null;

        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);

        return mergeTwoLists(leftHead, rightHead);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode t1 = list1, t2 = list2;
        ListNode dNode = new ListNode(-1);
        // dNode = dummy Node

        ListNode curr = dNode;
        while (t1 != null && t2 != null) {
            if (t1.val < t2.val) {
                curr.next = t1;
                curr = t1;
                t1 = t1.next;
            } else {
                curr.next = t2;
                curr = t2;
                t2 = t2.next;
            }
        }

        if (t1 != null) curr.next = t1;
        else curr.next = t2;

        return dNode.next;
    }


    // Brute Force Approach (Selection Sort)
    // Not pass all the testcases because it's asking the T(C) = O(NlongN)
    // T(C) = O(N^2)
    // S(C) = O(1)
//    public static ListNode sortList(ListNode head) {
//        if (head == null || head.next == null) return head;
//
//        ListNode curr = head;
//        while (curr != null) {
//            ListNode temp = curr;
//            while (temp != null) {
//                if (temp.val < curr.val) {
//                    int tempVal = temp.val;
//                    temp.val = curr.val;
//                    curr.val = tempVal;
//                }
//
//                temp = temp.next;
//            }
//
//            curr = curr.next;
//        }
//
//        return head;
//    }

    public static void traverse(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
