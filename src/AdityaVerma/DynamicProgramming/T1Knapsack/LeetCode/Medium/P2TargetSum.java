package AdityaVerma.DynamicProgramming.T1Knapsack.LeetCode.Medium;
// problem
/*
494. Target Sum

You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.



Example 1:

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
Example 2:

Input: nums = [1], target = 1
Output: 1


Constraints:

1 <= nums.length <= 20
0 <= nums[i] <= 1000
0 <= sum(nums[i]) <= 1000
-1000 <= target <= 1000
 */

public class P2TargetSum {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println();
    }

    // Optimal Approach (Top Down Approach)
    // T(C) = O(n * sumS1)
    // S(C) = O(n * sumS1)
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum < target || target < -sum || (sum + target) % 2 != 0) return 0;
        // Because our valid target range is -sum <= target <= sum

        int sumS1 = (target + sum) / 2;
        return perfectSum(nums, sumS1);
    }

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
}