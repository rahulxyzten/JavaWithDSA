package KunalKushwaha.CP4Arrays.Leetcode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//question
/*
566. Reshape the Matrix

In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.

You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.

The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.

If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.



Example 1:

Input: mat = [[1,2],[3,4]], r = 1, c = 4
Output: [[1,2,3,4]]

Example 2:

Input: mat = [[1,2],[3,4]], r = 2, c = 4
Output: [[1,2],[3,4]]


Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 100
-1000 <= mat[i][j] <= 1000
1 <= r, c <= 300
 */
//Answer Explanation
/*
 * To fill in the reshaped 'ret' matrix, this algorithm has two loops. The outer loop
 * iterates over the rows of mat; the inner loop iterates over the cols of mat.
 *
 * Example:
 *
 *                                        row 0   1
 *                                      col ---------
 *         row 0   1   2                 0  | a | b |
 *       col  ------------                  |-------|
 *        0  | a | b | c |               1  | c | d |
 *           |-----------|   ------->       |-------|
 *        1  | d | e | f |               2  | e | f |
 *            -----------                   |-------|
 *
 *           mat matrix                    ret matrix
 *         mr = 1, mc = 3                  r = 3, c = 2
 *
 *
 *        -------- mat --------------    ------- ret ----------------
 *  i j k     mat[i][j]                  ret[k/c][k%c]
 *  - - - ---------------------------    ----------------------------
 *  0 0 0     mat[0,0] = a           --> ret[0/2][0%2] = ret[0][0]
 *  0 1 1     mat[0,1] = b           --> ret[1/2][1%2] = ret[0][1]
 *  0 2 2     mat[0,2] = c           --> ret[2/2][2%2] = ret[1][0]
 *  1 0 3     mat[1,0] = d           --> ret[3/2][3%2] = ret[1][1]
 *  1 1 4     mat[1,1] = e           --> ret[4/2][4%2] = ret[2][0]
 *  1 2 5     mat[1,2] = f           --> ret[5/2][5%2] = ret[2][1]
 *
 * The total number of division operations of the two loops is n * 2,
 * where n = mr * mc. This is half as many division operations as the
 * single-loop version below.
 */

public class P22ReshapeMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1, 2}, {3, 4}};
        int r = 1, c = 4;
        System.out.println(Arrays.deepToString(matrixReshape(mat, r, c)));
    }

    /* BEST SOLUTION (Remember KC) */
    // T(C) = O(n*m)
    // S(C) = O(n*m) or O(1) if we remove the output matrix
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int n = mat.length;
        int m = mat[0].length;
        int mul = n * m;
        if (r * c != mul) return mat;
        int[][] result = new int[r][c];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //remember the below line ( KC )
                result[k / c][k % c] = mat[i][j];
                k++;
            }
        }

        return result;
    }

    // Brute Force Approach
    // T(C) = O(2 (n*m)) = O(n*m) because the n*m == r*c
    // S(C) = O(2 (n*m)) = O(n*m) because in the temp and result same number of elements are stored
//    public static int[][] matrixReshape(int[][] mat, int r, int c) {
//        int n = mat.length;
//        int m = mat[0].length;
//        if (n*m != r*c) return mat;
//
//        List<Integer> temp = new ArrayList<>();
//        int[][] result = new int[r][c];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                temp.add(mat[i][j]);
//            }
//        }
//
//        int index = 0;
//        for (int i = 0; i < r; i++) {
//            for (int j = 0; j < c; j++) {
//               result[i][j] = temp.get(index++);
//            }
//        }
//
//        return result;
//    }
}
