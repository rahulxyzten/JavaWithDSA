package TakeYouforward.StackAndQueue.Leetcode.Hard;
//Problem
/*
239. Sliding Window Maximum

You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.



Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]


Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P1SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    //Optimal Solution
    //T(C) = O(N) + O(N) ==> O(N)
    //S(C) = O(N-K+1) ==> O(K)
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int ri = 0;
        Deque<Integer> q = new ArrayDeque<>();
        //q is storing the index

        for (int i = 0; i < n; i++) {
            if (!q.isEmpty() && q.peek() == i - k) {
                q.poll();
            }
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            q.offer(i);

            if (i >= k - 1) {
                result[ri++] = nums[q.peek()];
            }
        }

        return result;
    }

    //Brute Force Approach
    //T(C) = O(N * k)
    //S(C) = O(N-K+1) ==> O(K)
//    public static int[] maxSlidingWindow(int[] nums, int k) {
//        int[] result = new int[nums.length - k + 1];
//        for (int i = 0; i < (nums.length - k + 1); i++) {
//            int max = nums[i];
//            for (int j = 1; j < k; j++) {
//                if (nums[i + j] > max) max = nums[i + j];
//            }
//            result[i] = max;
//        }
//
//        return result;
//    }
}
