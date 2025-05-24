package TakeYouforward.LinkedList.SingleLL.LeetCode.Medium;
//problem
/*
142. Linked List Cycle II

Given the head of a linked list, return the ListNode where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some ListNode in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the ListNode that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.



Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: tail connects to ListNode index 1
Explanation: There is a cycle in the linked list, where tail connects to the second ListNode.
Example 2:


Input: head = [1,2], pos = 0
Output: tail connects to ListNode index 0
Explanation: There is a cycle in the linked list, where tail connects to the first ListNode.
Example 3:


Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.


Constraints:

The number of the ListNodes in the list is in the range [0, 104].
-105 <= ListNode.val <= 105
pos is -1 or a valid index in the linked-list.


Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */


public class P2LinkedListCycleII {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
        ListNode head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
//        n4.next = n2;
        ListNode result = detectFirstListNode(head);
        if (result != null) System.out.println(result.val);
        else System.out.println("null");
    }

    //Optimal Approach(Floyd's Cycle Detection Algorithm)
    //T(C) = O(N)
    //S(C) = O(1)
    public static ListNode detectFirstListNode(ListNode head) {
        ListNode meet = detectCycle(head);
        if (meet == null) return null;
        ListNode start = head;
        while (start != meet) {
            start = start.next;
            meet = meet.next;
        }

        return start;
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode first = head;
        while (first != null && first.next != null) {
            slow = slow.next;
            first = first.next.next;
            if (slow == first) return slow;
        }

        return null;
    }
}
