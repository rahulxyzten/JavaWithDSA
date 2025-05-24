package TakeYouforward.Array.LeetCode.Medium;
//Problem
//Right rotate an array by k places
/*
189. Rotate Array
Medium
15.9K
1.7K
Companies
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.



Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]


Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
 */

import java.util.Arrays;

public class P5RightRotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

//        int[] nums = {-1, -100, 3, 99};
//        int k = 2;
        rotate(nums, k);
    }


    //Optimal Approach
//    public static void rotate(int[] nums, int k) {
//        int n = nums.length;
//        k = k % n;
//        reverse(nums, 0, n - 1);
//        reverse(nums, 0, k - 1);
//        reverse(nums, k, n - 1);
//        System.out.println(Arrays.toString(nums));
//    }
//
//    public static void reverse(int[] nums, int start, int end) {
//        while (start < end) {
//            int temp = nums[start];
//            nums[start] = nums[end];
//            nums[end] = temp;
//            start++;
//            end--;
//        }
//    }

    //Brute and Better Approach
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = nums[n - k + i];
        }
        for (int i = n - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
        System.out.println(Arrays.toString(nums));
    }


    //Problem in below code
    /*
    it is not efficient for large values of 'k' because it has a
    time complexity of O(n*k), where 'n' is the length of the array.
    This code will not pass all test cases efficiently because the constraints
     are quite large, and it could result in a timeout error for large input values.
     */
//    public static void rotate(int[] nums, int k) {
//        int n = nums.length;
//        for (int i = 0; i < k; i++) {
//            int temp = nums[n - 1];
//            for (int j = n - 1; j >= 1; j--) {
//                nums[j] = nums[j-1];
//            }
//            nums[0] = temp;
//        }
//        System.out.println(Arrays.toString(nums));
//    }
}
