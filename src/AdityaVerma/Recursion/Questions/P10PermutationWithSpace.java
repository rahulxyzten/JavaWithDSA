package AdityaVerma.Recursion.Questions;
// Find the permutation with space of a String
// Problem (GFG)
/*
Permutation with Spaces

Given a string s, generate all possible strings by optionally inserting a single space between every pair of adjacent characters. Return all such strings in lexicographically increasing order.

Examples:

Input: s = "ABC"
Output: (A B C)(A BC)(AB C)(ABC)
Explanation: The following are possible permutation of "ABC".
ABC
AB C
A BC
A B C
Input: s = "BBR"
Output: (B B R)(B BR)(BB R)(BBR)
Explanation: The following are possible permutation of "BBR".
BBR
BB R
B BR
B B R
Constraints:

1 ≤ s.size() ≤ 10
s consists only of English alphabets
 */

import java.util.ArrayList;
import java.util.Collections;

public class P10PermutationWithSpace {
    public static void main(String[] args) {
        String ip = "ABC";
        String op = "";
        op = op + ip.charAt(0);
        ip = ip.substring(1);
        solve(ip, op);
    }

    // Type 1
    // T(C) in recursive tree = work done by a node * total number of node
    // T(C) = O(2^N * N) = O(2^N)
    // total number of node O(2^N)
    // work done by a node => substring & concatenation takes O(N)
    // S(C) = O(N), recursion stack (depth of the recursion) and intermediate string construction
    public static void solve(String ip, String op) {
        if (ip.length() == 0) {
            System.out.println(op);
            return;
        }

        String op1 = op;
        String op2 = op;
        op1 = op1 + "_";
        op1 = op1 + ip.charAt(0);
        op2 = op2 + ip.charAt(0);
        ip = ip.substring(1);
        solve(ip, op1);
        solve(ip, op2);
    }

    // Type 2
    public static ArrayList<String> permutation(String s) {
        ArrayList<String> result = new ArrayList<>();
        solveSpace(s, "", result);
        Collections.sort(result);
        return result;
    }

    public static void solveSpace(String ip, String op, ArrayList<String> result) {
        if (ip.length() == 0) {
            result.add(op);
            return;
        }

        String op1 = op + ip.charAt(0);
        String op2 = op + ip.charAt(0) + " ";

        boolean secondCall = ip.length() > 1;
        ip = ip.substring(1);
        solveSpace(ip, op1, result);
        if (secondCall) solveSpace(ip, op2, result);
    }
}
