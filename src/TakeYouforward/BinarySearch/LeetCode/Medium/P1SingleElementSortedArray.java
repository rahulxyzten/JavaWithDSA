package TakeYouforward.BinarySearch.LeetCode.Medium;
//Question
/*
540. Single Element in a Sorted Array

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10


Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 105
 */

public class P1SingleElementSortedArray {
    public static void main(String[] args) {
//        int[] nums = {1,1,2,3,3,4,4,8,8};
        int[] nums = {3, 3, 7, 7, 10, 11, 11};
        System.out.println(singleNonDuplicate(nums));

    }

    //Optimal Solution
    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];
        int start = 1, end = n - 2;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) return nums[mid];
            else if ((mid % 2 == 1 && nums[mid] == nums[mid - 1]) || (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
//    Time Complexity: O(logN), N = size of the given array.
//            Reason: We are basically using the Binary Search algorithm.
//
//    Space Complexity: O(1) as we are not using any extra space.


    //Brute force solution
//    public static int singleNonDuplicate(int[] arr) {
//        int n = arr.length; // Size of the array.
//        if (n == 1)
//            return arr[0];
//
//        for (int i = 0; i < n; i++) {
//            // Check for first index:
//            if (i == 0) {
//                if (arr[i] != arr[i+1])
//                    return arr[i];
//            }
//            // Check for last index:
//            else if (i == n - 1) {
//                if (arr[i] != arr[i-1])
//                    return arr[i];
//            } else {
//                if (arr[i] != arr[i-1] && arr[i] != arr[i+1])
//                    return arr[i];
//            }
//        }
//
//        // Dummy return statement:
//        return -1;
//    }
//    Time Complexity: O(N), N = size of the given array.
//            Reason: We are traversing the entire array.
//
//    Space Complexity: O(1) as we are not using any extra space.

}
