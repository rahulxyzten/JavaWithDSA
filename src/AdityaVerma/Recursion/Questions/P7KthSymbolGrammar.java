package AdityaVerma.Recursion.Questions;
//Find the kth symbol in Grammar


public class P7KthSymbolGrammar {
    public static void main(String[] args) {
        int n = 4;
        int k = 6;
        System.out.println(solve(n, k));
    }

    // T(C) = O(n)
    // S(C) = O(n), stack space used for recursive calls.
    public static int solve(int n, int k) {
        if (n == 1 && k == 1) {
            return 0;
        }
        int mid = (int) Math.pow(2, n - 1) / 2;
//        int mid = ((int) (Math.pow(2, (double) n - 1))) / 2;
        if (k <= mid) {
            return solve(n - 1, k);
        } else {
            return (solve(n - 1, k - mid) == 0) ? 1 : 0;
        }
    }

    /*One more observation*/
//    public static int solve(int n, int k) {
//        if(n==1)
//        {
//            return 0;
//        }
//        int parent = solve(n-1,(k+1)/2);
//        if(k%2 == 0 )
//        {
//            return parent==1?0:1;
//        }
//        else
//        {
//            return parent;
//        }
//    }
}
