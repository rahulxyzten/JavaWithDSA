package AdityaVerma.Recursion.Questions;
//Print N digits Binary Numbers having more or equals no of 1s then 0s (1s >= 0s) in all its prefix

public class P14NDigitsBinaryNumbers {
    public static void main(String[] args) {
        int n = 3;
        String op = "";
        int one = 0;
        int zero = 0;
        solve(one, zero, n, op);
    }

    public static void solve(int one, int zero, int n, String op) {
        if (n == 0) {
            System.out.println(op);
            return;
        }
        String op1 = op;
        op1 = op1 + '1';
        solve(one + 1, zero, n - 1, op1);
        if (one > zero) {
            String op2 = op;
            op2 = op2 + '0';
            solve(one, zero + 1, n - 1, op2);
        }
        return;
    }

}
