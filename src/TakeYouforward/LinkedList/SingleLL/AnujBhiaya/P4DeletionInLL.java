package TakeYouforward.LinkedList.SingleLL.AnujBhiaya;
//Deletion in a Singly LinkedList or 1D LinkedList

public class P4DeletionInLL {
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
//        head = delete(head, 0);
        head = delete(head, 3);
        traverse(head);
    }


    //T(C) = O(N) and S(C) = O(1)
    //because in the worst case it will ask to delete the last node of the linked list
    //so the for loop run to n-1
    public static Node delete(Node head, int pos) {
        if (pos == 0) {
            head = head.next;
            return head;
        }
        Node prev = head;
        for (int i = 0; i < pos - 1; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
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
