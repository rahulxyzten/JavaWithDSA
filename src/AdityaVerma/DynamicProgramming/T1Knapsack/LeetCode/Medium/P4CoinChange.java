package AdityaVerma.DynamicProgramming.T1Knapsack.LeetCode.Medium;
// Problem
/*
322. Coin Change

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.



Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0


Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 2^31 - 1
0 <= amount <= 10^4
 */

public class P4CoinChange {
    public static void main(String[] args) {
//        int[] coins = {1, 2, 5};
//        int amount = 11;
        int[] coins = {14, 4, 12, 41};
        int amount = 4;
        System.out.println(coinChange(coins, amount));
    }

    // Optimal Approach (Top Down Approach)
    // T(C) = O(amount) + O(amount) + O(n * amount) == O(n * amount)
    // S(C) = O(n * amount)
    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        for (int j = 0; j <= amount; j++) dp[0][j] = Integer.MAX_VALUE - 1;
        for (int j = 1; j <= amount; j++) {
            if (j % coins[0] == 0) dp[1][j] = j / coins[0];
            else dp[1][j] = Integer.MAX_VALUE - 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                // see the int pick = Integer.MAX_VALUE - 1; not pick = 0;
                int pick = Integer.MAX_VALUE - 1;
                if (coins[i - 1] <= j) pick = 1 + dp[i][j - coins[i - 1]];

                int notPick = dp[i - 1][j];

                dp[i][j] = Math.min(pick, notPick);
            }
        }

        return (dp[n][amount] == Integer.MAX_VALUE - 1) ? -1 : dp[n][amount];
    }
}
