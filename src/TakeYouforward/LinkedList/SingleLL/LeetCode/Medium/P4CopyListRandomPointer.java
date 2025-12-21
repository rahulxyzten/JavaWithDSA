package TakeYouforward.LinkedList.SingleLL.LeetCode.Medium;
// Problem
/*
138. Copy List with Random Pointer

A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.



Example 1:


Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
Example 2:


Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]
Example 3:



Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]


Constraints:

0 <= n <= 1000
-104 <= Node.val <= 104
Node.random is null or is pointing to some node in the linked list.
 */

import java.util.HashMap;

public class P4CopyListRandomPointer {
    public static void main(String[] args) {
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);
        Node head = n1;
        head.next = n2;
        n1.random = null;
        n2.next = n3;
        n2.random = n1;
        n3.next = n4;
        n3.random = n5;
        n4.next = n5;
        n4.random = n3;
        n5.next = null;
        n5.random = n1;
        head = copyRandomList(head);
        traverse(head);
    }

    // Optimal Solution
    // T(C) = O(N + N + N) = O(N)
    // S(C) = O(N), Answer space
    public static Node copyRandomList(Node head) {
        if (head == null) return null;
        /* This edge case is important otherwise need to change the below
          code according to edge case if you not write edge case*/

        /* Step 1 => Inserting new node in between */
        Node curr = head;
        while (curr != null) {
            Node temp = curr.next;
            Node newNode = new Node(curr.val);
            curr.next = newNode;
            newNode.next = temp;
            curr = temp;
        }

        /* Step 2 => Setting random pointer of newNode*/
        curr = head;
        while (curr != null) {
            curr.next.random = (curr.random != null) ? curr.random.next : null;
            curr = curr.next.next;
        }

        /* Step 3 => Separating both Lined Lists */
        curr = head;
        Node copy = head.next;
        Node copyHead = copy;
        while (curr != null) {
            curr.next = curr.next.next;
            copy.next = (copy.next != null) ? copy.next.next : null;

            curr = curr.next;
            copy = copy.next;
        }

        return copyHead;
    }


    // Better Force Approach (Using HashMap)
    // T(C) = O(N) + O(N) = O(N)
    // S(C) = O(N) + O(N), HashMap + Answer Space
//    public static Node copyRandomList(Node head) {
//        if (head == null) return null;
//
//        HashMap<Node, Node> mpp = new HashMap<>();
//        Node curr = head;
//        while (curr != null) {
//            Node newNode = new Node(curr.val);
//            mpp.put(curr, newNode);
//            curr = curr.next;
//        }
//
//        curr = head;
//        while (curr != null) {
//            Node tempCopy = mpp.get(curr);
//
//            /* set next */
//            tempCopy.next = mpp.get(curr.next);
//
//            /* set random */
//            tempCopy.random = mpp.get(curr.random);
//
//            curr = curr.next;
//        }
//
//        return mpp.get(head);
//    }


    // Brute Force Approach
    // T(C) = O(N) + O(N^2) = O(N^2)
    // S(C) = O(N), Answer space
//    public static Node copyRandomList(Node head) {
//        if (head == null) return null;
//
//        Node currOrg = head;
//        Node dummyNode = new Node(-1);
//        Node currCopy = dummyNode;
//
//        /* Step 1: Create deep copy of nodes with next pointers
//        (handling values and 'next' pointers) */
//        while (currOrg != null) {
//            Node newNode = new Node(currOrg.val);
//            currCopy.next = newNode;
//            currCopy = newNode;
//            currOrg = currOrg.next;
//        }
//        // temp.next = null;
//        // Node need of this line => by default a node next is null
//
//        /* Step 2: Connect random pointers */
//        currOrg = head;
//        currCopy = dummyNode.next;
//        while (currOrg != null) {
//            Node random = currOrg.random;
//            if (random != null) {
//                Node tempOrg = head;
//                int disRandom = 1;
//                while (tempOrg != random) {
//                    disRandom++;
//                    tempOrg = tempOrg.next;
//                }
//
//                Node tempCopy = dummyNode.next;
//                disRandom--;
//                while (disRandom != 0) {
//                    disRandom--;
//                    tempCopy = tempCopy.next;
//                }
//                currCopy.random = tempCopy;
//            }
//
//            currCopy = currCopy.next;
//            currOrg = currOrg.next;
//        }
//
//        return dummyNode.next;
//    }

    public static void traverse(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
