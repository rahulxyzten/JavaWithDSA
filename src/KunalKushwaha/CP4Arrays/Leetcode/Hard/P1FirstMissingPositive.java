package KunalKushwaha.CP4Arrays.Leetcode.Hard;
//Problem
/*
41. First Missing Positive

Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.



Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.


Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
 */

import java.util.Arrays;

public class P1FirstMissingPositive {
    public static void main(String[] args) {
//        int[] nums = {3, 4, -1, 1};
//        int[] nums = {1,2,3};
//        int[] nums = {1,2,0,1};
        int[] nums = {7, 8, 9, 11, 12};
        System.out.println(firstMissingPositive(nums));
    }

    //Optimal Solution
    //T(C) = O(N) and S(C) = O(1)
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int element = nums[i];
            if (element >= 1 && element <= n) {
                int correctPos = element - 1;
                if (nums[correctPos] != element) {
                    swap(nums, correctPos, i);
                    i--;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }

        return n + 1;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /*Brute Force Approach T(C) = O(nlong + n) & S(C) = O(1) */
//        public static int firstMissingPositive(int[] nums) {
//        Arrays.sort(nums);
//        int smallestPositive = 1;
//        for (int num : nums) {
//            if (num < 0) num *= -1;
//            if (smallestPositive == num) {
//                smallestPositive++;
//            }
//        }
//
//        return smallestPositive;
//    }

}
