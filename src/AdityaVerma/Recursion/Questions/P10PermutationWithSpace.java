package AdityaVerma.Recursion.Questions;
//Find the permutation with space of a String

public class P10PermutationWithSpace {
    public static void main(String[] args) {
        String ip = "ABC";
        String op = "";
        op = op + ip.charAt(0);
        ip = ip.substring(1);
        solve(ip, op);
    }

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
        return;
    }
}
