package TakeYouforward.LinkedList.SingleLL.AnujBhiaya;
//Creation and Traverse of a Singly LinkedList or 1D LinkedList

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class P1CreationOfLL {
    public static void main(String[] args) {
        //creation of Linked-list
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node head = n1;
        head.next = n2;
        n2.next = n3;
        n3.next = null;
        traverse(head);
    }

    //Traverse of LinkedList
    //T(C) = O(N) and S(C) = O(1)
    public static void traverse(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

}
