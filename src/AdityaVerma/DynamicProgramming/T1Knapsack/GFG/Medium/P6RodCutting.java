package AdityaVerma.DynamicProgramming.T1Knapsack.GFG.Medium;
// Problem
/*
Given a rod of length n inches and an array price[], where price[i] denotes the value of a piece of length i (1-based Index). Determine the maximum value obtainable by cutting up the rod and selling the pieces.

Note: The value of n is equal to the size of price array.

Example:

Input: price[] = [1, 5, 8, 9, 10, 17, 17, 20]
Output: 22
Explanation: The maximum obtainable value is 22 by cutting in two pieces of lengths 2 and 6, i.e., 5 + 17 = 22.
Input: price[] = [3, 5, 8, 9, 10, 17, 17, 20]
Output: 24
Explanation: The maximum obtainable value is 24 by cutting the rod into 8 pieces of length 1, i.e, 8*price[1] = 8*3 = 24.
Input: price[] = [3]
Output: 3
Explanation: There is only 1 way to pick a piece of length 1.
Constraints:

1 ≤ price.size() ≤ 10^3
1 ≤ price[i] ≤ 10^6
 */

public class P6RodCutting {
    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRod(price));
    }

    // Optimal Approach (Top Down Approach)
    // T(C) = O(n) + O(n * N) == O(n * N)
    // S(C) = O(n * N)
    public static int cutRod(int[] price) {
        int n = price.length;
        int N = n;
        int[] length = new int[n];
        for (int i = 0; i < n; i++) length[i] = i + 1;

        int[][] dp = new int[n + 1][N + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= N; j++) {
                int pick = 0;
                if (length[i - 1] <= j) pick = price[i - 1] + dp[i][j - length[i - 1]];

                int notPick = dp[i - 1][j];

                dp[i][j] = Math.max(pick, notPick);
            }
        }

        return dp[n][N];
    }
}