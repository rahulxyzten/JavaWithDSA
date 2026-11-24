package AdityaVerma.DynamicProgramming.LeetCode.Medium;
// Problem
/*
416. Partition Equal Subset Sum

Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.



Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.


Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100
 */

public class P1PartitionEqualSubsetSum {
    public static void main(String[] args) {

    }


    // Optimal Approach (Top Down Approach)
    // T(C) = O(n) + O(n * half) == O(n * half)
    // S(C) = O(n * half)
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % 2 != 0) return false;
        else {
            int half = sum / 2;
            return isSubsetSum(nums, half);
        }
    }

    public static boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;

        boolean[][] dp = new boolean[n + 1][sum + 1];
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
