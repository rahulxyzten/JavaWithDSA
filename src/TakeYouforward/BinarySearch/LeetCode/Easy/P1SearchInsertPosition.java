package TakeYouforward.BinarySearch.LeetCode.Easy;
//Question
/*
35. Search Insert Position

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4


Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
 */

//code same as lower bound of the array for the given target

public class P1SearchInsertPosition {
    public static void main(String[] args) {
//        int[] nums = {1, 3, 5, 6};
////        int target = 2;
//        int target = 5;

        int[] nums = {1};
        int target = 1;
        System.out.println(searchInsert(nums, target));

    }

    // T(C) = O(logn)
    // S(C) = O(1)
    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int start = 0, end = n - 1;
        int result = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }


//Problem in below code
/*
nums = [1]
target = 1
Output 1
Expected 0
 */

//    public static int searchInsert(int[] nums, int target) {
//        int n = nums.length;
//        if (nums[0] > target) return 0;
//        if (nums[n - 1] < target) return n;
//        int start = 1, end = n - 2;
//        int result = n;
//        while (start <= end) {
//            int mid = start + (end - start) / 2;
//            if (nums[mid] >= target) {
//                result = mid;
//                end = mid - 1;
//            } else {
//                start = mid + 1;
//            }
//        }
//        return result;
//    }

}
