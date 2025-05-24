package TakeYouforward.LinkedList.SingleLL.CodeStudio.Easy;
//Problem
/*
Find length of Loop

You’re given a linked list. The last node might point to null, or it might point to a node in the list, thus forming a cycle.



Find out whether the linked list has a cycle or not, and the length of the cycle if it does.



If there is no cycle, return 0, otherwise return the length of the cycle.



Example:
Input: Linked List: 4 -> 10 -> 3 -> 5 -> 10(at position 2)

Output: Length of cycle = 3

Explanation: The cycle is 10, 3, 5.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
4
4 10 3 5
2
Sample Output 1:
3
Explanation Of Sample Input 1 :
The cycle is 10, 3, 5.
Sample Input 2 :
4
4 10 3 5
0
Sample Output 2 :
0
Explanation Of Sample Input 2 :
Since ‘p’ = 0, the last node is pointing to null, so no cycle exists.


Constraints:
1 <= ‘n’ <= 100000
1 <= Data in linked list node <= 10^9
0 <= ‘p’ <= ‘n’
 */

public class P1FindLengthOfLoop {
    public static void main(String[] args) {
        Node n1 = new Node(4);
        Node n2 = new Node(10);
        Node n3 = new Node(3);
        Node n4 = new Node(5);
        Node head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
//        n4.next = n2;
        System.out.println(lengthOfLoop(head));
    }

    //T(C) = O(N)
    //S(C) = O(1)
    public static int lengthOfLoop(Node head) {
        Node firstNode = detectFirstNode(head);
        if (firstNode == null) return 0;
        Node curr = firstNode.next;
        int count = 1;
        while (curr != firstNode) {
            count++;
            curr = curr.next;
        }

        return count;
    }

    public static Node detectFirstNode(Node head) {
        Node meet = detectCycle(head);
        if (meet == null) return null;
        Node start = head;
        while (start != meet) {
            start = start.next;
            meet = meet.next;
        }

        return start;
    }

    public static Node detectCycle(Node head) {
        Node slow = head;
        Node first = head;
        while (first != null && first.next != null) {
            slow = slow.next;
            first = first.next.next;
            if (slow == first) return slow;
        }

        return null;
    }
}
