package AdityaVerma.DynamicProgramming.GFG.Hard;
// Problem
/*
Partition Into 2 Subsets with Min Sum Diff

Given an array arr[]  containing non-negative integers, divide it into two sets set1 and set2 such that the absolute difference between their sums is minimum and find the minimum difference.

Examples:

Input: arr[] = [1, 6, 11, 5]
Output: 1
Explanation:
Subset1 = [1, 5, 6], sum of Subset1 = 12
Subset2 = [11], sum of Subset2 = 11
Hence, minimum difference is 1.
Input: arr[] = [1, 4]
Output: 3
Explanation:
Subset1 = [1], sum of Subset1 = 1
Subset2 = [4], sum of Subset2 = 4
Hence, minimum difference is 3.
Input: arr[] = [1]
Output: 1
Explanation:
Subset1 = [1], sum of Subset1 = 1
Subset2 = [], sum of Subset2 = 0
Hence, minimum difference is 1.
Constraints:
1 ≤ arr.size()*|sum of array elements| ≤ 10^5
1 ≤ arr[i] ≤ 10^5
 */

import java.util.ArrayList;
import java.util.List;

public class P1PartitionSubsetsMinSumDiff {
    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 5};
        System.out.println(minDifference(arr));
    }

    // Optimal Approach (Top Down Approach)
    // T(C) = O(n) + O(n * range) + O(range/2) == O(n * range)
    // S(C) = O(n * range)
    public static int minDifference(int arr[]) {
        int n = arr.length;
        int range = 0;
        for (int num : arr) range += num;
        boolean[][] dp = new boolean[n + 1][range + 1];
        isSubsetSum(arr, n, range, dp);

        int minDiff = Integer.MAX_VALUE;
        for (int j = 0; j <= range / 2; j++) {
            if (dp[n][j]) {
                minDiff = Math.min(minDiff, Math.abs(range - 2 * j));
            }
        }

        return minDiff;
    }

    public static void isSubsetSum(int arr[], int n, int sum, boolean[][] dp) {
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
    }
}