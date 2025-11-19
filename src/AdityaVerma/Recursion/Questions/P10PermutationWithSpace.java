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
        return;
    }
}
