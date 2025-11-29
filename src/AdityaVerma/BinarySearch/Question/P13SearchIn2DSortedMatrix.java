package AdityaVerma.BinarySearch.Question;
//Search in Row wise And Column wise Sorted Array
//2D Binary Search on 2D array or Matrix

import java.util.Arrays;

public class P13SearchIn2DSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48}, {32, 33, 39, 50}};
        int target = 55;
        System.out.println(Arrays.toString(searchIn2DSortedMatrix(matrix, target)));
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
    static int[] searchIn2DSortedMatrix(int[][] matrix, int target) {
        int[] ans = new int[2];
        int n = matrix.length;
        int m = matrix[0].length;
        int i = 0, j = m - 1;

//        while (i >= 0 && i < n && j >= 0 && j < m) {
        while (i < n && j >= 0) {
            if (matrix[i][j] == target) {
                ans[0] = i;
                ans[1] = j;
                return ans;
            } else if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            }
        }

        return new int[]{-1, -1};
    }
}
