package AdityaVerma.StackAndQueue.Leetcode.Medium;
//Problem (Fraz Solution)
/*
907. Sum of Subarray Minimums

Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.



Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation:
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
Example 2:

Input: arr = [11,81,94,43,3]
Output: 444


Constraints:

1 <= arr.length <= 3 * 104
1 <= arr[i] <= 3 * 104
 */

import java.util.Stack;

public class P4SumOfSubArrayMinimums {
    public static void main(String[] args) {
//        int[] arr = {3, 1, 2, 4};
//        int[] arr = {11, 81, 94, 43, 3};
//        int[] arr = {71, 55, 82, 55};
        int[] arr = {117, 1315, 1336, 4213, 5634, 6288, 7640, 8533, 9688, 10186, 10593, 11896, 13673, 14707, 15484, 17429, 19639, 20416, 21375, 23601, 25800, 26485, 27893, 28026, 28695, 29121, 28642, 28023, 27642, 26324, 23844, 22069, 21124, 20181, 18957, 15736, 15364, 13749, 13612, 11062, 10319, 9755, 9367, 7977, 6463, 6049, 4886, 3071, 1331, 865};
        System.out.println(sumSubarrayMins(arr));
    }

    //Optimal Approach
    //T(C) = O(N) + O(N) + O(N) => O(N)
    //S(C) = O(N) + O(N) + O(N) => O(N)
    public static int sumSubarrayMins(int[] arr) {
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
        long mod = (long) Math.pow(10, 9) + 7;
        for (int i = 0; i < n; i++) {
            sum += ((long) arr[i] * (left[i] + 1) * (right[i] + 1));
            sum %= mod;
        }

        return (int) sum;
    }


    //Brute Force Approach
    //T(C) = O(N^3)
    //S(C) = O(1)
//    public static int sumSubarrayMins(int[] arr) {
//        int sum = 0;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i; j < arr.length; j++) {
//                int min = Integer.MAX_VALUE;
//                for (int k = i; k <= j; k++) {
//                    if (arr[k] < min) min = arr[k];
//                }
//                sum += min;
//            }
//        }
//        return sum;
//    }
}
