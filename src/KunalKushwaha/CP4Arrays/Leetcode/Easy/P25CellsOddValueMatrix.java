package KunalKushwaha.CP4Arrays.Leetcode.Easy;

//Question
/*
1252. Cells with Odd Values in a Matrix

There is an m x n matrix that is initialized to all 0's. There is also a 2D array indices where each indices[i] = [ri, ci] represents a 0-indexed location to perform some increment operations on the matrix.

For each location indices[i], do both of the following:

Increment all the cells on row ri.
Increment all the cells on column ci.
Given m, n, and indices, return the number of odd-valued cells in the matrix after applying the increment to all locations in indices.

Example 1:

Input: m = 2, n = 3, indices = [[0,1],[1,1]]
Output: 6
Explanation: Initial matrix = [[0,0,0],[0,0,0]].
After applying first increment it becomes [[1,2,1],[0,1,0]].
The final matrix is [[1,3,1],[1,3,1]], which contains 6 odd numbers.

Example 2:

Input: m = 2, n = 2, indices = [[1,1],[0,0]]
Output: 0
Explanation: Final matrix = [[2,2],[2,2]]. There are no odd numbers in the final matrix.


Constraints:

1 <= m, n <= 50
1 <= indices.length <= 100
0 <= ri < m
0 <= ci < n


Follow up: Could you solve this in O(n + m + indices.length) time with only O(n + m) extra space?
*/

//Explanation
/*
https://www.youtube.com/watch?v=mC7tpRNR0_o
 */

public class P25CellsOddValueMatrix {
    public static void main(String[] args) {
//        int[][] indices = {{1, 1}, {0, 0}};
        int[][] indices = {{0, 1}, {1, 1}};
        int m = 2, n = 3;
        System.out.println(oddCells(m, n, indices));
    }

    // Optimal Solution
    // T(C) = O(k + n + m)
    // S(C) = O(m+n)
    public static int oddCells(int m, int n, int[][] indices) {
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for (int[] index : indices) {
            row[index[0]] = !row[index[0]];
            col[index[1]] = !col[index[1]];
        }

        int oddRow = 0, evenRow = 0;
        int oddCol = 0, evenCol = 0;

        for (int i = 0; i < m; i++) {
            if (row[i]) oddRow++;
            else evenRow++;
        }

        for (int j = 0; j < n; j++) {
            if (col[j]) oddCol++;
            else evenCol++;
        }

        return (oddRow * evenCol) + (oddCol * evenRow);
    }


    // Better Approach
    // T(C) = O(k + (n * m))
    // S(C) = O(m+n)
//    public static int oddCells(int m, int n, int[][] indices) {
//        int count = 0;
//        int[] row = new int[m];
//        int[] col = new int[n];
//
//        for (int[] index : indices) {
//            row[index[0]]++;
//            col[index[1]]++;
//        }
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if ((row[i] + col[j]) % 2 != 0) count++;
//            }
//        }
//
//        return count;
//    }


    // Brute Force Approach
    // T(C) = O(k * (m + n) + (m * n))
    // S(C) = O(m+n)
//    public static int oddCells(int m, int n, int[][] indices) {
//        int[][] ans = new int[m][n];
//
//        for(int[] index: indices){
//            // Here we increment the row elements
//            for (int j = 0; j < n; j++) {
//                ans[index[0]][j]++;
//            }
//
//            // Here we increment the column elements
//            for(int i = 0; i < m; i++){
//                ans[i][index[1]]++;
//            }
//        }
//
//        int count = 0;
//        for (int[] arr: ans){
//            for (int num: arr){
//                if (num % 2 != 0) count++;
//            }
//        }
//
//        return count;
//    }
}
