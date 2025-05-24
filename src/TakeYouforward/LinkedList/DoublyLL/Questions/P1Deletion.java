package TakeYouforward.LinkedList.DoublyLL.Questions;

public class P1Deletion {
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
//        head = deletionHead(head);
//        head = deletionTail(head);
//        head = deletionKthNode(head, 3);
        deletionNode(head.next.next.next);
        traverse(head);
    }

    //the node is not head (given condition)
    public static void deletionNode(Node node) {
        Node prev = node.back;
        Node front = node.next;
        if (front == null) {
            prev.next = null;
            node.back = null;
            return;
        }
        prev.next = front;
        front.back = prev;
        node.next = null;
        node.back = null;
    }

    public static Node deletionKthNode(Node head, int k) {
        if (head == null) return null;
        Node kthNode = head;
        int count = 0;
        while (kthNode != null) {
            count++;
            if (count == k) break;
            kthNode = kthNode.next;
        }
        Node prev = kthNode.back, front = kthNode.next;
        if (prev == null && front == null) return null;
        if (prev == null) return deletionHead(head);
        if (front == null) return deletionTail(head);
        prev.next = front;
        front.back = prev;
        kthNode.next = null;
        kthNode.back = null;

        return head;
    }

    public static Node deletionTail(Node head) {
        if (head == null || head.next == null) return null;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node prev = tail.back;
        tail.back = null;
        prev.next = null;
        return head;
    }

    public static Node deletionHead(Node head) {
        if (head == null || head.next == null) return null;
        Node prev = head;
        head = head.next;
        head.back = null;
        prev.next = null;
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
