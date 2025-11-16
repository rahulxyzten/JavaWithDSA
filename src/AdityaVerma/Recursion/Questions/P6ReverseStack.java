package AdityaVerma.Recursion.Questions;
//Reverse a Stack by using Recursion

import java.util.Stack;

public class P6ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        stk.push(5);
        stk.push(6);
        reverse(stk);
        System.out.println(stk);
    }

    // T(C) = O(N^2)
    // S(C) = O(N), stack space used for recursive calls.
    public static void reverse(Stack<Integer> stk) {
        if (stk.size() == 1) return;
        int temp = stk.peek();
        stk.pop();
        reverse(stk);
        insert(stk, temp);
    }

    public static void insert(Stack<Integer> stk, int val) {
        if (stk.size() == 0) {
            stk.push(val);
            return;
        }

        int temp = stk.peek();
        stk.pop();
        insert(stk, val);
        stk.push(temp);
    }
}
