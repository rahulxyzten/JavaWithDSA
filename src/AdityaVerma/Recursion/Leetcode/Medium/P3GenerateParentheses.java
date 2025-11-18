package AdityaVerma.Recursion.Leetcode.Medium;
//problem
/*
22. Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]


Constraints:

1 <= n <= 8
 */

import java.util.ArrayList;
import java.util.List;

public class P3GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }

    // T(C) = O(C(N) * N)
    // C(N) is the N-th Catalan number = (2N)!/(N+1)!N!
    // total number of node C(N)
    // work done by a node => concatenation takes O(N)
    // S(C) = O(C(N) * 2N) + O(2N) = O(C(N) * 2N)
    // total number of String in List * length of each string + recursion stack (maximum depth of the recursion)
    public static List<String> generateParenthesis(int n) {
        List<String> ls = new ArrayList<>();
        int open = n, close = n;
        String op = "";

        solve(ls, open, close, op);
        return ls;
    }

    public static void solve(List<String> ls, int open, int close, String op) {
        if (open == 0 && close == 0) {
            ls.add(op);
            return;
        }

        if (open != 0) {
            String op1 = op;
            op1 = op1 + '(';
            solve(ls, open - 1, close, op1);
        }

        if (close > open) {
            String op2 = op;
            op2 = op2 + ')';
            solve(ls, open, close - 1, op2);
        }

        return;
    }
}
