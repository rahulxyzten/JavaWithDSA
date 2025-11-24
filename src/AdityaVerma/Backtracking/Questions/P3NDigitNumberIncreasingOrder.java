package AdityaVerma.Backtracking.Questions;


import java.util.ArrayList;

public class P3NDigitNumberIncreasingOrder {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(increasingNumbers(n));
    }

    // T(C) = O(9^N * N)
    // Total number of node => O(9^N)
    // Work done by a node => Contracting the integer from ArrayList takes O(N)
    // S(C) = O(9^N) + O(N) = O(9^N)
    // Total number of integer in ArrayList +  recursion stack (depth of the recursion)
    public static ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        if (n == 1) {
            for (int i = 0; i < 10; i++) {
                result.add(i);
            }
            return result;
        }
        // This base condition for n == 1 must need
        // If not written then in solve function it add [1->9] to result
        // The answer is [0->9]

        ArrayList<Integer> v = new ArrayList<>();
        solve(n, v, result);
        return result;
    }

    public static void solve(int n, ArrayList<Integer> v, ArrayList<Integer> result) {
        if (n == 0) {
            int ans = 0;
            for (Integer num : v) {
                ans = ans * 10 + num;
            }
            result.add(ans);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (v.size() == 0 || i > v.get(v.size() - 1)) {
                v.add(i);
                solve(n - 1, v, result);
                v.remove(v.size() - 1);
            }
        }

    }
}
