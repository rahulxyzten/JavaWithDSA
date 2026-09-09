package TakeYouforward.Array.LeetCode.Medium;

/*
560. Subarray Sum Equals K

Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.



Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2


Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
 */

import java.util.*;

public class P10SubArraySumEqualsK {
    public static void main(String[] args) {
//        int[] nums = {1, 1, 1};
//        int k = 2;
        int[] nums = {1, 2, 3, -3, 1, 1, 1, 4, 2, -3};
        int k = 3;
        System.out.println(subarraySum(nums, k));
    }

    // Optimal Solution
    // T(C) = O(N)
    // S(C) = O(N)
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        long preSum = 0L;
        HashMap<Long, Integer> mpp = new HashMap<>();
        mpp.put(0L, 1);
        int count = 0;

        for (int num : nums) {
            preSum += num;
            long rem = preSum - k;
            count += mpp.getOrDefault(rem, 0);
            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }

        return count;
    }
}
