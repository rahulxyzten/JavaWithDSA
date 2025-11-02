package AdityaVerma.BinarySearch.Leetcode.Medium;
//Question
/*
34. Find First and Last Position of Element in Sorted Array

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]


Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
 */

import java.util.Arrays;

public class P3FirstLastPositionSortedArray {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    /* Kunal Kushwaha Code ( THE BEST code and length is also small) */
    // T(C) = O(2logn)
    // S(C) = O(1)
    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        ans[0] = search(nums, target, true);
        if (ans[0] != -1) {
            ans[1] = search(nums, target, false);
        }
        return ans;
    }

    public static int search(int[] arr, int target, boolean findStartIndex) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                result = mid;
                if (findStartIndex) end = mid - 1;
                else start = mid + 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }

    /* Aditya Verma Code (BEST code but length is big) */
//    public static int[] searchRange(int[] nums, int target) {
//        int[] result = new int[2];
//        result[0] = firstOccurrence(nums,target);
//        result[1] = lastOccurrence(nums,target);
//        return result;
//    }
//    public static int firstOccurrence(int[] arr, int target){
//        int start = 0;
//        int end = arr.length - 1;
//        int result = -1;
//        while (start<= end){
//            int mid = start + (end - start)/2;
//            if (arr[mid] == target){
//                result = mid;
//                end = mid - 1;
//            } else if (target > arr[mid]) {
//                start = mid + 1;
//            }else {
//                end = mid - 1;
//            }
//            //In above in all there condition only one is executed (In multiple elif only one if or elif or else is executed)
//        }
//
//        return result;
//    }
//    public static int lastOccurrence(int[] arr, int target){
//        int start = 0;
//        int end = arr.length - 1;
//        int result = -1;
//        while (start<= end){
//            int mid = start + (end - start)/2;
//            if (arr[mid] == target){
//                result = mid;
//                start = mid + 1;
//            } else if (target > arr[mid]) {
//                start = mid + 1;
//            }else {
//                end = mid - 1;
//            }
//        }
//        return result;
//    }
}
