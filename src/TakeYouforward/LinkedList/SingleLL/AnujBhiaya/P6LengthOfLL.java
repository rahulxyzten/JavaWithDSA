package TakeYouforward.LinkedList.SingleLL.AnujBhiaya;
//Length of a Singly LinkedList or 1D LinkedList

public class P6LengthOfLL {
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
        System.out.println(findLength(head));
    }


    //T(C) = O(N) and S(C) = O(1)
    public static int findLength(Node head) {
        int count = 0;
        Node curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
}
