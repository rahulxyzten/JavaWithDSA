package AdityaVerma.DynamicProgramming.T1Knapsack.LeetCode.Medium;
// Problem
/*
518. Coin Change II

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The final answer is guaranteed to fit into a signed 32-bit integer.



Example 1:

Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10]
Output: 1


Constraints:

1 <= coins.length <= 300
1 <= coins[i] <= 5000
All the values of coins are unique.
0 <= amount <= 5000
 */

public class P3CoinChangeII {
    public static void main(String[] args) {
        int[] conins = {1, 2, 5};
        int amount = 5;
        System.out.println(change(amount, conins));
    }

    // Optimal Approach (Top Down Approach)
    // T(C) = O(n) + O(n * amount) == O(n * amount)
    // S(C) = O(n * amount)
    public static int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++) dp[i][0] = 1;

        // if array contains 0
        // dp[0][0] = 1; // only this line in initialization and below j start from 0


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                int pick = 0;
                if (coins[i - 1] <= j) pick = dp[i][j - coins[i - 1]];

                int notPick = dp[i - 1][j];

                dp[i][j] = pick + notPick;
            }
        }

        return dp[n][amount];
    }
}