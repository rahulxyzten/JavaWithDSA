package TakeYouforward.StackAndQueue.Questions;
//Implementation of queue using an array

public class P2ImplementQueueUsingArray {
    public static void main(String[] args) {
        Queue q = new Queue(6);
        q.push(4);
        q.push(14);
        q.push(24);
        q.push(34);
        System.out.println("The peek of the queue before deleting any element " + q.top());
        System.out.println("The size of the queue before deletion " + q.size());
        System.out.println("The queue is before deletion");
        q.traverse();
        System.out.println();
        System.out.println("The first element to be deleted " + q.pop());
        q.push(50);
        q.push(60);
        q.push(70);
        System.out.println("The peek of the queue after deleting an element " + q.top());
        System.out.println("The size of the queue after deleting an element " + q.size());
        System.out.println("The queue is after deletion");
        q.traverse();
    }
}

//T(C) = O(1)
//S(C) = O(N)
class Queue {
    private int arr[];
    private int front = 0, rear = 0, currSize = 0, maxSize;

    public Queue() {
        arr = new int[16];
    }

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public void push(int newElement) {
        if (currSize == maxSize) {
            System.out.println("Queue is full!");
            System.exit(1);
        }
        arr[rear % maxSize] = newElement;
        rear++;
        currSize++;
    }

    public int pop() {
        if (currSize == 0) {
            System.out.println("Queue is empty");
            System.exit(1);
        }
        int popped = arr[front];
        arr[front % maxSize] = 0;
        front++;
        currSize--;
        return popped;
    }

    public int top() {
        if (currSize == 0) {
            System.out.println("Queue is Empty!");
            System.exit(1);
        }
        return arr[front % maxSize];
    }

    public int size() {
        return currSize;
    }

    public void traverse() {
        for (int i = front; i <= rear - 1; i++) {
            System.out.print("The index " + i % maxSize + " is " + arr[i % maxSize] + " , ");
        }
    }
}
