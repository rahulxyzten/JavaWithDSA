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
        sort(stk);
        System.out.println(stk);
    }

    public static void sort(Stack<Integer> stk) {
        if (stk.size() == 1) return;
        int temp = stk.peek();
        stk.pop();
        sort(stk);
        insetTemp(stk, temp);
    }

    public static void insetTemp(Stack<Integer> stk, int temp) {
        if (stk.size() == 0 || stk.peek() <= temp) {
            stk.push(temp);
            return;
        }
        int val = stk.peek();
        stk.pop();
        insetTemp(stk, temp);
        stk.push(val);
    }
}
