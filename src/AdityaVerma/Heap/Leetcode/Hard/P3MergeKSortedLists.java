package AdityaVerma.Heap.Leetcode.Hard;
// Problem
/*
23. Merge k Sorted Lists

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.



Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []


Constraints:

k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.
 */

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class P3MergeKSortedLists {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        lists[2] = new ListNode(2, new ListNode(6));

        // Merging the lists
        ListNode mergedList = mergeKLists(lists);

        // Outputting the merged list
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }

    }


    // Optimal Solution
    // T(C) = O(k log k ) + O((n*k) log k) = O((n*k) log k)
    // S(C) = O(K)
//    public static ListNode mergeKLists(ListNode[] lists) {
//        if (lists.length == 0) return null;
//        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
//
//        for (ListNode list : lists) {
//            if (list != null) {
//                minHeap.add(list);
//            }
//        }
//
//        ListNode dummy = new ListNode(-1);
//        ListNode curr = dummy;
//
//        while (!minHeap.isEmpty()) {
//            ListNode min = minHeap.poll();
//            curr.next = min;
//            curr = curr.next;
//            if (min.next != null) {
//                minHeap.add(min.next);
//            }
//        }
//
//        return dummy.next;
//    }


    // Using Flatten A Linked List logic
    // T(C) = O(N x 2M) = O(2NM)
    // N => Number of Lists
    // M => Length of the longest Linked List
    // S(C) = O(N) {recursive stack}
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, lists.length, 0);
    }

    public static ListNode merge(ListNode[] lists, int n, int i) {
        if (i == (n - 1)) return lists[i];

        ListNode rootNext = merge(lists, n, i + 1);
        return mergeTwoLists(lists[i], rootNext);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode t1 = list1, t2 = list2;
        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;

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

        return dummyNode.next;
    }
}
