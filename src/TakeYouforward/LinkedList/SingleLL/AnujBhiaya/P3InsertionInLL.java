package TakeYouforward.LinkedList.SingleLL.AnujBhiaya;
//Insertion in a Singly LinkedList or 1D LinkedList


public class P3InsertionInLL {
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
//        head = insert(30, head, 0);
        head = insert(30, head, 3);
        traverse(head);
    }


    //T(C) = O(N) and S(C) = O(1)
    //because in the worst case it will ask to inset at last of the linked list
    //so the for loop run to n-1
    public static Node insert(int data, Node head, int pos) {
        Node toAdd = new Node(data);
        if (pos == 0) {
            toAdd.next = head;
            head = toAdd;
            return head;
        }
        /*
        However, when you reassign head within the insert function,
        it only updates the local reference and does not affect the original
        head in the main method.
        so for pos 0 it not print the ll with insert the element at first
         */
        Node prev = head;
        for (int i = 0; i < pos - 1; i++) {
            prev = prev.next;
        }
        toAdd.next = prev.next;
        prev.next = toAdd;
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
