package TakeYouforward.Array.LeetCode.Medium;
// Problem
/*
31. Next Permutation

A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.



Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]


Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class P14NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1, 1, 5};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    // Optimal Solution
    // T(C) = O(N + N + N) = O(N)
    // S(C) = O(1)
    public static void nextPermutation(int[] nums) {
        /* Step 1 */
        int breakPointIndex = -1;
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                breakPointIndex = i;
                break;
            }
        }

        // edge case
        if (breakPointIndex == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        /* Step 2 */
        for (int i = n - 1; i >= breakPointIndex; i--) {
            if (nums[i] > nums[breakPointIndex]) {
                swap(nums, breakPointIndex, i);
                break;
            }
        }

        /* Step 3 */
        reverse(nums, breakPointIndex + 1, n - 1);
        return;
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Brute Force Approach (Using Recursion)
    // Approach gives Time Limit Exceeded error 1 <= nums.length <= 100
    // T(C) = O(N! * N^2 * logN) = O(N! * N^2)
    // S(C) = O(N! * N)
//    public static void nextPermutation(int[] nums) {
//        // Arrays.sort(nums);
//        // We can't sort here because for example {1,2,3}
//        // At last it add {3, 2, 1} first then it add {3, 1, 2} in recursion
//
//        List<List<Integer>> allPermutations = new ArrayList<>();
//        permute(nums, nums.length, 0, allPermutations);
//
//        // We can sort here only because after we get all the permutation,
//        // we just sort all the permutation according to lexicographical order
//        // O((N! * log(N!))  * N) = O(N! * N logN * N) = O(N! N^2 logN)
//        // log(N!) = O(NlogN)
//        allPermutations.sort((a, b) -> {
//            for (int i = 0; i < a.size(); i++) {
//                if (a.get(i) != b.get(i)) {
//                    return a.get(i) - b.get(i);
//                }
//            }
//            return 0;
//        });
//
//        List<Integer> numsList = new ArrayList<>();
//        for (int num : nums) numsList.add(num);
//
//        // O(N! * N)
//        for (int i = 0; i < allPermutations.size(); i++) {
//            if (allPermutations.get(i).equals(numsList)) {
//                if (i == allPermutations.size() - 1) {
//                    for (int j = 0; j < nums.length; j++) {
//                        nums[j] = allPermutations.get(0).get(j);
//                    }
//                } else {
//                    for (int j = 0; j < nums.length; j++) {
//                        nums[j] = allPermutations.get(i + 1).get(j);
//                    }
//                }
//                return;
//            }
//        }
//    }
//
//    // O(N! * N)
//    public static void permute(int[] nums, int n, int i, List<List<Integer>> allPermutations) {
//        if (i == n - 1) {
//            List<Integer> op = new ArrayList<>();
//            for (int num : nums) op.add(num);
//            allPermutations.add(op);
//            return;
//        }
//
//        HashSet<Integer> hs = new HashSet<>();
//        for (int j = i; j < n; j++) {
//            if (!hs.contains(nums[j])) {
//                hs.add(nums[j]);
//                swap(nums, i, j);
//                permute(nums, n, i + 1, allPermutations);
//                swap(nums, i, j);
//            }
//        }
//    }
//
//    public static void swap(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }
}
