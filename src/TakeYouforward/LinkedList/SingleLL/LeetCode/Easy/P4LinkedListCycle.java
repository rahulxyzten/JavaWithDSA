package TakeYouforward.LinkedList.SingleLL.LeetCode.Easy;
//Problem
/*
141. Linked List Cycle

Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.



Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Example 2:
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
Example 3:


Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.


Constraints:

The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.


Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */


import java.util.HashMap;

public class P4LinkedListCycle {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
        ListNode head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        System.out.println(hasCycle(head));
    }

    //Optimal Approach(Floyd's Cycle Detection Algorithm)
    //T(C) = O(N)
    //S(C) = O(1)
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    //Brute Force Approach (Using HashMap)
    //T(C) = O(N * 2 * log(N))
    //insertion and search operations in the unordered_map have a worst-case time complexity of O(log(N))
    /*
        The insertion and search operations in the unordered_map have a worst-case
        time complexity of O(log(N)). As the loop iterates through N nodes, the total
        time complexity is determined by the product of the traversal (O(N)) and the
        average-case complexity of the hashmap operations (insert and search),
        resulting in O(N * 2 * log(N)).
     */
    //S(C) = O(N)
//    public static boolean hasCycle(ListNode head) {
//        HashMap<ListNode, Integer> mpp = new HashMap<>();
//        ListNode curr = head;
//        while (curr != null) {
//            if (mpp.containsKey(curr)) return true;
//            mpp.put(curr, 1);
//            curr = curr.next;
//        }
//        return false;
//    }
}
