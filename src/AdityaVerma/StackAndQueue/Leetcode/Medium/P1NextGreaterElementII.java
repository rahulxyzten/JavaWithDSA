package AdityaVerma.StackAndQueue.Leetcode.Medium;
//Next Greatest Element (Variant 2)
/////////////*Go for TUF Code for teh above Problem which is implemented below*//////////////
//Problem
/*
503. Next Greater Element II
Medium
Topics
Companies
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.



Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2;
The number 2 can't find next greater number.
The second 1's next greater number needs to search circularly, which is also 2.
Example 2:

Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]


Constraints:

1 <= nums.length <= 104
-109 <= nums[i] <= 109
 */

import java.util.Arrays;
import java.util.Stack;

public class P1NextGreaterElementII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }

    //TUF Solution (Best Solution)
    //T(C) = O(2N) + O(2N)
    //S(C) = (N)
    public static int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        int n = nums.length;
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= nums[i % n]) {
                s.pop();
            }
            if (i < n) {
                if (s.size() == 0) result[i] = -1;
                else result[i] = s.peek();
            }

            s.push(nums[i % n]);
        }
        return result;
    }

    //Aditya Verma Solution
    //T(C) = O(2N) + O(2N)
    //S(C) = (N)
//    public static int[] nextGreaterElements(int[] nums) {
//        int[] result = new int[nums.length];
//        Stack<Integer> s = new Stack<>();
//        int n = nums.length;
//        for (int i = 2 * n - 1; i >= 0; i--) {
//            if (s.size() == 0) {
//                if (i < n) result[i] = -1;
//            } else if (s.peek() > nums[i % n]) {
//                if (i < n) result[i] = s.peek();
//            } else if (s.size() > 0 && s.peek() <= nums[i % n]) {
//                while (s.size() > 0 && s.peek() <= nums[i % n]) {
//                    s.pop();
//                }
//                if (s.size() == 0) {
//                    if (i < n) result[i] = -1;
//                }
//                else {
//                    if (i < n) result[i] = s.peek();
//                }
//            }
//            s.push(nums[i % n]);
//        }
//        return result;
//    }
}
