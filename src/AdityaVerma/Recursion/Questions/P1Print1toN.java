package AdityaVerma.Recursion.Questions;

public class P1Print1toN {
    public static void main(String[] args) {
        print(5);
    }


    //IBH method for Recursion
    // T(C) = O(N)
    // S(C) = O(N), stack space used for recursive calls.
    public static void print(int n) {
        if (n == 1) {
            System.out.println(1);
            return;
        }
        print(n - 1);
        System.out.println(n);
    }
}
