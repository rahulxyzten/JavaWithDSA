package TakeYouforward.StackAndQueue.Questions;
//Implementation of queue using an stack

import java.util.Stack;

public class P3ImplementStackUsingQueue {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(3);
        q.push(4);
        System.out.println("Popped element is " + q.pop());
        q.push(5);
        System.out.println("The top element is " + q.top());
        System.out.println("The size of the queue is " + q.size());
    }
}


//Optimal solution
//T(C) = O(1) amortized time complexity
//S(C) = O(2N)
class MyQueue {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        if (output.empty()) {
            while (!input.empty()) {
                output.push(input.peek());
                input.pop();
            }
        }
        int x = output.peek();
        output.pop();
        return x;
    }

    public int top() {
        if (output.empty()) {
            while (!input.empty()) {
                output.push(input.peek());
                input.pop();
            }
        }
        return output.peek();
    }

    int size() {
        return (output.size() + input.size());
    }
}