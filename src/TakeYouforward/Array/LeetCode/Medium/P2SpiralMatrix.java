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

    // T(C) = O(M*N)
    // S(C) = O(M*N) or O(1) If we remove the asked output matrix.
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int left = 0, right = n - 1;
        int top = 0, bottom = n - 1;
        int temp = 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result[top][i] = temp;
                temp++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result[i][right] = temp;
                temp++;
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result[bottom][i] = temp;
                    temp++;
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result[i][left] = temp;
                    temp++;
                }
                left++;
            }
        }

        return result;
    }
}
