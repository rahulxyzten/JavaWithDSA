package TakeYouforward.Greedy.LeetCode.Medium;
// Problem
/*
55. Jump Game

You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.



Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.


Constraints:

1 <= nums.length <= 10^4
0 <= nums[i] <= 10^5
 */

public class P2JumpGame {
    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
    }

    // Greedy Approach
    // T(C) = O(N)
    // S(C) = O(1)
    public static boolean canJump(int[] nums) {
        int maxIndexCover = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxIndexCover) return false;
            maxIndexCover = Math.max(maxIndexCover, i + nums[i]);
            if (maxIndexCover >= nums.length - 1) return true;
        }

        return true;
    }

    // Not Good
    /*
    Wrong Answer
    169 / 175 testcases passed
    submitted at Jan 02, 2026 20:35

    Editorial
    Input
    nums = [1,1,2,2,0,1,1]

    Output
    false
    Expected
    true
    */
//    public static boolean canJump(int[] nums) {
//        for (int i = 0; i < nums.length - 1; i++) {
//            if ((i + nums[i]) >= (nums.length - 1)) return true;
//            int maxPoss = 0;
//            int nextI = i;
//            for (int j = i + 1; j <= (i + nums[i]); j++) {
//                int temp = j + nums[j];
//                if (temp >= nums.length - 1) return true;
//                if ((nums[temp] != 0) && nums[j] > maxPoss) {
//                    maxPoss = nums[j];
//                    nextI = j;
//                }
//            }
//
//            if (nextI == i) return false;
//            i = nextI - 1;
//        }
//
//        return true;
//    }
}