package TakeYouforward.Array.LeetCode.Easy;
// Problem
/*
119. Pascal's Triangle II

Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:



Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:

Input: rowIndex = 0
Output: [1]
Example 3:

Input: rowIndex = 1
Output: [1,1]


Constraints:

0 <= rowIndex <= 33


Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?
 */

import java.util.ArrayList;
import java.util.List;

public class P7PascalTriangleII {
    public static void main(String[] args) {

    }

    // Optimal Approach
    // T(C) = O(n)
    // S(C) = O(1)
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        int n = rowIndex + 1;

        long ans = 1L;
        result.add((int) ans);
        for (int i = 1; i < n; i++) {
            ans *= (n - i);
            ans /= i;
            result.add((int) ans);
        }

        return result;
    }

    // Brute Force Approach
    // T(C) = O(n * c)
    // S(C) = O(1)
//    public static List<Integer> getRow(int rowIndex) {
//        List<Integer> result = new ArrayList<>();
//        int n = rowIndex + 1;
//        for (int c = 1; c <= n; c++) {
//            result.add(nCr(n - 1, c - 1));
//        }
//
//        return result;
//    }
//
//    public static int nCr(int r, int c) {
//        long res = 1;
//        for (int i = 0; i < c; i++) {
//            res *= (r - i);
//            res /= (i + 1);
//        }
//
//        return (int) res;
//    }
}