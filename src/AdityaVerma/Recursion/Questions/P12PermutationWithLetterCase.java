package AdityaVerma.Recursion.Questions;
////Find the permutation with Letter Case

import java.util.Vector;

public class P12PermutationWithLetterCase {
    public static void main(String[] args) {
        String s = "a1B2";
        System.out.println(find(s));
    }

    public static Vector<String> find(String s) {
        Vector<String> v = new Vector<>();
        String ip = s;
        String op = "";
        solve(ip, op, v);
        return v;
    }

    public static void solve(String ip, String op, Vector<String> v) {
        if (ip.length() == 0) {
            v.add(op);
            return;
        }
        if (Character.isAlphabetic(ip.charAt(0))) {
            String op1 = op;
            String op2 = op;
            op1 = op1 + Character.toLowerCase(ip.charAt(0));
            op2 = op2 + Character.toUpperCase(ip.charAt(0));
            ip = ip.substring(1);
            solve(ip, op1, v);
            solve(ip, op2, v);
        } else {
            String op1 = op;
            op1 = op1 + ip.charAt(0);
            ip = ip.substring(1);
            solve(ip, op1, v);
        }
    }
}
