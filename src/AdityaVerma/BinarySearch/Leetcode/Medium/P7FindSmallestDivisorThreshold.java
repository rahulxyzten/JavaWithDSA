package AdityaVerma.BinarySearch.Leetcode.Medium;
//problem
/*
1283. Find the Smallest Divisor Given a Threshold

Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.

Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).

The test cases are generated so that there will be an answer.

Example 1:

Input: nums = [1,2,5,9], threshold = 6
Output: 5
Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1.
If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2).
Example 2:

Input: nums = [44,22,33,11,1], threshold = 5
Output: 44


Constraints:

1 <= nums.length <= 5 * 104
1 <= nums[i] <= 106
nums.length <= threshold <= 106
 */

public class P7FindSmallestDivisorThreshold {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 5, 9};
//        int threshold = 6;
//        int[] nums = {44, 22, 33, 11, 1};
//        int threshold = 5;
        int[] nums = {8, 4, 2, 3};
        int threshold = 10;
        System.out.println(smallestDivisor(nums, threshold));
    }

    //T(C) = O( log( max(arr[]) ) * N )
    //S(C) = O(1)
    public static int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        if (n > threshold) return -1;
        int start = 1, end = Integer.MIN_VALUE;
        for (int num : nums) {
            end = Math.max(end, num);
        }
        int result = end;
        // nums.length <= threshold <= 10^6

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (sumByMid(nums, mid) <= threshold) {
                result = mid;
                end = mid - 1;
            } else start = mid + 1;
        }

        return result;
    }

    public static int sumByMid(int[] nums, int mid) {
        int sum = 0;
        for (int num : nums) {
            sum += Math.ceil((double) num / (double) mid);
        }

        return sum;
    }

    //T(C) & S(C)
    /*
    Time Complexity: O(N * log(max(a[]))), where max(a[]) is the maximum element in the array and N = size of the array.
    Reason: We are applying Binary search for the range [1, max(a[])],
    for [0->n-1] = total element (ex 0-4 = 5 elements)  => O(logn)
    for [1->max(a[])] = total element (ex 1-5 = 5 elements) => O(log(max(a[])))
    and for every value of ‘mid’, we are traversing the entire array inside the function named calculateTotalHours() or isValid().

    Space Complexity: O(1) as we are not using any extra space to solve this problem.
    */
}
