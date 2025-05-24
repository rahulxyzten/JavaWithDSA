package AdityaVerma.Recursion.Questions;
//Print the Subset || Subsequences || PowersSet of a String
//For above all the three cases print all the subset of a String

public class P8SubsetSubsequencePowerSet {
    public static void main(String[] args) {
//        String ip = "abc";
        String ip = "ab";
        String op = "";
        solve(ip, op);
    }

    public static void solve(String ip, String op) {
        if (ip.length() == 0) {
            System.out.println(op);
            return;
        }
        String op1 = op;
        String op2 = op;
        op2 = op2 + ip.charAt(0);
        ip = ip.substring(1);
        solve(ip, op1);
        solve(ip, op2);
        return;
    }
}
