package TakeYouforward.Array.LeetCode.Medium;
//Question
/*
73. Set Matrix Zeroes
Medium
12.9K
646
Companies
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.



Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]


Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1


Follow up:

A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 */

import java.util.Arrays;

public class P3SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1, 1}, {1, 0, 1, 1}, {1, 1, 0, 1}, {0, 1, 1, 1}};
//        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
    }

    /* Optimal Approach T(C) = O(2*n*m) & S(C) = O(1) */
    public static void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int col0 = 1;
//        int[] col = new int[m]; -> matrix[0][....] column Array
//        int[] row = new int[n]; -> matrix[....][0] row Array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    //mark 0 for row array.
                    //row array condition is first because row matrix condition is for
                    //all n and col array condition is for less than one element ( m - 1 )
                    // means j = 0 belong to col0 in whatever value of i
                    matrix[i][0] = 0;
                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] != 0) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }


    /* Better Approach T(C) = O(2*n*m) & S(C) = O(N)+O(M) */
//    public static void setZeroes(int[][] matrix) {
//        int n = matrix.length;
//        int m = matrix[0].length;
//        int[] col = new int[m];
//        int[] row = new int[n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (matrix[i][j] == 0) {
//                    row[i] = 1;
//                    col[j] = 1;
//                }
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (row[i] == 1 || col[j] == 1){
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//        System.out.println(Arrays.deepToString(matrix));
//    }




    /* Brute Force Approach */
//    public static void setZeroes(int[][] matrix) {
//        int n = matrix.length;
//        int m = matrix[0].length;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (matrix[i][j] == 0) {
//                    markRow(matrix, n, i);
//                    markCol(matrix, m, j);
//                }
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (matrix[i][j] == -1) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//        System.out.println(Arrays.deepToString(matrix));
//    }
//
//    public static void markRow(int[][] matrix, int n, int i) {
//        for (int j = 0; j < n; j++) {
//            if (matrix[i][j] != 0) {
//                matrix[i][j] = -1;
//            }
//
//        }
//    }
//
//    public static void markCol(int[][] matrix, int m, int j) {
//        for (int i = 0; i < m; i++) {
//            if (matrix[i][j] != 0) {
//                matrix[i][j] = -1;
//            }
//
//        }
//    }
}
