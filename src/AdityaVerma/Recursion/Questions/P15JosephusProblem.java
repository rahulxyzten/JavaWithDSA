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
