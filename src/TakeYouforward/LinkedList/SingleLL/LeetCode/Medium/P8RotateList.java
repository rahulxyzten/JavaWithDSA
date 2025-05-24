package TakeYouforward.LinkedList.SingleLL.LeetCode.Medium;
//Problem
/*
61. Rotate List

Given the head of a linked list, rotate the list to the right by k places.



Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:


Input: head = [0,1,2], k = 4
Output: [2,0,1]


Constraints:

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109
 */

public class P8RotateList {
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
        head = rotateRight(head, 2);
        traverse(head);
    }

    //Optimal Solution
    //T(C) = O(N) + O(N - (k%N))
    //S(C) = O(1)
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode temp = head;
        int length = 1;
        //finding the length and tail of ll
        while (temp.next != null) {
            length++;
            temp = temp.next;
        }
        temp.next = head;
        k = k % length;
        int end = length - k;
        while (end != 0) {
            end--;
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;

        return head;
    }

//    //Brute Force Approach
//    //T(C) = O(K * N)
//    //S(C) = O(1)
//    //But the above approach shows "Time Limit Exceeded" Error
//    //for some testcases like list = [1,2,3] and k = 2000000000
//    public static ListNode rotateRight(ListNode head, int k) {
//        if (head == null || head.next == null) return head;
//        for (int i = 0; i < k; i++) {
//            ListNode temp = head;
//            while (temp.next.next != null) temp = temp.next;
//            ListNode end = temp.next;
//            temp.next = null;
//            end.next = head;
//            head = end;
//        }
//        return head;
//    }

    //Brute Force Approach (My solution)
    //T(C) = O(K * N)
    //S(C) = O(1)
    //But the above approach shows "Time Limit Exceeded" Error
    //for some testcases like list = [1,2,3] and k = 2000000000
//    public static ListNode rotateRight(ListNode head, int k) {
//        if (head == null || head.next == null) return head;
//        ListNode newHead = head;
//        while (k > 0) {
//            ListNode curr = newHead;
//            ListNode prev = null;
//            while (curr.next != null) {
//                 prev = curr;
//                curr = curr.next;
//            }
//            prev.next = null;
//            curr.next = newHead;
//            newHead = curr;
//            k--;
//        }
//       return newHead;
//    }

    public static void traverse(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
