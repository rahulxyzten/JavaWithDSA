package AdityaVerma.BinarySearch.Leetcode.Medium;
//Question
/*
74. Search a 2D Matrix

You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.



Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
 */

public class P5SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 8;
        System.out.println(searchMatrix(matrix, target));
    }

    // T(C) = O(N + M), where N = given row number, M = given column number.
    /*
    In each iteration of the while loop, we do i++ or j--;
    Since:
    i can increase at most n times (from 0 to n - 1),
    j can decrease at most m times (from m - 1 to 0),
    the loop runs at most n + m iterations → O(n + m) time.
     */
    // S(C) = O(1)
    public static boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) return true;
            else if (target > matrix[i][j]) i++;
            else j--; // target < matrix[i][j]
        }

        return false;
    }

//    public static boolean searchMatrix(int[][] matrix, int target) {
//        int n = matrix.length;
//        int m = matrix[0].length;
//        int i = 0, j = m - 1;
//        while (i >= 0 && i < n && j >= 0 && j < m) {
//            if (matrix[i][j] == target) return true;
//            else if (matrix[i][j] > target) j--;
//            else if (matrix[i][j] < target) i++;
//        }
//        return false;
//    }


}
