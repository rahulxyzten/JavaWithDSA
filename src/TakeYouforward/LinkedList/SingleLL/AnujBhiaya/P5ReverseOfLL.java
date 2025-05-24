package TakeYouforward.LinkedList.SingleLL.AnujBhiaya;
//Reverse of Singly LinkedList or 1D LinkedList


public class P5ReverseOfLL {
    public static void main(String[] args) {
        Node n1 = new Node(5);
        Node n2 = new Node(10);
        Node n3 = new Node(15);
        Node n4 = new Node(24);
        Node n5 = new Node(40);
        Node head = n1;
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        head = reverse(head);
        traverse(head);
    }


    /* Iterative Approach T(C) = O(N) and S(C) = O(1) */
    public static Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    /* Recursive Approach T(C) = O(N) and S(C) = O(1) or if u take space of
    recursion stack then it will be O(N) */
//    public static Node reverse(Node head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        Node newHead = reverse(head.next);
//        Node headNext = head.next;
//        headNext.next = head;
//        head.next = null;
//
//        return newHead;
//    }

    public static void traverse(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
