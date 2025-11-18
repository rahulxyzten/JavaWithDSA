package AdityaVerma.Recursion.Questions;
//Find the permutation with Letter Case

import java.util.Vector;

public class P12PermutationWithLetterCase {
    public static void main(String[] args) {
        String s = "a1B2";
        System.out.println(find(s));
    }

    // T(C) = O(2^N * N) = O(2^N)
    // total number of node O(2^N)
    // work done by a node => substring & concatenation takes O(N)
    // S(C) = O(2^N * N) + O(N) = O(2^N * N)
    // total number of string in Vector * length of each string + recursion stack (depth of the recursion)
    public static Vector<String> find(String s) {
        Vector<String> result = new Vector<>();
        String ip = s;
        String op = "";
        solve(ip, op, result);
        return result;
    }

    public static void solve(String ip, String op, Vector<String> result) {
        if (ip.length() == 0) {
            result.add(op);
            return;
        }

        if (Character.isAlphabetic(ip.charAt(0))) {
            String op1 = op;
            String op2 = op;
            op1 = op1 + Character.toLowerCase(ip.charAt(0));
            op2 = op2 + Character.toUpperCase(ip.charAt(0));
            ip = ip.substring(1);
            solve(ip, op1, result);
            solve(ip, op2, result);
        } else {
            String op1 = op;
            op1 = op1 + ip.charAt(0);
            ip = ip.substring(1);
            solve(ip, op1, result);
        }
    }
}
