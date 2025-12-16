package TakeYouforward.LinkedList.SingleLL.AnujBhiaya;
// Detect a cycle in a Linked List


import java.util.HashMap;

public class P9DetectACycleInALL {
    public static void main(String[] args) {
        Node n1 = new Node(3);
        Node n2 = new Node(2);
        Node n3 = new Node(0);
        Node n4 = new Node(4);

        Node head = n1;
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        System.out.println(hasCycle(head));
    }

    // Optimal Approach(Floyd's Cycle Detection Algorithm)
    // T(C) = O(N)
    // S(C) = O(1)
    public static boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
            // The if statement present at last only
        }

        return false;
    }

    // Brute Force Approach (Using HashMap)
    // T(C) = O(N)
    // S(C) = O(N)
//    public static boolean hasCycle(Node head) {
//        HashMap<Node, Integer> mpp = new HashMap<>();
//        Node curr = head;
//        while (curr != null) {
//            if (mpp.containsKey(curr)) return true;
//            mpp.put(curr, 1);
//            curr = curr.next;
//        }
//
//        return false;
//    }
}
