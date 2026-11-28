package AdityaVerma.DynamicProgramming.T1Knapsack.GFG.Medium;
// Problem (Unbounded Knapsack)
/*
Knapsack with Duplicate Items

Given a set of item whose weights and values are represented by wt[] and val[] respectively. Also given a knapsack with a weight limit capacity. The task is to fill the knapsack in such a way that we get the maximum profit.

Note:  Each item can be taken any number of times.

Examples:

Input: val[] = [1, 1], wt[] = [2, 1], capacity = 3
Output: 3
Explanation: The optimal choice is to pick the 2nd element 3 times.
Input: val[] = [10, 40, 50, 70], wt[] = [1, 3, 4, 5], capacity = 8
Output: 110
Explanation: The optimal choice is to pick the 2nd element and the 4th element.
Input: val[] = [6, 8, 7, 100], wt[] = [2, 3, 4, 5], capacity = 1
Output: 0
Explanation: We can't pick any element. Hence, total profit is 0.
Constraints:

1 ≤ capacity, val.size() ≤ 1000
1 ≤ val[i], wt[i] ≤ 100
wt.size() ≤ 1000
wt.size() = val.size()
 */

public class P5KnapsackDuplicateItems {
    public static void main(String[] args) {
        int[] val = {1, 1};
        int[] wt = {2, 1};
        int capacity = 3;
        System.out.println(knapSack(val, wt, capacity));
    }

    // Optimal Approach (Top Down Approach)
    // T(C) = O(n * capacity)
    // S(C) = O(n * capacity)
    public static int knapSack(int val[], int wt[], int capacity) {
        int n = wt.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                int pick = 0;
                if (wt[i - 1] <= j) pick = val[i - 1] + dp[i][j - wt[i - 1]];

                int notPick = dp[i - 1][j];

                dp[i][j] = Math.max(pick, notPick);
            }
        }

        return dp[n][capacity];
    }
}