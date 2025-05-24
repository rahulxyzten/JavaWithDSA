package TakeYouforward.LinkedList.SingleLL.AnujBhiaya;
//Insertion at first position in a Singly LinkedList or 1D LinkedList

public class P2InsertionAtFirstInLL {
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
        head = insert(30, head);
        traverse(head);
    }


    //T(C) = O(1) and S(C) = O(1)
    public static Node insert(int data, Node head) {
        Node toAdd = new Node(data);
        toAdd.next = head;
        head = toAdd;
        return head;
    }

    public static void traverse(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
