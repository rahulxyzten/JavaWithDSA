package TakeYouforward.StackAndQueue.Questions;
//Implementation of stack using an queue

import java.util.LinkedList;
import java.util.Queue;

public class P4ImplementQueueUsingStack {
    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(3);
        s.push(2);
        s.push(4);
        s.push(1);
        System.out.println("Top of the stack: " + s.top());
        System.out.println("Size of the stack before removing element: " + s.size());
        System.out.println("The deleted element is: " + s.pop());
        System.out.println("Top of the stack after removing element: " + s.top());
        System.out.println("Size of the stack after removing element: " + s.size());
    }
}

//Optimal Solution
//T(C) = O(N)
//S(C) = O(N)

class MyStack {
    Queue<Integer> q = new LinkedList<>();

    void push(int x) {
        q.add(x);
        for (int i = 0; i < q.size() - 1; i++) {
            int temp = q.remove();
            q.add(temp);
        }
    }

    int pop() {
        return q.remove();
    }

    int top() {
        return q.peek();
    }

    int size() {
        return q.size();
    }
}
