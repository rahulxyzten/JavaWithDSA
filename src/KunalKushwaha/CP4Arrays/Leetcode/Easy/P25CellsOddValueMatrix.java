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

//Time small explanation
//Count how many times each row and column is incremented using row and column array.
//        Add row and col value to get corresponding array element value.
//        If it's odd increment counter

public class P25CellsOddValueMatrix {
    public static void main(String[] args) {
//        int[][] indices = {{1, 1}, {0, 0}};
        int[][] indices = {{0, 1}, {1, 1}};
        int m = 2, n = 3;
        System.out.println(oddCells(m, n, indices));
    }

    /* BEST CODE */
    public static int oddCells(int n, int m, int[][] indices) {
        int count = 0;
        int[] row = new int[n];
        int[] col = new int[m];
        for (int[] x : indices) {
            row[x[0]]++;
            col[x[1]]++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((row[i] + col[j]) % 2 != 0) {
                    count++;
                }
            }
        }
        return count;
    }

//    public static int oddCells(int m, int n, int[][] indices) {
//        int[][] ans = new int[m][n];
//        int k = indices.length;
//        for (int i = 0; i < k; i++) {
//            for (int j = 0; j < n; j++) {
//                ans[indices[i][0]][j]++;
//            }
//            //Kete ta column element(gure row ra sabu element) update heba n ta column element update heba for each value of i
//            //For i = 0, i<k column 0 1 2 (size of column n = 3) os j<n ta column update heba
//            for (int j = 0; j < m; j++) {
//                ans[j][indices[i][1]]++;
//            }
//            //Kete ta row element(gute column re sabu element) update heba m ta row element update heba for each value of i
//            //For i = 0, i<k column 0 1  (size of row m = 2) os j<m ta column update heba
//        }
//        int count = 0;
//        for (int[] arr: ans){
//            for (int num: arr){
//                if (num%2 != 0) count++;
//            }
//        }
//        return count;
//    }
}
