package AdityaVerma.Recursion.Questions;
//Generate All Balanced Parenthesis for a given n

import java.util.Vector;

public class P13GenerateAllBalancedParenthesis {
    public static void main(String[] args) {
        int n = 3;
        Vector<String> result = new Vector<>();
        int open = n;
        int close = n;
        String op = "";
        solve(result, open, close, op);
        System.out.println(result);
    }

    public static void solve(Vector<String> result, int open, int close, String op) {
        if (open == 0 && close == 0) {
            result.add(op);
            return;
        }
        if (open != 0) {
            String op1 = op;
            op1 = op1 + '(';
            solve(result, open - 1, close, op1);
        }
        if (close > open) {
            String op2 = op;
            op2 = op2 + ')';
            solve(result, open, close - 1, op2);
        }
        return;
    }
}
