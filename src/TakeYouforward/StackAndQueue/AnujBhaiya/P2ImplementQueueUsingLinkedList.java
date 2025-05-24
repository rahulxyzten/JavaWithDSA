package TakeYouforward.StackAndQueue.AnujBhaiya;
//Implementation of queue using a Linked List

public class P2ImplementQueueUsingLinkedList {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
         q.enqueue(5);
         q.enqueue(7);
        System.out.println("Is Empty "+q.isEmpty());
        System.out.println("Popped Element "+q.dequeue());
        System.out.println("Popped Element "+q.dequeue());
        System.out.println("Is Empty "+q.isEmpty());
    }
}

//T(C) = O(1)
//S(C) = O(N)
class MyQueue {
    Node front, rear;

    void enqueue(int data) {
        Node newNode = new Node(data);
        if (front == null) { //empty queue
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    int dequeue() {
        if (front == null) {
            System.out.println("Queue is empty.");
        }
        int result = front.data;
        front = front.next;
        //if in ll one element is present then by-default that element next is point to null
        // then the front.next = null
        return result;
    }
    boolean isEmpty(){
        return front == null;
    }
}
