package AdityaVerma.StackAndQueue.Leetcode.Hard;
//This Problem is related ot The Largest Area in Histogram || Maximum Area Histogram
//Problem
/*
85. Maximal Rectangle

Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.



Example 1:


Input: matrix = [['1','0','1','0','0'],['1','0','1','1','1'],['1','1','1','1','1'],['1','0','0','1','0']]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
Example 2:

Input: matrix = [['0']]
Output: 0
Example 3:

Input: matrix = [['1']]
Output: 1


Constraints:

rows == matrix.length
cols == matrix[i].length
1 <= row, cols <= 200
matrix[i][j] is '0' or '1'.
 */

import java.util.Stack;

public class P2MaximalRectangle {
    public static void main(String[] args) {
        /* if taking the matrix as an integer matrix (GFG) */
//        int[][] matrix = {{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}};
//        System.out.println(maximalRectangle(matrix));

        /* if taking the matrix as a character matrix (LeetCode) */
        char[][] matrix = {{'1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'}, {'1','0','0','1','0'}};
        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int[] currRow = new int[matrix[0].length];
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') currRow[j] = 0;
                else currRow[j] += 1;
            }
            int currArea = largestRectangleArea(currRow);
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }

    //T(C) = O(N*M)
    //S(C) = O(M) because in many times we create a stack of size of m (no of colum)
    //so overall s(C) is O(M)
//    public static int maximalRectangle(int[][] matrix) {
//        if (matrix.length == 0) return 0;
//        int[] currRow = matrix[0];
//        int maxArea = largestRectangleArea(currRow);
//        for (int i = 1; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (matrix[i][j] == 0) currRow[j] = 0;
//                else currRow[j] += 1;
//            }
//            int currArea = largestRectangleArea(currRow);
//            maxArea = Math.max(maxArea, currArea);
//        }
//        return maxArea;
//    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if (s.isEmpty()) left[i] = -1;
            else left[i] = s.peek();
            s.push(i);
        }

        while (!s.isEmpty()) s.pop();

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if (s.isEmpty()) right[i] = n;
            else right[i] = s.peek();
            s.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, (heights[i] * (right[i] - left[i] - 1)));
        }

        return maxArea;
    }

}
