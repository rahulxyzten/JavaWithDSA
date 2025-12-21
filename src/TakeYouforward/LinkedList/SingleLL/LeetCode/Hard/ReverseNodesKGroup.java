package TakeYouforward.LinkedList.SingleLL.LeetCode.Hard;
// Problem
/*
25. Reverse Nodes in k-Group

Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
 

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000
 

Follow-up: Can you solve the problem in O(1) extra memory space?
 */


import java.util.List;

public class ReverseNodesKGroup {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        ListNode head = a1;
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = null;
        head = reverseKGroup(head, 2);
        traverse(head);
    }

    // Optimal solution
    // T(C) = O(N + N) = O(2N)
    // S(C) = O(1)
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode prevNode = null, nextNode;
        while (curr != null) {
            ListNode kthNode = findKthNode(curr, k);
            if (kthNode == null) {
                if (prevNode != null) {
                    prevNode.next = curr;
                }
                break;
            }

            nextNode = kthNode.next;
            kthNode.next = null;
            reverseList(curr);
            if (curr == head) {
                head = kthNode;
            } else {
                prevNode.next = kthNode;
            }

            prevNode = curr;
            curr = nextNode;
        }

        return head;
    }

    public static ListNode findKthNode(ListNode curr, int k) {
        k = k - 1;
        while (curr != null && k != 0) {
            k--;
            curr = curr.next;
        }

        return curr;
    }
    /* Below code show null pointer exception for some test cases
     * like if i/p = [1] and k = 4
     * so after some temp = temp.next is show null pointer error
     */
//    public static ListNode findKthNode(ListNode temp, int k) {
//        for (int i = 0; i < k - 1; i++) {
//            temp = temp.next;
//        }
//        return temp;
//    }

    public static void reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
    }

    public static void traverse(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
