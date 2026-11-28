package AdityaVerma.DynamicProgramming.T1Knapsack.GFG.Medium;
// Problem
/*
Subset Sum Problem

Given an array of positive integers arr[] and a value sum, find if there is a subset of arr[] with sum equal to given sum.

Examples:

Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 9
Output: true
Explanation: Here there exists a subset with target sum = 9, 4+3+2 = 9.
Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 30
Output: false
Explanation: There is no subset with target sum 30.
Input: arr[] = [1, 2, 3], sum = 6
Output: true
Explanation: The entire array can be taken as a subset, giving 1 + 2 + 3 = 6.
Constraints:

1 ≤ arr.size(), arr[i] ≤ 200
1 ≤ sum ≤ 10^4
 */

public class P2SubsetSum {
    public static void main(String[] args) {
//        int[] arr = {3, 34, 4, 12, 5, 2};
//        int sum = 9;
        int[] arr = {2, 3, 7, 8, 10};
        int sum = 11;
        System.out.println(isSubsetSum(arr, sum));
    }


    // Optimal Approach (Top Down Approach)
    // T(C) = O(n) + O(n * sum) == O(n * sum)
    // S(C) = O(n * sum)
    public static boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;

        boolean[][] dp = new boolean[n + 1][sum + 1];
//        for (int i = 0; i <= n; i++) {
//            for (int j = 0; j <= sum; j++) {
//                if (i == 0) dp[i][j] = false;
//                if (j == 0) dp[i][j] = true;
//            }
//        }

        // Because the default value of element in boolean array is false
        for (int i = 0; i <= n; i++) dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                boolean pick = false;
                if (arr[i - 1] <= j) {
                    pick = dp[i - 1][j - arr[i - 1]];
                }

                boolean notPick = dp[i - 1][j];

                dp[i][j] = pick || notPick;
            }
        }

        return dp[n][sum];
    }
}
