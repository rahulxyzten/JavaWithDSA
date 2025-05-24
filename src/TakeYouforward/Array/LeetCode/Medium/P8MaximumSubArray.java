package TakeYouforward.Array.LeetCode.Medium;
//Question
//Kadane's Algorithm, maximum sub array
/*
53. Maximum Subarray

Given an integer array nums, find the subarray
 with the largest sum, and return its sum.

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.


Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 10 */

// Kadane's algorithm
/*
Now let's go through the code's execution step by step for Example 1:

Initialize maxSum with -2 (first element) and currentSum with -2.
Loop iteration 1 (i = 1):
currentSum becomes the maximum between 1 and -2 + 1 = 1.
maxSum becomes the maximum between -2 and 1, so it remains 1.
Loop iteration 2 (i = 2):
currentSum becomes the maximum between -3 and 1 + (-3) = -2.
maxSum remains 1.
Loop iteration 3 (i = 3):
currentSum becomes the maximum between 4 and -2 + 4 = 4.
maxSum becomes the maximum between 1 and 4, so it becomes 4.
Loop iteration 4 (i = 4):
currentSum becomes the maximum between -1 and 4 + (-1) = 3.
maxSum remains 4.
Loop iteration 5 (i = 5):
currentSum becomes the maximum between 2 and 3 + 2 = 5.
maxSum becomes the maximum between 4 and 5, so it becomes 5.
Loop iteration 6 (i = 6):
currentSum becomes the maximum between 1 and 5 + 1 = 6.
maxSum becomes the maximum between 5 and 6, so it becomes 6.
Loop iteration 7 (i = 7):
currentSum becomes the maximum between -5 and 6 + (-5) = 1.
maxSum remains 6.
Loop iteration 8 (i = 8):
currentSum becomes the maximum between 4 and 1 + 4 = 5.
maxSum remains 6.
After the loop completes, the value of maxSum is 6, which is the maximum subarray sum for the given input array [4,-1,2,1]
 */

public class P8MaximumSubArray {
    public static void main(String[] args) {
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = {-2, -1, -3, -4, -1, -2, -1, -5, -4};
        int[] nums = {5,4,2,6,3,8,9,7,4,7,3,6,9,8,2,4,6,8,6,2,3,4,5,1,4,2};
        System.out.println(maxSubArray(nums));
    }

    /* Optimal Solution (O(N)time complexity and O(1)space complexity) */
    public static long maxSubArray(int[] nums) {
        int n = nums.length;
        long maxi = Long.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            maxi = Math.max(sum, maxi);
            if (sum < 0) sum = 0;
        }

        /* To consider the sum of the empty sub array */
        // If maxi is still Long.MIN_VALUE,
        // it means all elements in the array are negative and maxi is negative
        // In this case, return 0 to indicate an empty subarray.

        // uncomment the following check:
        if (maxi < 0) maxi = 0;

        return maxi;
    }


}
