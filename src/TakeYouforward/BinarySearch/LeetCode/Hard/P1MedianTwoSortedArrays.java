package TakeYouforward.BinarySearch.LeetCode.Hard;
// Problem
/*
4. Median of Two Sorted Arrays

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.


Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
 */

import java.util.ArrayList;
import java.util.List;

public class P1MedianTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2}, nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    // Optimal Approach (Binary Search) (Mine) (Long Length)
    // T(C) = O(log(min(n1,n2)))
    // S(C) = O(1)
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if (n1 == 0) {
            if (n2 % 2 == 1) return (double) nums2[n2 / 2];
            else return (nums2[n2 / 2] + nums2[(n2 / 2) - 1]) / 2.0;
        }
        if (n2 == 0) {
            if (n1 % 2 == 1) return (double) nums1[n1 / 2];
            else return (nums1[n1 / 2] + nums1[(n1 / 2) - 1]) / 2.0;
        }

        int n = n1 + n2;
        int leftHalf;
        if (n % 2 == 0) {
            leftHalf = n / 2;
        } else {
            leftHalf = (n + 1) / 2;
        }

        int start = 0, end = Math.min(n1, n2);
        int l1 = -1, l2 = -1, r1 = -1, r2 = -1;

        while (start <= end) {
            int mid1 = start + (end - start) / 2;
            int mid2 = leftHalf - mid1;

            if (n1 <= n2) {
                if (mid1 == 0) {
                    l1 = Integer.MIN_VALUE;
                    r1 = nums1[mid1];
                } else if (mid1 == n1) {
                    l1 = nums1[mid1 - 1];
                    r1 = Integer.MAX_VALUE;
                } else {
                    l1 = nums1[mid1 - 1];
                    r1 = nums1[mid1];
                }

                if (mid2 == 0) {
                    l2 = Integer.MIN_VALUE;
                    r2 = nums2[mid2];
                } else if (mid2 == n2) {
                    l2 = nums2[mid2 - 1];
                    r2 = Integer.MAX_VALUE;
                } else {
                    l2 = nums2[mid2 - 1];
                    r2 = nums2[mid2];
                }
            } else {
                if (mid1 == 0) {
                    l1 = Integer.MIN_VALUE;
                    r1 = nums2[mid1];
                } else if (mid1 == n2) {
                    l1 = nums2[mid1 - 1];
                    r1 = Integer.MAX_VALUE;
                } else {
                    l1 = nums2[mid1 - 1];
                    r1 = nums2[mid1];
                }

                if (mid2 == 0) {
                    l2 = Integer.MIN_VALUE;
                    r2 = nums1[mid2];
                } else if (mid2 == n1) {
                    l2 = nums1[mid2 - 1];
                    r2 = Integer.MAX_VALUE;
                } else {
                    l2 = nums1[mid2 - 1];
                    r2 = nums1[mid2];
                }
            }

            if (l1 <= r2 && l2 <= r1) break;

            if (l1 >= r2) end = mid1 - 1;
            if (l2 >= r1) start = mid1 + 1;
        }

        if (n % 2 == 1) return (double) Math.max(l1, l2);
        else return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
    }

    // Better Approach
    // T(C) = O(N1+N2)
    // S(C) = O(1)
//    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int n1 = nums1.length, n2 = nums2.length;
//        int n = n1 + n2;
//
//        int mid1 = (n / 2) - 1;
//        int mid2 = n / 2;
//
//        int i = 0, j = 0;
//        int mid1el = -1, mid2el = -1;
//        int count = 0;
//        // count start from o only because merged array index is also start from 0
//
//        while (i < n1 && j < n2) {
//            if (nums1[i] < nums2[j]) {
//                if (count == mid1) mid1el = nums1[i];
//                if (count == mid2) mid2el = nums1[i];
//                i++;
//            } else {
//                if (count == mid1) mid1el = nums2[j];
//                if (count == mid2) mid2el = nums2[j];
//                j++;
//            }
//            count++;
//        }
//
//        while (i < n1) {
//            if (count == mid1) mid1el = nums1[i];
//            if (count == mid2) mid2el = nums1[i];
//            i++;
//            count++;
//        }
//
//        while (j < n2) {
//            if (count == mid1) mid1el = nums2[j];
//            if (count == mid2) mid2el = nums2[j];
//            j++;
//            count++;
//        }
//
//        if (n % 2 == 1) return (double) mid2el;
//        else return (mid1el + mid2el) / 2.0;
//    }

    // Brute Force Approach
    // T(C) = O(N1+N2)
    // S(C) = O(N1+N2)
//    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        List<Integer> merged = new ArrayList<>();
//        int i = 0, j = 0;
//
//        while (i < nums1.length && j < nums2.length) {
//            if (nums1[i] < nums2[j]) {
//                merged.add(nums1[i]);
//                i++;
//            } else {
//                merged.add(nums2[j]);
//                j++;
//            }
//        }
//
//        while (i < nums1.length) {
//            merged.add(nums1[i]);
//            i++;
//        }
//
//        while (j < nums2.length) {
//            merged.add(nums2[j]);
//            j++;
//        }
//
//        int n = merged.size();
//        if (n % 2 == 1) return (double) merged.get(n / 2);
//        else return (merged.get((n / 2) - 1) + merged.get(n / 2)) / 2.0;
//    }
}
