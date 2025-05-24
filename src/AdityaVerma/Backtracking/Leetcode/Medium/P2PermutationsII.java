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


//    time complexity of O(N * N!)
//    space complexity is O(N * N!)

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(0, nums, result);
        return result;
    }

    public static void permute(int start, int[] nums, List<List<Integer>> result) {
        if (start == nums.length - 1) {
            List<Integer> op = new ArrayList<>();
            for (int num : nums) {
                op.add(num);
            }
            result.add(op);
        }
        HashSet<Integer> mpp = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (!mpp.contains(nums[i])) {
                mpp.add(nums[i]);
                swap(i, start, nums);
                permute(start + 1, nums, result);
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
