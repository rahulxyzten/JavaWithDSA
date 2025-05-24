package TakeYouforward.StackAndQueue.Questions;
//Implementation of stack using an array

public class P1ImplementStackUsingArray {
    public static void main(String[] args) {
        stack s = new stack();
        s.push(6);
        s.push(3);
        s.push(7);
        System.out.println("Top the stack " + s.top());
        System.out.println("Size of the stack " + s.size());
        System.out.println("Can stack is empty " + s.isEmpty());
        System.out.println("The deleted element is " + s.pop());
        System.out.println("The size after deletion " + s.size());
        System.out.println("The top after deletion " + s.top());
    }
}

//T(C) = O(1)
//S(C) = O(N)
class stack {
    int size = 10000;
    int arr[] = new int[size];
    int top = -1;

    void push(int x) {
        top++;
        arr[top] = x;
    }

    int pop() {
        int x = arr[top];
        top--;
        return x;
    }

    int top() {
        return arr[top];
    }

    int size() {
        return top + 1;
    }

    boolean isEmpty() {
        return (top == -1);
    }
}
