package TakeYouforward.LinkedList.SingleLL.AnujBhiaya;
//Remove cycle in a linked list

public class P11RemoveCycleInLL {
    public static void main(String[] args) {
        Node n1 = new Node(3);
        Node n2 = new Node(2);
        Node n3 = new Node(0);
        Node n4 = new Node(4);

        Node head = n1;
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        head = removeCycle(head);
        traverse(head);
    }

    public static Node removeCycle(Node head) {
        Node prev = detectPreviousFirstNode(head);
        prev.next = null;
        //here the question is says that the linked list must have a cycle
        //so the prev is never have a null value or the meet is also never have a null value
        return head;
    }

    public static Node detectPreviousFirstNode(Node head) {
        Node meet = detectCycle(head);
        if (meet == null) return null;
        Node prev = null;
        Node start = head;
        while (start != meet) {
            prev = meet;
            start = start.next;
            meet = meet.next;
        }

        return prev;
    }

    public static Node detectCycle(Node head) {
        Node slow = head;
        Node first = head;
        while (first != null && first.next != null) {
            slow = slow.next;
            first = first.next.next;
            if (slow == first) return slow;
        }

        return null;
    }

    public static void traverse(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
