package TakeYouforward.Array.LeetCode.Medium;
// Problem
/*
18. 4Sum

Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.



Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]


Constraints:

1 <= nums.length <= 200
-10^9 <= nums[i] <= 10^9
-10^9 <= target <= 10^9
 */

import java.util.*;

public class P16FourSum {
    public static void main(String[] args) {
//        int[] nums = {1, 0, -1, 0, -2, 2};
//        int target = 0;

        int[] nums = {2, 2, 2, 2, 2};
        int target = 8;
        System.out.println(fourSum(nums, target));
    }

    /* Optimal Approach (Two Pointer Approach) */
    // T(C) = O(NlogN + N^3)
    // S(C) =  O(no. of the unique quadruplets)
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j > (i + 1) && nums[j] == nums[j - 1]) continue;

                int k = j + 1, l = n - 1;
                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    // Type Conversion (long) must be done here only
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum > target) l--;
                    else k++;
                }
            }
        }

        return result;
    }

    /* Better Approach (Hashing using HashSet) */
    // T(C) = O(N^3 * log(no. of unique quadruplets))
    // S(C) =  O(2 * no. of the unique quadruplets) + O(N)
//    public static List<List<Integer>> fourSum(int[] nums, int target) {
//        int n = nums.length;
//        HashSet<List<Integer>> result = new HashSet<>();
//
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                HashSet<Long> seen = new HashSet<>();
//                for (int k = j + 1; k < n; k++) {
//                    long sum = (long) nums[i] + nums[j] + nums[k];
//                    long rem = target - sum;
//                    if (seen.contains(rem)) {
//                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], (int) rem);
//                        Collections.sort(temp);
//                        result.add(temp);
//                    }
//                    seen.add((long) nums[k]);
//                }
//            }
//        }
//
//        return new ArrayList<>(result);
//    }

    /* Brute Force Approach */
    // T(C) = O(N^4 * log(no. of unique quadruplets))
    // Inserting quadruplets into the set takes O(log(no. of unique quadruplets ))
    // Not considering the time complexity of sorting as we are just sorting 4 elements every time
    // S(C) =  O(2 * no. of the unique quadruplets)
//    public static List<List<Integer>> fourSum(int[] nums, int target) {
//        int n = nums.length;
//        Set<List<Integer>> set = new HashSet<>();
//
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                for (int k = j + 1; k < n; k++) {
//                    for (int l = k + 1; l < n; l++) {
//                        long sum = nums[i] + nums[j] + nums[k] + nums[l];
//                        if (sum == target) {
//                            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
//                            Collections.sort(temp);
//                            set.add(temp);
//                        }
//                    }
//                }
//            }
//        }
//
//        return new ArrayList<>(set);
//    }
}
