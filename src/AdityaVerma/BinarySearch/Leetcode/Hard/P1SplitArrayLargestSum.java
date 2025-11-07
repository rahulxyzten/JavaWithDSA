package AdityaVerma.BinarySearch.Leetcode.Hard;

//Problem
/*
410. Split Array Largest Sum

Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

Return the minimized largest sum of the split.

A subarray is a contiguous part of the array.

Example 1:
Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
Example 2:

Input: nums = [1,2,3,4,5], k = 2
Output: 9
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.


Constraints:

1 <= nums.length <= 1000
0 <= nums[i] <= 106
1 <= k <= min(50, nums.length)
 */
//problem is same as "allocate minimum number of pages"

public class P1SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;
        System.out.println(splitArray(nums, k));
    }

    public static int splitArray(int[] nums, int k) {
        int n = nums.length;
        if (k > n) return -1;
        int start = Integer.MIN_VALUE, end = 0;
        for (int num : nums) {
            start = Math.max(start, num);
            end += num;
        }
        int result = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(nums, n, k, mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    public static boolean isValid(int[] nums, int n, int k, int maxEle) {
        int countSubarray = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum > maxEle) {
                countSubarray++;
                sum = nums[i];
            }
            if (countSubarray > k) return false;
        }

        return true;
    }

    //T(C) & S(C)
    /*
    Time Complexity: O(N * log(sum(arr[])-max(arr[])+1))
    where N = size of the array,
    sum(arr[]) = sum of all array elements,
    max(arr[]) = maximum of all array elements.
    Why + 1? start = 40 and end = 100, here the total element 60 to 100 which is 61 element(include 60 also)
    is log(n) = log(61) = log(100-40) + 1
    Reason: We are applying binary search on [max(arr[]), sum(arr[])]. Inside the loop, we are calling the isValid() function
    for the value of ‘mid’. Now, inside the isValid() function, we are using a loop that runs for N times.

    Space Complexity: O(1) as we are not using any extra space to solve this problem.
     */


    /* T(C) = 2ms & S(C) = 40.4mb  */
//    public static int splitArray(int[] nums, int k) {
//        int n = nums.length;
//        if (k > n) return -1;
//        int start = Arrays.stream(nums).max().getAsInt();
//        int end = Arrays.stream(nums).sum();
//        int result = -1;
//        while (start <= end) {
//            int mid = start + (end - start) / 2;
//            if (isValid(nums, n, k, mid)) {
//                result = mid;
//                end = mid - 1;
//            } else {
//                start = mid + 1;
//            }
//        }
//        return result;
//    }
//
//    public static boolean isValid(int[] arr, int n, int k, int max) {
//        int student = 1;
//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            sum = sum + arr[i];
//            if (sum > max) {
//                student++;
//                sum = arr[i];
//            }
//            if (student > k) {
//                return false;
//            }
//        }
//        return true;
//    }
}
