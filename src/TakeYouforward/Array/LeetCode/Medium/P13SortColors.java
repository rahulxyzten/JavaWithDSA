package TakeYouforward.Array.LeetCode.Medium;
//Problem
/*
75. Sort Colors

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.



Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]


Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.


Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */

import java.util.Arrays;

public class P13SortColors {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
//        int[] nums = {2, 0, 1};
        sortColors(nums);
    }

    // Optimal Solution (Dutch National Flag Algorithm)
    // T(C) = O(N) & S(C) = O(1)
    public static void sortColors(int[] nums) {
        int n = nums.length;
        int start = 0, mid = 0, end = n - 1;

        while (mid <= end) {
            if (nums[mid] == 0) {
                swap(nums, start, mid);
                start++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, end);
                end--;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    // Better Approach T(C) = O(2N) & S(C) = O(1)
//    public static void sortColors(int[] nums) {
//        int n = nums.length;
//        int zeros = 0, ones = 0;
//
//        for (int num : nums) {
//            if (num == 0) zeros++;
//            else if (num == 1) ones++;
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (zeros != 0) {
//                nums[i] = 0;
//                zeros--;
//            } else if (ones != 0) {
//                nums[i] = 1;
//                ones--;
//            } else nums[i] = 2;
//        }
//
//        System.out.println(Arrays.toString(nums));
//    }

    // Brute Force Approach (Simply Sorting)
    // T(C) = O(N*logN) & S(C) = O(1)
}
