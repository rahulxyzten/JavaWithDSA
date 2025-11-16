package AdityaVerma.Recursion.Questions;
//Sort a Stack by using Recursion

import java.util.Stack;

public class P4SortStack {
    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(3);
        stk.push(1);
        stk.push(5);
        stk.push(4);
        stk.push(2);
        System.out.println(stk);
        sort(stk);
        System.out.println(stk);
    }

    // T(C) = O(N^2)
    // S(C) = O(N), stack space used for recursive calls.
    public static void sort(Stack<Integer> stk) {
        if (stk.size() == 1) return;
        int temp = stk.peek();
        stk.pop();
        sort(stk);
        inset(stk, temp);
    }

    public static void inset(Stack<Integer> stk, int val) {
        if (stk.size() == 0 || stk.peek() <= val) {
            stk.push(val);
            return;
        }

        int temp = stk.peek();
        stk.pop();
        inset(stk, val);
        stk.push(temp);
    }
}
