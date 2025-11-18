package AdityaVerma.Recursion.Questions;
//Print the subsets with unique element

import java.util.HashSet;

public class P9UniqueSubsets {
    public static void main(String[] args) {
        String ip = "aabc";
        String op = "";
        HashSet<String> result = new HashSet<>();
        solve(ip, op, result);
        System.out.println(result);
    }

    // T(C) = O(2^N * N) = O(2^N)
    // total number of node O(2^N)
    // work done by a node => substring & concatenation takes O(N)
    // S(C) = O(2^N * N) + O(N) = O(2^N * N)
    // total number of subsequences in HashSet * maximum length of HashSet element + recursion stack (depth of the recursion)
    public static void solve(String ip, String op, HashSet<String> result) {
        if (ip.length() == 0) {
            result.add(op);
            return;
        }

        String op1 = op;
        String op2 = op;
        op2 = op2 + ip.charAt(0);
        ip = ip.substring(1);
        solve(ip, op1, result);
        solve(ip, op2, result);
    }
}
