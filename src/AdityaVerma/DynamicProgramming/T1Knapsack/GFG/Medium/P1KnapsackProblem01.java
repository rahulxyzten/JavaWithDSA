package AdityaVerma.DynamicProgramming.T1Knapsack.GFG.Medium;
// Problem
/*
0 - 1 Knapsack Problem

Given two arrays, val[] and wt[], where each element represents the value and weight of an item respectively, and an integer W representing the maximum capacity of the knapsack (the total weight it can hold).

Put the items into the knapsack such that the total value obtained is maximum without exceeding the capacity W.

Note: You can either include an item completely or exclude it entirely — fractional selection of items is not allowed. Each item is available only once.

Examples :

Input: W = 4, val[] = [1, 2, 3], wt[] = [4, 5, 1]
Output: 3
Explanation: Choose the last item, which weighs 1 unit and has a value of 3.
Input: W = 3, val[] = [1, 2, 3], wt[] = [4, 5, 6]
Output: 0
Explanation: Every item has a weight exceeding the knapsack's capacity (3).
Input: W = 5, val[] = [10, 40, 30, 50], wt[] = [5, 4, 2, 3]
Output: 80
Explanation: Choose the third item (value 30, weight 2) and the last item (value 50, weight 3) for a total value of 80.
Constraints:

1 ≤ W, val.size(), val[i], wt[i] ≤ 10^3
wt.size() = val.size()
 */

public class P1KnapsackProblem01 {
    public static void main(String[] args) {
        int W = 4;
        int val[] = {1, 2, 3};
        int wt[] = {4, 5, 1};
        System.out.println(knapsack(W, val, wt));
    }

    // Optimal Approach (Top Down Approach)
    // T(C) = O(n * W)
    // S(C) = O(n * W)
    public static int knapsack(int W, int val[], int wt[]) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];

        // No need fo this because the int array default value is 0
//        for (int i = 0; i <= n; i++) {
//            for (int j = 0; j <= W; j++) {
//                if (i == 0 || j == 0) dp[i][j] = 0;
//            }
//        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                int pick = 0;
                if (wt[i - 1] <= j) pick = val[i - 1] + dp[i - 1][j - wt[i - 1]];

                int notPick = dp[i - 1][j];

                dp[i][j] = Math.max(pick, notPick);
            }
        }

        return dp[n][W];
    }


    // Optimal Approach (Memoization Approach)
    // T(C) = O(n * W)
    // S(C) = O(n * W) + O(n) {Recursive Stack}
//    public static int knapsack(int W, int val[], int wt[]) {
//        int n = wt.length;
//
//        int[][] memo = new int[n + 1][W + 1];
//        for (int i = 0; i <= n; i++) {
//            for (int j = 0; j <= W; j++) {
//                memo[i][j] = -1;
//            }
//        }
//
//        return solve(wt, val, W, n, memo);
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


    // Brute Force Approach (Recursive Approach)
    // T(C) = O(2^n)
    // S(C) = O(n), Recursive Stack
//    public static int knapsack(int W, int val[], int wt[]) {
//        return solve(wt, val, W, wt.length);
//    }
//
//    public static int solve(int[] wt, int[] val, int weight, int n) {
//        if (n == 0 || weight == 0) return 0;
//
//        int pick = 0;
//        if (wt[n - 1] <= weight) pick = val[n - 1] + solve(wt, val, weight - wt[n - 1], n - 1);
//
//        int notPick = solve(wt, val, weight, n - 1);
//
//        return Math.max(pick, notPick);
//    }
}
