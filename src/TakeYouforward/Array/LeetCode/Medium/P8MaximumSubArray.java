package TakeYouforward.Array.LeetCode.Medium;
// Question
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


public class P8MaximumSubArray {
    public static void main(String[] args) {
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = {-2, -1, -3, -4, -1, -2, -1, -5, -4};
        int[] nums = {5, 4, 2, 6, 3, 8, 9, 7, 4, 7, 3, 6, 9, 8, 2, 4, 6, 8, 6, 2, 3, 4, 5, 1, 4, 2};
        System.out.println(maxSubArray(nums));
    }

    // Kadane's algorithm
    /* Optimal Solution (O(N)time complexity and O(1)space complexity) */
    public static int maxSubArray(int[] nums) {
        int sum = 0, maxi = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            maxi = Math.max(sum, maxi);
            if (sum < 0)
                sum = 0;
        }

        return maxi;
    }

//    public static long maxSubArray(int[] nums) {
//        int n = nums.length;
//        long maxi = Long.MIN_VALUE;
//        long sum = 0;
//        for (int i = 0; i < n; i++) {
//            sum += nums[i];
//            maxi = Math.max(sum, maxi);
//            if (sum < 0) sum = 0;
//        }
//
//        /* To consider the sum of the empty sub array (If mention in the question) */
//        // If maxi is still Long.MIN_VALUE,
//        // it means all elements in the array are negative and maxi is negative
//        // In this case, return 0 to indicate an empty subarray.
//
//        // uncomment the following check:
//        // if (maxi < 0) maxi = 0;
//
//        return maxi;
//    }
}
