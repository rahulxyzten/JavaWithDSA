package AdityaVerma.Recursion.Questions;
//Delete the middle element of a stack by using Recursion

import java.util.Stack;

public class P5DeleteMiddleElementStack {
    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        stk.push(5);
        stk.push(6);
        deleteMiddleElementStack(stk);
        System.out.println(stk);
    }

    public static void deleteMiddleElementStack(Stack<Integer> stk) {
        int n = stk.size();
        if (n == 0) return;

        int k = (n / 2) + 1;

        solve(stk, k);
    }

    public static void solve(Stack<Integer> stk, int k) {
        if (k == 1) {
            stk.pop();
            return;
        }
        int temp = stk.peek();
        stk.pop();
        solve(stk, k - 1);
        stk.push(temp);
    }
}
