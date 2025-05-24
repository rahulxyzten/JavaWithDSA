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
