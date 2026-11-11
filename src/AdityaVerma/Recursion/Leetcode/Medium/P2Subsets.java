package AdityaVerma.Recursion.Leetcode.Medium;
// problem
/*
78. Subsets

Given an integer array nums of unique elements, return all possible
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]


Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
 */

import java.util.ArrayList;
import java.util.List;

public class P2Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    // Best Code Love Babbar if the ip is given an array if
    // the ip is given String go for Aditya verma Solution
    // T(C) = O(N * 2^N)
    // S(C) = O(N * 2^N)
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> op = new ArrayList<>();

        findSubsets(nums, 0, op, result);
        return result;
    }

    public static void findSubsets(int[] nums, int i, List<Integer> op, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(new ArrayList<>(op));
            // In Java, when you add or remove elements from a list, you are modifying the
            // original list so always take a new ArrayList and append op there
            return;
        }

        findSubsets(nums, i + 1, op, result);
        op.add(nums[i]);
        findSubsets(nums, i + 1, op, result);
        op.remove(op.size() - 1);
    }

    /*
    result.add(op);
    Your solution fails because you're adding the same List reference (op) to result
    every time, rather than adding a copy of the list. In Java, List objects are
    passed by reference, so when you add op to result, you're storing a reference
    to the same list object.

    The Problem
    When you do result.add(op), all entries in result point to the same op list object.
    As recursion proceeds, and you modify op (by adding and removing elements),
    all the references in result reflect these changes. By the time recursion completes,
    op is empty, so all entries in result appear as empty lists.
     */
}
