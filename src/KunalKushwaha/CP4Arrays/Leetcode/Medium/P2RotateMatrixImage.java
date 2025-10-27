package KunalKushwaha.CP4Arrays.Leetcode.Medium;
//Question
/*
48. Rotate Image
Medium
15.8K
692
Companies

You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
DO NOT allocate another 2D matrix and do the rotation.


Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
Example 2:


Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]


Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000
 */

import java.util.Arrays;

public class P2RotateMatrixImage {
    public static void main(String[] args) {
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
//        int[][]  matrix = {{1,2,3,},{4,5,6},{7,8,9}};
        rotate(matrix);
    }

    /* Best code with best time and space complexity */
    //T(C) = O(N*N) + O(N*N) => One O(N*N) is for transposing the matrix and the other one is for reversing the matrix.
    //S(C) = O(1)
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }

        System.out.println(Arrays.deepToString(matrix));
    }


//    public static void rotate(int[][] matrix) {
//        int n = matrix.length;
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j++) {
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[j][i];
//                matrix[j][i] = temp;
//            }
//        }
//        for (int i = 0; i < n/2; i++) {
//            for (int j = 0; j < n; j++) {
//                int temp = matrix[j][i];
//                matrix[j][i] = matrix[j][n-1-i];
//                matrix[j][n-1-i] = temp;
//            }
//        }
//
//        System.out.println(Arrays.deepToString(matrix));
//    }


    /* DO NOT allocate another 2D matrix and do the rotation. */
//    public static void rotate(int[][] matrix) {
//        int n = matrix.length;
//        int[][] result = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                result[i][j] = matrix[n - 1 - j][i];
//            }
//        }
//        System.out.println(Arrays.deepToString(result));
//    }
}
