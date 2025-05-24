package TakeYouforward.BinarySearch.LeetCode.Medium;
//Problem
/*
154. Find Minimum in Rotated Sorted Array II
Hard
4.3K
449
Companies
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,4,4,5,6,7] might become:

[4,5,6,7,0,1,4] if it was rotated 4 times.
[0,1,4,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.

You must decrease the overall operation steps as much as possible.



Example 1:

Input: nums = [1,3,5]
Output: 1
Example 2:

Input: nums = [2,2,2,0,1]
Output: 0


Constraints:

n == nums.length
1 <= n <= 5000
-5000 <= nums[i] <= 5000
nums is sorted and rotated between 1 and n times.


Follow up: This problem is similar to Find Minimum in Rotated Sorted Array, but nums may contain duplicates. Would this affect the runtime complexity? How and why?


 */

//Youtube solution

public class P4MinimumInRotatedSortedArray2 {
    public static void main(String[] args) {
//        int[] nums = {4,5,1,2,3};
//        int[] nums = {2, 2, 2, 0, 1};
        int[] nums = {3,3,3,1};
//        int[] nums = {3, 3, 3, 3, 3, 3, 4, 1, 2, 3};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < nums[end]) {
                // The right half is sorted, minimum is in the left half
                end = mid;
                //here u can't write end = mid - 1 because int[] nums = {4,5,1,2,3}; here mid = 1 and
                //the right part is sorted, so it eliminate the right side with the minimum element 1
                //after eliminating
            } else if (nums[mid] > nums[end]) {
                // The left half is sorted, minimum is in the right half
                start = mid + 1;
            } else {
                // Handle duplicates, decrement end since we know nums[mid] == nums[end]
                end--;
            }
        }
        return nums[start];
    }
}
