package TakeYouforward.LinkedList.SingleLL.AnujBhiaya;
//Find the element in a Singly LinkedList or 1D LinkedList

public class P7SearchElementInLL {
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
        System.out.println(find(head, 25));
    }

    //T(C) = O(N) and S(C) = O(1)
    public static boolean find(Node head, int ele) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == ele) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
}
