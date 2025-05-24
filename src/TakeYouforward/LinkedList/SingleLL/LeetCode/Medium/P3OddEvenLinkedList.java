package TakeYouforward.LinkedList.SingleLL.LeetCode.Medium;
//Problem
/*
328. Odd Even Linked List

Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.



Example 1:


Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
Example 2:


Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]


Constraints:

The number of nodes in the linked list is in the range [0, 104].
-106 <= Node.val <= 106
 */

import java.util.ArrayList;

public class P3OddEvenLinkedList {
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
        head = oddEvenList(head);
        traverse(head);
    }

    //Optimal Approach
    //T(C) = O(N/2 * 2) = O(N)
    //S(C) = O(1)
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head, even = head.next, evenHead = head.next;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return head;
    }


    //Brute Force Approach
    //T(C) = O( N/2 + N/2 + N) =  O(2N)
    //S(C) = O(N)
    /*You must solve the problem in O(1) extra space complexity and O(n) time complexity.*/

//    public static ListNode oddEvenList(ListNode head) {
//        if (head == null && head.next == null) return head;
//
//        ArrayList<Integer> arr = new ArrayList<>();
//
//        //add the even index node value to arr
//        ListNode temp = head;
//        while (temp != null && temp.next != null) {
//            arr.add(temp.val);
//            temp = temp.next.next;
//        }
//        if (temp != null) arr.add(temp.val);
//
//        //add the odd index node value to arr
//        temp = head.next;
//        while (temp != null && temp.next != null) {
//            arr.add(temp.val);
//            temp = temp.next.next;
//        }
//        if (temp != null) arr.add(temp.val);
//
//        //add the array which value which is in the form of first all even index element and
//        //then all the odd index element
//        int i = 0;
//        temp = head;
//        while (temp != null) {
//            temp.val = arr.get(i);
//            i++;
//            temp = temp.next;
//        }
//
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
