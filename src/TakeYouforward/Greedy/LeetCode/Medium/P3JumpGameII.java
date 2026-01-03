package TakeYouforward.Greedy.LeetCode.Medium;
// Problem
/*
45. Jump Game II

You are given a 0-indexed array of integers nums of length n. You are initially positioned at index 0.

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at index i, you can jump to any index (i + j) where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach index n - 1. The test cases are generated such that you can reach index n - 1.

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2


Constraints:

1 <= nums.length <= 10^4
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1].
 */

public class P3JumpGameII {
    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 1, 4};
//        int[] nums = {2, 3, 0, 1, 4};
        int[] nums = {2, 3, 1, 4, 1, 1, 2};
        System.out.println(jump(nums));
    }

    // Optimal Approach (Using Greedy)
    // T(C) = O(N)
    // S(C) = O(1)
    public static int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0, l = 0, r = 0;
        while (r < (n - 1)) {
            int farthest = 0;
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }

            l = r + 1;
            r = farthest;
            jumps = jumps + 1;
        }

        return jumps;
    }

    // Brute Force Approach (Using Recursion)
    // T(C) = O(N^N)
    // S(C) = O(N), {Recursive stack}
//    public static int jump(int[] nums) {
//        return solve(nums, 0, 0);
//    }
//
//    public static int solve(int[] nums, int index, int jumps) {
//        if (index >= (nums.length - 1)) return jumps;
//        if (nums[index] == 0) return Integer.MAX_VALUE;
//
//        int minJumps = Integer.MAX_VALUE;
//        for (int i = 1; i <= nums[index]; i++) {
//            minJumps = Math.min(minJumps, solve(nums, index + i, jumps + 1));
//            // see here index + i, not index + 1
//        }
//
//        return minJumps;
//    }
}
