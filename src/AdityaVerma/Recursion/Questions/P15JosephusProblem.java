package AdityaVerma.Recursion.Questions;
// Josephus Problem or Game of Death in a circle or Execution in Circle


import java.util.Vector;

public class P15JosephusProblem {
    public static void main(String[] args) {
//        int n = 5, k = 3;
        int n = 40, k = 7;
        Vector<Integer> v = new Vector<>();
        for (int i = 1; i <= n; i++) {
            v.add(i);
        }
        k = k - 1;
        int index = 0;
        System.out.println(solve(v, k, index));
    }

    // T(C) = O(N * N) = O(N^2)
    // N recursive calls, each call performs a remove() operation that takes O(N)
    // S(C) = O(N) + O(N) = O(N)
    // Size of Vector + recursion stack (depth of the recursion)
    public static int solve(Vector<Integer> v, int k, int index) {
        if (v.size() == 1) return v.get(0);

        index = (index + k) % v.size();
        v.remove(index);
        return solve(v, k, index);
    }
}
