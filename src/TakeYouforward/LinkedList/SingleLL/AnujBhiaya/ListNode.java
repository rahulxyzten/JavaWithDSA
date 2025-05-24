package TakeYouforward.LinkedList.SingleLL.AnujBhiaya;


public class ListNode {
    public int data;
    public ListNode next;
    public ListNode child;

    ListNode() {
        this.data = 0;
        this.next = null;
        this.child = null;
    }

    ListNode(int data) {
        this.data = data;
        this.next = null;
        this.child = null;
    }

    ListNode(int data, ListNode next, ListNode child) {
        this.data = data;
        this.next = next;
        this.child = child;
    }
}
