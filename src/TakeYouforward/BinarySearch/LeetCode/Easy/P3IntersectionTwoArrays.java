package TakeYouforward.BinarySearch.LeetCode.Easy;
// Problem
/*
349. Intersection of Two Arrays

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.



Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.


Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class P3IntersectionTwoArrays {
    public static void main(String[] args) {

    }

    // Better Approach (using Sorting and Two Pointers)
    // T(C) = O(nlogn) + O(mlogm) + O(2 min(n,m))
    // S(C) = O(2 min(n,m))
    public static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        HashSet<Integer> set = new HashSet<>();

        int n = nums1.length, m = nums2.length;
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) i++;
            else j++;
        }

        int[] result = new int[set.size()];
        int ind = 0;
        for (int num : set) {
            result[ind++] = num;
        }

        return result;
    }

    // Optimal Approach
    // T(C) = O(N) + O(M) + O(M)
    // S(C) = O(N) + O(M) + O(M)
//    public static int[] intersection(int[] nums1, int[] nums2) {
//        HashMap<Integer, Boolean> mpp = new HashMap<>();
//        for (int num : nums1) {
//            if (!mpp.containsKey(num)) mpp.put(num, true);
//        }
//
//        HashSet<Integer> set = new HashSet<>();
//        for (int num : nums2) {
//            if (mpp.containsKey(num)) set.add(num);
//        }
//
//        int[] result = new int[set.size()];
//        int i = 0;
//        for (int num : set) {
//            result[i++] = num;
//        }
//
//        return result;
//    }

    // Brute Force Approach
    // T(C) = O(N*M) + O(M)
    // S(C) = O(2M)
//    public static int[] intersection(int[] nums1, int[] nums2) {
//        HashSet<Integer> set = new HashSet<>();
//        int n = nums1.length, m = nums2.length;
//        for (int i : nums1) {
//            for (int j : nums2) {
//                if (i == j) set.add(i);
//            }
//        }
//
//        int[] result = new int[set.size()];
//        int i = 0;
//        for (int num : set) {
//            result[i++] = num;
//        }
//
//        return result;
//    }
}
