package TakeYouforward.Array.LeetCode.Easy;
//Problem
/*
283. Move Zeroes

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.



Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]


Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1


Follow up: Could you minimize the total number of operations done?
 */

import java.util.ArrayList;
import java.util.Arrays;

public class P4MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
//        int[] nums = {0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }


    //Optimal Solution (Two Pointer Approach)
    //T(C) = O(N) & S(C) = O(1)
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int j = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        if (j == -1) return;

        for (int i = j + 1; i < n; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                nums[i] = 0;
                j++;
            }
        }
    }


    //My solution (Brute Force Approach)
    //T(C) = O(2N) & S(C) = O(N)
//    public static void moveZeroes(int[] nums) {
//        int n = nums.length;
//        ArrayList<Integer> list = new ArrayList<>();
//
//        for (int num : nums) {
//            if (num != 0) {
//                list.add(num);
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (i < list.size())
//                nums[i] = list.get(i);
//            else
//                nums[i] = 0;
//        }
//
//        System.out.println(Arrays.toString(nums));
//    }
}
