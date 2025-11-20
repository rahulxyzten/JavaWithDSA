package AdityaVerma.Recursion.Questions;
//Josephus Problem or Game of Death in a circle  Execution in Circle


import java.util.Vector;

public class P15JosephusProblem {
    public static void main(String[] args) {
//        int n = 5, k = 2;
        int n = 40, k = 7;
        Vector<Integer> v = new Vector<>();
        for (int i = 1; i <= n; i++) {
            v.add(i);
        }
        k = k - 1;
        int index = 0, ans = -1;
        System.out.println(solve(v, k, index, ans));
    }

    // T(C) = O(N * N) = O(N^2)
    // N recursive calls, each call performs a remove() operation that takes O(N)
    // S(C) = O(N) + O(N) = O(N)
    // Size of Vector + recursion stack (depth of the recursion)
    public static int solve(Vector<Integer> v, int k, int index, int ans) {
        if (v.size() == 1) {
            ans = v.get(0);
            return ans;
        }
        index = (index + k) % v.size();
        v.remove(index);
        int reslut = solve(v, k, index, ans);
        return reslut;
    }
}
