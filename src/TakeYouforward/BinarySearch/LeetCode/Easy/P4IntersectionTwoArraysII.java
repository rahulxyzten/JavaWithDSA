package TakeYouforward.BinarySearch.LeetCode.Easy;
// Problem
/*
350. Intersection of Two Arrays II

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.


Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000


Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */

import java.util.*;

public class P4IntersectionTwoArraysII {
    public static void main(String[] args) {

    }

    // Using Sorting and Two Pointers
    // T(C) = O(nlogn) + O(mlogm) + O(2 min(n,m))
    // S(C) = O(2 min(n,m))
//    public static int[] intersect(int[] nums1, int[] nums2) {
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        List<Integer> ls = new ArrayList<>();
//
//        int n = nums1.length, m = nums2.length;
//        int i = 0, j = 0;
//        while (i < n && j < m) {
//            if (nums1[i] == nums2[j]) {
//                ls.add(nums1[i]);
//                i++;
//                j++;
//            } else if (nums1[i] < nums2[j]) i++;
//            else j++;
//        }
//
//        int[] result = new int[ls.size()];
//        int ind = 0;
//        for (int num : ls) {
//            result[ind++] = num;
//        }
//
//        return result;
//    }

    // Optimal Approach
    // T(C) = O(N) + O(M) + O(min(N,M))
    // S(C) = O(N) + O(2 min(N,M))
    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int num : nums1) {
            mpp.put(num, mpp.getOrDefault(num, 0) + 1);
        }

        List<Integer> ls = new ArrayList<>();
        for (int num : nums2) {
            if (mpp.get(num) != null && mpp.get(num) > 0) {
                ls.add(num);
                mpp.put(num, mpp.get(num) - 1);
            }
        }

        int[] result = new int[ls.size()];
        int i = 0;
        for (int num : ls) {
            result[i++] = num;
        }

        return result;
    }

    // Brute Force Approach
    // T(C) = O(N) + O(M) + O(N) + O(min(N,M))
    // S(C) = O(N) + O(M) + O(2 min(N,M))
//    public static int[] intersect(int[] nums1, int[] nums2) {
//        HashMap<Integer, Integer> mpp1 = new HashMap<>();
//        for (int num : nums1) {
//            mpp1.put(num, mpp1.getOrDefault(num, 0) + 1);
//        }
//
//        HashMap<Integer, Integer> mpp2 = new HashMap<>();
//        for (int num : nums2) {
//            mpp2.put(num, mpp2.getOrDefault(num, 0) + 1);
//        }
//
//        List<Integer> ls = new ArrayList<>();
//        for (int num : mpp1.keySet()) {
//            if (mpp2.containsKey(num)) {
//                int min = Math.min(mpp1.get(num), mpp2.get(num));
//                for (int i = 0; i < min; i++) {
//                    ls.add(num);
//                }
//            }
//        }
//
//        int[] result = new int[ls.size()];
//        int i = 0;
//        for (int num : ls) {
//            result[i++] = num;
//        }
//
//        return result;
//    }
}
