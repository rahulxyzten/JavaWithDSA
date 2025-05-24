package TakeYouforward.Array.LeetCode.Medium;
//Question
/*
59. Spiral Matrix II

Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

Example 1:

Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]

Example 2:

Input: n = 1
Output: [[1]]

Constraints:
1 <= n <= 20
 */

import java.util.Arrays;

public class P2SpiralMatrix {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(Arrays.deepToString(generateMatrix(n)));

    }
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int len = matrix.length;
        int m = matrix[0].length;
        int ele = 1;
        int top = 0, bottom = len - 1;
        int left = 0, right = m - 1;
        while(top <= bottom && left <= right){
            for (int i = left; i <= right; i++) {
               matrix[top][i] = ele;
               ele ++;
            }
            top++;
            for (int i = top; i <=bottom; i++) {
               matrix[i][right] = ele;
               ele++;
            }
            right--;
            if(top<=bottom){
                for (int i = right; i >= left; i--) {
                   matrix[bottom][i] = ele;
                   ele++;
                }
                bottom--;
            }
            if(left<=right){
                for(int i = bottom; i >= top ; i--) {
                   matrix[i][left] = ele;
                   ele++;
                }
                left++;
            }
        }

        return matrix;
    }
}
