package TakeYouforward.LinkedList.DoublyLL.Questions;

public class P2Insertion {
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
        //head = insertHead(head);
        //head = insertTail(null);
       //head = insertBeforeKthNode(head, 4);
        insertBeforeNode(head.next.next);
        traverse(head);
    }

    //Insert a node before node and node != head (given)
    public static void insertBeforeNode(Node node) {
        if (node == null) return;
        Node prev = node.back;
        Node newNode = new Node(10, node, prev);
        prev.next = newNode;
        node.back = newNode;
    }

    //Insert a node before kth node
    public static Node insertBeforeKthNode(Node head, int k) {
        if (head == null) {
            return new Node(10, null, null);
        }
        if (k == 1) {
            return insertHead(head);
        }
        Node kthNode = head;
        int count = 0;
        while (kthNode != null) {
            count++;
            if (count == k) break;
            kthNode = kthNode.next;
        }
        Node prev = kthNode.back;
        Node newNode = new Node(10, kthNode, prev);
        kthNode.back = newNode;
        prev.next = newNode;

        return head;
    }

    //Insert a node before Tail
    public static Node insertTail(Node head) {
        if (head == null) {
            return new Node(10, null, null);
        }
        if (head.next == null) {
            return insertHead(head);
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node prev = tail.back;
        Node newNode = new Node(10, tail, prev);
        prev.next = newNode;
        tail.back = newNode;

        return head;
    }

    //Insert a node before head
    public static Node insertHead(Node head) {
        if (head == null) {
            return new Node(10, null, null);
        }
        Node newHead = new Node(10, head, null);
        head.back = newHead;
        return newHead;
    }


    public static void traverse(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
