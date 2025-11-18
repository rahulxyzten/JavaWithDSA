package AdityaVerma.Recursion.Leetcode.Medium;
//problem
/*
90. Subsets II

Given an integer array nums that may contain duplicates, return all possible
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]


Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
 */
//You can't use the code of find unique subset of string because
// in case of String because in case of string 41 and 14 are not same
//but in case of array [4,4,1] and [4,1,4] are same

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class P4SubsetsII {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 2};
        int[] nums = {4, 4, 4, 1, 4};
        System.out.println(subsetsWithDup(nums));
    }

    //Optimal Solution
    //TUF Explanation
    // T(C) = O(NlogN) + O(2^N * N) = O(2^N * N)
    // S(C) = O(N) {recursion stack} + O(N) {op} + O(2^N * N) {result}
    //      = O(2^N * N)
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        solve(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public static void solve(int[] nums, int ind, List<Integer> op, List<List<Integer>> result) {
        result.add(new ArrayList<>(op));

        for (int i = ind; i < nums.length; i++) {
            if (i != ind && nums[i] == nums[i - 1]) continue;
            op.add(nums[i]);
            solve(nums, i + 1, op, result);
            op.remove(op.size() - 1);
        }
    }


    // Brute Force Approach
    // T(C) = O(NlogN) + O(2^N * N) = O(2^N * N)
    // S(C) = O(N) {recursion stack} + O(N) {op} + O(2^N * N) {HashSet}+ O(2^N * N) {result}
    //      = O(2^N * N)
//    public static List<List<Integer>> subsetsWithDup(int[] nums) {
//        Arrays.sort(nums);
//        HashSet<List<Integer>> hs = new HashSet<>();
//        List<Integer> op = new ArrayList<>();
//
//        solve(nums, 0, op, hs);
//        return new ArrayList<>(hs);
//    }
//
//    public static void solve(int[] nums, int i, List<Integer> op, HashSet<List<Integer>> hs) {
//        if (i == nums.length) {
//            hs.add(new ArrayList<>(op));
//            return;
//        }
//
//        solve(nums, i + 1, op, hs);
//        op.add(nums[i]);
//        solve(nums, i + 1, op, hs);
//        op.remove(op.size() - 1);
//    }
}
