package AdityaVerma.DynamicProgramming.T1Knapsack.GFG.Medium;
// Problem
/*
Count Subsets with Sum

Given an array arr[] of non-negative integers and an integer target, count all subsets of the array whose sum is equal to the given target.

Examples:

Input: arr[] = [5, 2, 3, 10, 6, 8], target = 10
Output: 3
Explanation: The subsets {5, 2, 3}, {2, 8}, and {10} sum up to the target 10.
Input: arr[] = [2, 5, 1, 4, 3], target = 10
Output: 3
Explanation: The subsets {2, 1, 4, 3}, {5, 1, 4}, and {2, 5, 3} sum up to the target 10.
Input: arr[] = [5, 7, 8], target = 3
Output: 0
Explanation: There are no subsets of the array that sum up to the target 3.
Input: arr[] = [35, 2, 8, 22], target = 0
Output: 1
Explanation: The empty subset is the only subset with a sum of 0.
Constraints:

1 ≤ arr.size() ≤ 10^3
0 ≤ arr[i], target ≤ 10^3
 */

public class P3CountSubsetsSum {
    public static void main(String[] args) {
//        int[] arr = {5, 2, 3, 10, 6, 8};
//        int target = 10;

        int[] arr = {1, 2, 0, 0};
        int target = 3;
        System.out.println(perfectSum(arr, target));
    }

    // Optimal Approach (Top Down Approach)
    // T(C) = O(n * target)
    // S(C) = O(n * target)
    public static int perfectSum(int[] arr, int target) {
        int n = arr.length;

        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                int pick = 0;
                if (arr[i - 1] <= j) pick = dp[i - 1][j - arr[i - 1]];

                int notPick = dp[i - 1][j];

                dp[i][j] = pick + notPick;
            }
        }

        return dp[n][target];
    }

    // Brute Force Approach (Recursive Approach)
    // T(C) = O(2^N)
    // S(C) = O(N), {Recursive Stack}
//    public static int perfectSum(int[] arr, int target) {
//        return solve(arr, arr.length, target);
//    }
//
//    public static int solve(int[] arr, int n, int k) {
//        if (n == 0) {
//            return (k == 0) ? 1 : 0;
//        }
//
//        int pick = 0;
//        if (arr[n - 1] <= k) pick = solve(arr, n - 1, k - arr[n - 1]);
//
//        int notPick = solve(arr, n - 1, k);
//
//        return pick + notPick;
//    }
}
