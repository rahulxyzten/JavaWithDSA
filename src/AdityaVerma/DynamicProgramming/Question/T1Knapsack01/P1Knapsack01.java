package AdityaVerma.DynamicProgramming.Question.T1Knapsack01;
// 0-1 Knapsack Problem

public class P1Knapsack01 {
    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] val = {1, 4, 5, 7};
        int weight = 7;
        System.out.println(knapsack(wt, val, weight, wt.length));
    }

    // Top Down Approach
    // T(C) = O(n * W)
    // S(C) = O(n * W)
    public static int knapsack(int[] wt, int[] val, int w, int n) {
        int[][] dp = new int[n + 1][w + 1];

        // No need fo this because the int array default value is 0
//        for (int i = 0; i <= n; i++) {
//            for (int j = 0; j <= w; j++) {
//                if (i == 0 || j == 0) dp[i][j] = 0;
//            }
//        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                int pick = 0;
                if (wt[i - 1] <= j) pick = val[i - 1] + dp[i - 1][j - wt[i - 1]];

                int notPick = dp[i - 1][j];

                dp[i][j] = Math.max(pick, notPick);
            }
        }

        return dp[n][w];
    }


    // Memoization Approach
    // T(C) = O(n * w)
    // S(C) = O(n * w) + O(n) {Recursive Stack}
//    public static int knapsack(int[] wt, int[] val, int weight, int n) {
//        int[][] memo = new int[n + 1][weight + 1];
//        for (int i = 0; i <= n; i++) {
//            for (int j = 0; j <= weight; j++) {
//                memo[i][j] = -1;
//            }
//        }
//
//        return solve(wt, val, weight, n, memo);
//    }
//
//    public static int solve(int[] wt, int[] val, int w, int n, int[][] memo) {
//        if (n == 0 || w == 0) return 0;
//        if (memo[n][w] != -1) return memo[n][w];
//
//        int pick = 0;
//        if (wt[n - 1] <= w) pick = val[n - 1] + solve(wt, val, w - wt[n - 1], n - 1, memo);
//
//        int notPick = solve(wt, val, w, n - 1, memo);
//
//        return memo[n][w] = Math.max(pick, notPick);
//    }


    // Recursive Approach
    // T(C) = O(2^n)
    // S(C) = O(n), Recursive Stack
//    public static int knapsack(int[] wt, int[] val, int weight, int n) {
//        if (n == 0 || weight == 0) return 0;
//
////        int pick = 0, notPick = 0;
////        if (wt[n - 1] <= weight) {
////            pick = Math.max(val[n - 1] + knapsack(wt, val, weight - wt[n - 1], n - 1), knapsack(wt, val, weight, n - 1));
////        } else if (wt[n - 1] > weight) {
////            notPick = knapsack(wt, val, weight, n - 1);
////        }
//
//        int pick = 0;
//        if (wt[n - 1] <= weight) pick = val[n - 1] + knapsack(wt, val, weight - wt[n - 1], n - 1);
//
//        int notPick = knapsack(wt, val, weight, n - 1);
//
//        return Math.max(pick, notPick);
//    }
}
