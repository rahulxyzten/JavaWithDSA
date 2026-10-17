package TakeYouforward.Array.LeetCode.Easy;
// Problem (GFG)
/*
Intersection of Two Sorted Arrays

Given two sorted arrays arr1[] and arr2[]. Your task is to return the intersection of both arrays.
Intersection of two arrays is said to be elements that are common in both arrays. The intersection should not count duplicate elements.
Note: If there is no intersection then return an empty array.

Examples:

Input: arr1[] = [1, 2, 3, 4], arr2[] = [2, 4, 6, 7, 8]
Output: [2, 4]
Explanation: 2 and 4 are only common elements in both the arrays.
Input: arr1[] = [1, 2, 2, 3, 4], arr2[] = [2, 2, 4, 6, 7, 8]
Output: [2, 4]
Explanation: 2 and 4 are the only common elements.
Input: arr1[] = [1, 2], arr2[] = [3, 4]
Output: []
Explanation: No common elements.
Constraints:
1 ≤ arr1.size(),arr2.size() ≤ 10^5
1 ≤ arr1[i], arr2[i] ≤ 10^6
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class P11IntersectionTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4}, arr2 = {2, 4, 6, 7, 8};
        System.out.println(intersection(arr1, arr2));
    }

    // Optimal Approach
    // T(C) = O(n+m)
    // S(C) = O(1)
    public static ArrayList<Integer> intersection(int arr1[], int arr2[]) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0, n = arr1.length, m = arr2.length;

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) i++;
            else if (arr1[i] > arr2[j]) j++;
            else {
                if (result.size() == 0 || result.get(result.size() - 1) != arr1[i]) {
                    result.add(arr1[i]);
                }
                i++;
                j++;
            }
        }

        return result;
    }

    // Better Approach
    // T(C) = O(N) + O(M) + O(K) + O(KlogK)  {K ≤ min(N,M)}
    // S(C) = O(N) + O(k)
//    public static ArrayList<Integer> intersection(int arr1[], int arr2[]) {
//        Set<Integer> firstSet = new HashSet<>();
//        Set<Integer> intersectionSet = new HashSet<>();
//
//        for (int num : arr1) firstSet.add(num);
//
//        for (int num : arr2) {
//            if (firstSet.contains(num)) intersectionSet.add(num);
//        }
//
//        ArrayList<Integer> result = new ArrayList<>(intersectionSet);
//        Collections.sort(result);
//
//        return result;
//    }

    // Brute Force Approach
    // T(C) = O(N*M)
    // S(C) = O(1)
}