package TakeYouforward.LinkedList.SingleLL.AnujBhiaya;
//Detect a cycle in a Linked List


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

    //Optimal Approach(Floyd's Cycle Detection Algorithm)
    //T(C) = O(N)
    //S(C) = O(1)
    public static boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;
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
//    public static boolean hasCycle(Node head) {
//        HashMap<Node, Integer> mpp = new HashMap<>();
//        Node curr = head;
//        while (curr != null) {
//            if (mpp.containsKey(curr)) return true;
//            mpp.put(curr, 1);
//            curr = curr.next;
//        }
//        return false;
//    }
}
