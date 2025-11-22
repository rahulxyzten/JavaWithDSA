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
        btPermute(nums, 0, nums.length, result);
        return result;
    }

    // time complexity of O(N! * N)
    // space complexity is O(N! * N)
    // T(C) = O(N! * N)
    // total number of node => O(N!)
    // work done by a node => swap operation takes O(1), copying Array to List takes O(N)
    // S(C) = O(N! * N) + O(N) + O(N) = O(N! * N)
    // total number of List in List * each List length + intermediate op list +  recursion stack (depth of the recursion)
    public static void btPermute(int[] nums, int start, int n, List<List<Integer>> result) {
        if (start == n - 1) {
            ArrayList<Integer> op = new ArrayList<>();
            for (int num : nums) op.add(num);
            result.add(op);
        }

        for (int i = start; i < n; i++) {
            swap(start, i, nums);
            btPermute(nums, start + 1, n, result);
            swap(start, i, nums);
        }

        return;
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
//        if (op.size() == nums.length - 1) {
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
