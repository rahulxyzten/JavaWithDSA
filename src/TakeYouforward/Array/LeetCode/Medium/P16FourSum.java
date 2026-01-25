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
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;

//        int[] nums = {2, 2, 2, 2, 2};
//        int target = 8;
        System.out.println(fourSum(nums, target));
    }

    /* Better Approach (Hashing using HashSet) */
    // T(C) = O(N^3 * log(no. of unique quadruplets))
    // S(C) =  O(2 * no. of the unique quadruplets) + O(N)
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Integer> seen = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    long sum = nums[i] + nums[j] + nums[k];
                    long rem = target - sum;
                    if (seen.contains((int) rem)) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], (int) rem);
                        Collections.sort(temp);
                        set.add(temp);
                    }

                    seen.add(nums[k]);
                }
            }
        }

        return new ArrayList<>(set);
    }

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
