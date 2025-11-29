package KunalKushwaha.Cp5Searching.BinarySearch.LeetCode.Easy;
// Problem
/*
1351. Count Negative Numbers in a Sorted Matrix

Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.

Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 100
-100 <= grid[i][j] <= 100


Follow up: Could you find an O(n + m) solution?
 */

public class P2CountNegativeNumberSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
//        int[][] matrix = {{3, 2}, {1, 0}};
        System.out.println(countNegatives(matrix));
    }

    // Optimal Solution
    // T(C) = O(N + M), where N = given row number, M = given column number.
    /*
    In each iteration of the while loop, we do i++ or j--;
    Since:
    i can increase at most n times (from 0 to n - 1),
    j can decrease at most m times (from m - 1 to 0),
    the loop runs at most n + m iterations → O(n + m) time.
     */
    // S(C) = O(1)
    public static int countNegatives(int[][] grid) {
        int i = 0, j = grid[0].length - 1;
        int n = grid.length;
        int count = 0;

        while (i < n && j >= 0) {
            if (grid[i][j] < 0) {
                count += (n - i);
                j--;
            } else {
                i++;
            }
        }

        return count;
    }

    // Better Approach
    // T(C) = O(n * 2logm) = O(n * logm)
    // n = number of rows, m = number of columns
    // S(C) = O(1)
//    public static int countNegatives(int[][] grid) {
//        int count = 0;
//        for (int[] arr : grid) {
//            int firstIndex = search(arr, true);
//            if (firstIndex != -1) {
//                int lastIndex = search(arr, false);
//                count += (lastIndex - firstIndex + 1);
//            }
//        }
//
//        return count;
//    }
//
//    public static int search(int[] arr, boolean findStartIndex) {
//        int start = 0, end = arr.length - 1;
//        int result = -1;
//
//        while (start <= end) {
//            int mid = start + (end - start) / 2;
//            if (arr[mid] < 0) {
//                result = mid;
//                if (findStartIndex) end = mid - 1;
//                else start = mid + 1;
//            } else {
//                start = mid + 1;
//            }
//        }
//
//        return result;
//    }
}
