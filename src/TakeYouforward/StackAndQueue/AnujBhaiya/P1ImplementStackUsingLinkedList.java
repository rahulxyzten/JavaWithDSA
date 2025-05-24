package TakeYouforward.StackAndQueue.AnujBhaiya;
//Implementation of stack using a Linked List

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class P1ImplementStackUsingLinkedList {
    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(3);
        s.push(2);
        s.push(4);
        s.push(1);
        System.out.println("Top of the stack: " + s.peek());
        System.out.println("Size of the stack before removing element: " + s.size());
        System.out.println("Is empty : "+ s.isEmpty());
        System.out.println("The deleted element is: " + s.pop());
        System.out.println("Top of the stack after removing element: " + s.peek());
        System.out.println("Size of the stack after removing element: " + s.size());
    }
}

//T(C) = O(1)
//S(C) = O(N)
class MyStack {
    Node head;
    int size;

    public MyStack() {
        head = null;
        size = 0;
    }

    void push(int data) {
        Node temp = new Node(data);
        temp.next = head;
        size++;
        head = temp;
    }

    int peek() {
        if (head == null) {
            System.out.println("Stack is empty");
        }
        return head.data;
    }

    int pop() {
        if (head == null) {
            System.out.println("Stack is empty");
        }
        int res = head.data;
        head = head.next;
        size--;
        return res;
    }

    boolean isEmpty() {
        return head == null;
    }

    int size() {
        return size;
    }
}

