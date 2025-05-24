package TakeYouforward.LinkedList.SingleLL.LeetCode.Easy;
//Problem
/*
21. Merge Two Sorted Lists

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.



Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]


Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
 */

public class P5MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode head1 = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = null;
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode head2 = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = null;
        ListNode head = mergeTwoLists(head1, head2);
        traverse(head);
    }


    //T(C) = O(N1 + N2)
    //S(C) = O(1)
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode t1 = list1, t2 = list2;
        ListNode dNode = new ListNode(-1);
        //dNode = dummy Node
        ListNode temp = dNode;
        while (t1 != null && t2 != null) {
            if (t1.val < t2.val) {
                temp.next = t1;
                temp = t1;
                t1 = t1.next;
            } else {
                temp.next = t2;
                temp = t2;
                t2 = t2.next;
            }
        }
        if (t1 != null) temp.next = t1;
        else temp.next = t2;

        return dNode.next;
    }

    public static void traverse(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }

}
