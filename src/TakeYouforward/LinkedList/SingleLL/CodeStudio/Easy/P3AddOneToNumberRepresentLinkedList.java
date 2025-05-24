package TakeYouforward.LinkedList.SingleLL.CodeStudio.Easy;
//Problem
/*
Add one to a number represented as Linked List

You're given a positive integer represented in the form of a singly linked-list of digits. The length of the number is 'n'.



Add 1 to the number, i.e., increment the given number by one.



The digits are stored such that the most significant digit is at the head of the linked list and the least significant digit is at the tail of the linked list.



Example:
Input: Initial Linked List: 1 -> 5 -> 2

Output: Modified Linked List: 1 -> 5 -> 3

Explanation: Initially the number is 152. After incrementing it by 1, the number becomes 153.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
3
1 5 2


Sample Output 1:
1 5 3


Explanation For Sample Input 1:
Initially the number is 152. After incrementing it by 1, the number becomes 153.


Sample Input 2:
2
9 9


Sample Output 2:
1 0 0


Explanation For Sample Input 2:
Initially the number is 9. After incrementing it by 1, the number becomes 100. Please note that there were 2 nodes in the initial linked list, but there are three nodes in the sum linked list.


Expected time complexity :
The expected time complexity is O('n').


Constraints:
1 <= 'n' <=  10^5
0 <= Node in linked list <= 9

There are no leading zeroes in the number.

Time Limit: 1 sec
 */

public class P3AddOneToNumberRepresentLinkedList {
    public static void main(String[] args) {
//        Node n1 = new Node(1);
//        Node n2 = new Node(5);
//        Node n3 = new Node(2);
//        Node head = n1;
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = null;
//        Node n1 = new Node(1);
//        Node n2 = new Node(9);
//        Node n3 = new Node(9);
//        Node head = n1;
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = null;
        Node n1 = new Node(9);
        Node n2 = new Node(9);
        Node n3 = new Node(9);
        Node head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = null;
        head = addOne(head);
        traverse(head);
    }

    //Recursive Approach
    //T(C) = O(N)
    //S(C) = O(N) recursive stack
    public static Node addOne(Node head) {
        if (head == null) return new Node(1);
        int carry = solveRecursive(head);
        if (carry == 1) {
            Node newNode = new Node(1);
            newNode.next = head;
            return newNode;
        }

        return head;
    }
    public static int solveRecursive(Node temp) {
        if (temp == null) return 1;
        int carry = solveRecursive(temp.next);
        temp.data = temp.data + carry;
        if (temp.data < 10) return 0;
        temp.data = 0;
        return 1;
    }


    //Iterative Approach
    //T(C) = O(3N)
    //S(C) = O(1)
//    public static Node addOne(Node head) {
//        if (head == null) return new Node(1);
//        head = reverse(head);
//        Node temp = head;
//        int carry = 1;
//        while (temp != null) {
//            temp.data = temp.data + carry;
//            if (temp.data < 10) {
//                carry = 0;
//                break;
//            } else {
//                temp.data = 0;
//                carry = 1;
//            }
//            temp = temp.next;
//        }
//        if (carry == 1) {
//            Node newNode = new Node(1);
//            head = reverse(head);
//            newNode.next = head;
//            return newNode;
//        }
//
//        head = reverse(head);
//        return head;
//    }
//
//    public static Node reverse(Node head) {
//        Node curr = head;
//        Node prev = null;
//        while (curr != null) {
//            Node temp = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = temp;
//        }
//        return prev;
//    }

    public static void traverse(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
