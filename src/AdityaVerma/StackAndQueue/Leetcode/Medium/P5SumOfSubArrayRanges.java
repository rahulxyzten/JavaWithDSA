package AdityaVerma.StackAndQueue.Leetcode.Medium;
//Problem
/*
2104. Sum of Subarray Ranges
Medium
Topics
Companies
Hint
You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest element in the subarray.

Return the sum of all subarray ranges of nums.

A subarray is a contiguous non-empty sequence of elements within an array.



Example 1:

Input: nums = [1,2,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0
[2], range = 2 - 2 = 0
[3], range = 3 - 3 = 0
[1,2], range = 2 - 1 = 1
[2,3], range = 3 - 2 = 1
[1,2,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.
Example 2:

Input: nums = [1,3,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0
[3], range = 3 - 3 = 0
[3], range = 3 - 3 = 0
[1,3], range = 3 - 1 = 2
[3,3], range = 3 - 3 = 0
[1,3,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 2 + 0 + 2 = 4.
Example 3:

Input: nums = [4,-2,-3,4,1]
Output: 59
Explanation: The sum of all subarray ranges of nums is 59.


Constraints:

1 <= nums.length <= 1000
-109 <= nums[i] <= 109


Follow-up: Could you find a solution with O(n) time complexity?
 */

import java.util.Stack;

public class P5SumOfSubArrayRanges {
    public static void main(String[] args) {
        int[] nums = {1, 3, 3};
        System.out.println(subArrayRanges(nums));
    }

    //Optimal Approach
    //T(C) = O(N) + O(N) + O(N) + O(N) + O(N) + O(N) => O(N)
    //S(C) = O(N) + O(N) + O(N) + O(N) + O(N) + O(N) => O(N)
    public static long subArrayRanges(int[] nums) {
        long min = sumSubarrayMins(nums);
        long max = sumSubarrayMax(nums);
        return max - min;
    }

    public static long sumSubarrayMax(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> s = new Stack<>();

        //Nearest Greater to Left
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] < arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) left[i] = i;
            else left[i] = i - s.peek() - 1;
            s.push(i);
        }

        while (!s.isEmpty()) s.pop();

        //Nearest Greater to Right
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) right[i] = n - i - 1;
            else right[i] = s.peek() - i - 1;
            s.push(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += ((long) arr[i] * (left[i] + 1) * (right[i] + 1));
        }

        return sum;
    }

    public static long sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> s = new Stack<>();

        //Nearest Smaller to Left
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] > arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) left[i] = i;
            else left[i] = i - s.peek() - 1;
            s.push(i);
        }

        while (!s.isEmpty()) s.pop();

        //Nearest Smaller to Right
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) right[i] = n - i - 1;
            else right[i] = s.peek() - i - 1;
            s.push(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += ((long) arr[i] * (left[i] + 1) * (right[i] + 1));
        }

        return sum;
    }

}
