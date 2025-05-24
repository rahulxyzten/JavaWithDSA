package TakeYouforward.LinkedList.SingleLL.AnujBhiaya;
//Find the middle element in a Singly LinkedList or 1D LinkedList
//Check the Singly LinkedList or 1D LinkedList is Palindrome or not

public class P8MiddleAndPalindromeOfLL {
    public static void main(String[] args) {
        Node n1 = new Node(5);
        Node n2 = new Node(10);
        Node n3 = new Node(5);
        Node n4 = new Node(11);
        Node n5 = new Node(5);
//        Node n6 = new Node(5);
        Node head = n1;
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
//        n5.next = n6;
//        n6.next = null;
//        System.out.println(n5.next != null);
//        System.out.println(n5);
//        System.out.println(n5.next);
//        Node mid = middle(head);
//        Node revHead = reverse(mid);
        System.out.println(palindrome(head));
    }

    public static boolean palindrome(Node head) {
        if (head == null) return true;
        Node mid = middle(head);
        Node last = reverse(mid);
        Node curr = head;
        while (last != null) {
            if (curr.data != last.data) return false;
            last = last.next;
            curr = curr.next;
        }
        return true;
    }

    //Below code work for odd and even, last = reverse(mid.next)
//    public static Node middle(Node head) {
//        Node slow = head;
//        Node fast = head;
//        while (fast.next != null && fast.next.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return slow;
//    }


    //Below code is work for odd and even, last = reverse(mid);
    public static Node middle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverse(head.next);
        Node nextHead = head.next;
        nextHead.next = head;
        head.next = null;

        return newHead;
    }

}
