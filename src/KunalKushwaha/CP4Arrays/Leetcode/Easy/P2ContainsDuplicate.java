package KunalKushwaha.CP4Arrays.Leetcode.Easy;

import java.util.*;
//Problem
/*
217. Contains Duplicate

Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.



Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false
Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true


Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
 */

public class P2ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(containsDuplicate(nums));
    }


    /* Type Best T(C) = O(N) S(C) = O(N) */
    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        for (int num: nums){
            if (seen.containsKey(num) && seen.get(num) >= 1) return true;
            seen.put(num, seen.getOrDefault(num, 0) + 1);
        }
        return false;
    }

//    public static boolean containsDuplicate(int[] nums) {
//        HashSet<Integer> hset = new HashSet<Integer>();
//        for (int num : nums) {
//            if (hset.contains(num)) return true;
//            else hset.add(num);
//        }
//        return false;
//    }

//    T(C) = O(nlogn) + O(n)
//    public boolean containsDuplicate(int[] nums) {
//        Arrays.sort(nums);
//        int n = nums.length;
//        for (int i = 1; i < n; i++) {
//            if (nums[i] == nums[i - 1])
//                return true;
//        }
//        return false;
//    }

}
