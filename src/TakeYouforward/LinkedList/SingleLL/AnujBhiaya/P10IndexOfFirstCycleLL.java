package TakeYouforward.LinkedList.SingleLL.AnujBhiaya;
//Detect a cycle in a Linked List and return the Node where the cycle start

public class P10IndexOfFirstCycleLL {
    public static void main(String[] args) {
        Node n1 = new Node(3);
        Node n2 = new Node(2);
        Node n3 = new Node(0);
        Node n4 = new Node(4);

        Node head = n1;
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
//        n4.next = n2;
        Node result = detectFirstNode(head);
        if (result != null) System.out.println(result.data);
        else System.out.println("null");

    }

    //Optimal Approach(Floyd's Cycle Detection Algorithm)
    //T(C) = O(N)
    //S(C) = O(1)
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
