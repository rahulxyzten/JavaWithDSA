package TakeYouforward.LinkedList.SingleLL.AnujBhiaya;

import java.util.ArrayDeque;
import java.util.Queue;

public class P12FlattenAMultilevelLL {
    public static void main(String[] args) {

    }

    //Optimal Approach
    //T(C) = O(N)
    //S(C) = O(1)
    public static ListNode flattenLinkedList(ListNode head) {
        if (head == null) return null;
        ListNode temp;

        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        ListNode curr = head;
        while (curr != tail) {
            if (curr.child != null) {
                tail.next = curr.child;
                temp = curr.child;
                while (temp.next != null) {
                    temp = temp.next;
                }
                tail = temp;
            }
            curr = curr.next;
        }

        return head;
    }


    //Brute Force Approach (Using Queue)
    //T(C) = O(N)
    //S(C) = O(N)
//    public static ListNode flattenLinkedList(ListNode head) {
//        ListNode curr = head;
//        Queue<ListNode> q = new ArrayDeque<>();
//
//        while (curr != null) {
//            if (curr.child != null) {
//                q.add(curr.child);
//            }
//            if (curr.next == null) {
//                curr.next = q.poll();
//                //poll() Retrieves and removes the head of this queue, or returns null if this queue is empty.
//            }
//            curr = curr.next;
//        }
//        return head;
//    }
}
