package AdityaVerma.Backtracking.Leetcode.Medium;
//Problem
/*
46. Permutations

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]


Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
 */

import java.util.ArrayList;
import java.util.List;

public class P1Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
//        int[] nums = {0,1};
        System.out.println(permute(nums));
    }


    /* Backtracking */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        btPermute(0, nums, result);
        return result;
    }

//    time complexity of O(N * N!)
//    space complexity is O(N * N!)
    public static void btPermute(int index, int[] nums, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> op = new ArrayList<>();
            for (int num : nums) {
                op.add(num);
            }
            result.add(new ArrayList<>(op));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            btPermute(index + 1, nums, result);
            swap(i, index, nums);
        }
    }

    public static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /* Recursion */
//    public static List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        boolean[] check = new boolean[nums.length];
//        btPermute(nums, new ArrayList<>(), result, check);
//        return result;
//    }
//
//    //time complexity of O(N * N!)
//    //space complexity is O(N * N!)
//    //Although the space complexity is same but here it take a extra space of check array
//    public static void btPermute(int[] nums, List<Integer> op, List<List<Integer>> result, boolean[] check) {
//        if (op.size() == nums.length) {
//            result.add(new ArrayList<>(op));
//            return;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (!check[i]) {
//                check[i] = true;
//                op.add(nums[i]);
//                btPermute(nums, op, result, check);
//                op.remove(op.size() - 1);
//                check[i] = false;
//            }
//        }
//        return;
//    }

}
