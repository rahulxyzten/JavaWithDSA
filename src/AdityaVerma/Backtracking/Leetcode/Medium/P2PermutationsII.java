package AdityaVerma.Backtracking.Leetcode.Medium;
//problem
/*
47. Permutations II

Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.



Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]


Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class P2PermutationsII {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(permuteUnique(nums));
    }

    // time complexity of O(N! * N)
    // space complexity is O(N! * N)
    // T(C) = O(N! * N)
    // total number of node => O(N!)
    // work done by a node => HashSet add and contains takes O(1), swap operation takes O(1), copying Array to List takes O(N)
    // S(C) = O(N! * N) + O(N) + O(N) + O(N) = O(N! * N)
    // total number of List in List * each List length + HashSet length + intermediate op list +  recursion stack (depth of the recursion)
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, nums.length, result);
        return result;
    }

    public static void permute(int[] nums, int start, int n, List<List<Integer>> result) {
        if (start == n - 1) {
            List<Integer> op = new ArrayList<>();
            for (int num : nums) {
                op.add(num);
            }
            result.add(op);
        }

        HashSet<Integer> mpp = new HashSet<>();
        for (int i = start; i < n; i++) {
            if (!mpp.contains(nums[i])) {
                mpp.add(nums[i]);
                swap(i, start, nums);
                permute(nums, start + 1, n, result);
                swap(i, start, nums);
            }
        }
    }

    public static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
