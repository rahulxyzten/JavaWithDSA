package AdityaVerma.DynamicProgramming.T1Knapsack.GFG.Medium;
// Problem
/*
Partitions with Given Difference

Given an array arr[] and an integer diff, count the number of ways to partition the array into two subsets such that the difference between their sums is equal to diff.

Note: A partition in the array means dividing an array into two subsets say S1 and S2 such that the union of S1 and S2 is equal to the original array and each element is present in only one of the subsets.

Examples :

Input: arr[] = [5, 2, 6, 4], diff = 3
Output: 1
Explanation: There is only one possible partition of this array. Partition : [6, 4], [5, 2]. The subset difference between subset sum is: (6 + 4) - (5 + 2) = 3.
Input: arr[] = [1, 1, 1, 1], diff = 0
Output: 6
Explanation: We can choose two 1's from indices [0,1], [0,2], [0,3], [1,2], [1,3], [2,3] and put them in sum1 and remaining two 1's in sum2.
Thus there are total 6 ways for partition the array arr.
Input: arr[] = [3, 2, 5, 1], diff = 4
Output: 0
Explanation: There is no possible partition of the array that satisfy the given difference.
Constraints:

1 ≤ arr.size() ≤ 50
0 ≤ arr[i] ≤ 6
0 ≤ diff ≤ 50
 */

public class P4PartitionsGivenDifference {
    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 4};
        int diff = 3;
        System.out.println(countPartitions(arr, diff));
    }


    // Optimal Approach (Top Down Approach)
    // T(C) = O(n * sumS1)
    // S(C) = O(n * sumS1)
    public static int countPartitions(int[] arr, int diff) {
        int sum = 0;
        for (int num : arr) sum += num;
        if (sum < diff || (sum + diff) % 2 != 0) return 0;

        int sumS1 = (diff + sum) / 2;
        return perfectSum(arr, sumS1);
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