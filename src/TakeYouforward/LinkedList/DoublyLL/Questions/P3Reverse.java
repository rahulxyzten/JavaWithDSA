package TakeYouforward.LinkedList.DoublyLL.Questions;

public class P3Reverse {
    public static void main(String[] args) {
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        Node n4 = new Node(1);
        Node head = n1;
        n1.back = null;
        n1.next = n2;
        n2.back = n1;
        n2.next = n3;
        n3.back = n2;
        n3.next = n4;
        n4.back = n3;
        n4.next = null;
        head = reverse(head);
        traverse(head);
    }

    public static Node reverse(Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node prev = null;
        Node curr = head;
        while (curr != null){
            prev = curr.back;
            curr.back = curr.next;
            curr.next = prev;
            curr = curr.back;
        }
        return prev.back;
    }


    public static void traverse(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
