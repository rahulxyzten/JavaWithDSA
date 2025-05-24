package TakeYouforward.LinkedList.SingleLL.CodeStudio.Easy;
//Problem
/*
Sort linked list of 0s 1s 2s

Given a linked list of 'N' nodes, where each node has an integer value that can be 0, 1, or 2. You need to sort the linked list in non-decreasing order and the return the head of the sorted list.



Example:
Given linked list is 1 -> 0 -> 2 -> 1 -> 2.
The sorted list for the given linked list will be 0 -> 1 -> 1 -> 2 -> 2.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
7
1 0 2 1 0 2 1


Sample Output 1:
0 0 1 1 1 2 2


Explanation Of Sample Input 1:
Input: 1 -> 0 -> 2 -> 1 -> 0 -> 2 -> 1

Output: 0 -> 0 -> 1 -> 1 -> 1 -> 2 -> 2

Explanation:
In this example, the original linked list contains two 0s, three 1s, and two 2s. The sorted linked list has all the 0s at the beginning, followed by all the 1s, and finally, all the 2s at the end.


Sample Input 2:
8
2 1 0 2 1 0 0 2


Sample Output 2:
0 0 0 1 1 2 2 2


Follow Up:
Can you solve this without updating the Nodes of the given linked list?


Constraints :
1 <= N <= 10^3
0 <= data <= 2

Where 'N' is the length of the linked list.

Time Limit: 1 sec
 */

public class P2SortLinkedListOf1s2s {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(0);
        Node n3 = new Node(2);
        Node n4 = new Node(1);
        Node n5 = new Node(2);
        Node head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        head = sortList(head);
        traverse(head);
    }


    //Optimal Solution
    //T(C) = O(N)
    //S(C) = O(1)
    public static Node sortList(Node head) {
        if (head == null || head.next == null) return head;

        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);
        Node zero = zeroHead, one = oneHead, two = twoHead;

        Node curr = head;
        while (curr != null) {
            if (curr.data == 0) {
                zero.next = curr;
                zero = curr;
            } else if (curr.data == 1) {
                one.next = curr;
                one = curr;
            } else {
                two.next = curr;
                two = curr;
            }
            curr = curr.next;
        }
        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

        return zeroHead.next;
    }

    //Brute Force Approach
    //T(C) = O(2N)
    //S(C) = O(1)
//    public static Node sortList(Node head) {
//        int count0 = 0, count1 = 0, count2 = 0;
//        Node curr = head;
//        while (curr != null) {
//            if (curr.data == 0) count0++;
//            else if (curr.data == 1) count1++;
//            else count2++;
//            curr = curr.next;
//        }
//        curr = head;
//        while (curr != null) {
//            if (count0 != 0) {
//                curr.data = 0;
//                count0--;
//            } else if (count1 != 0) {
//                curr.data = 1;
//                count1--;
//            } else {
//                curr.data = 2;
//            }
//            curr = curr.next;
//        }
//
//        return head;
//    }

    public static void traverse(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
