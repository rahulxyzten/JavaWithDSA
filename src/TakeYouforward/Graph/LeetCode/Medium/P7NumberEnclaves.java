package TakeYouforward.Graph.LeetCode.Medium;
// Problem
/*
1020. Number of Enclaves

You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.



Example 1:


Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
Example 2:


Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
Output: 0
Explanation: All 1s are either on the boundary or can reach the boundary.


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 500
grid[i][j] is either 0 or 1.
 */

public class P7NumberEnclaves {
    public static void main(String[] args) {

    }

    // MY Type (Using and extra result array)
    // T(C) = O(n*m) + O((n*m)*4) == O(n*m)
    // S(C) = O(n*m) + O(n*m) == O(n*m)
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int[] tempRow = {-1, 0, 1, 0};
        int[] tempCol = {0, 1, 0, -1};

        int count = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                int[] result = {0, 0};
                if (grid[row][col] == 1 && visited[row][col] == 0) {
                    dfs(row, col, tempRow, tempCol, visited, grid, result);
                    if (result[1] == 0) count += result[0];
                }
            }
        }

        return count;
    }

    public void dfs(int row, int col, int[] tempRow, int[] tempCol, int[][] visited, int[][] grid, int[] result) {
        visited[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;
        result[0] += 1;
        if (row == 0 || row == (n - 1) || col == 0 || col == m - 1) result[1] = 1;

        for (int i = 0; i < 4; i++) {
            int n_row = row + tempRow[i];
            int n_col = col + tempCol[i];
            if (n_row >= 0 && n_row < n && n_col >= 0 && n_col < m && grid[n_row][n_col] == 1 && visited[n_row][n_col] == 0) {
                dfs(n_row, n_col, tempRow, tempCol, visited, grid, result);
            }
        }
    }

    // Same Intuition and Approach as the previous question (130. Surrounded Regions)
    // T(C) = O(m) + O(n) + O(n*m) + O((n*m)*4) == O(n*m)
    // S(C) = O(n*m) + O(n*m) == O(n*m)
//    public int numEnclaves(int[][] grid) {
//        int n = grid.length;
//        int m = grid[0].length;
//        int[] tempRow = {-1, 0, 1, 0};
//        int[] tempCol = {0, 1, 0, -1};
//        int[][] visited = new int[n][m];
//
//        // Top Edge and Bottom Edge
//        for (int col = 0; col < m; col++) {
//            // Top Edge
//            if (grid[0][col] == 1 && visited[0][col] == 0) {
//                dfs(0, col, tempRow, tempCol, visited, grid);
//            }
//
//            // Bottom Edge
//            if (grid[n - 1][col] == 1 && visited[n - 1][col] == 0) {
//                dfs(n - 1, col, tempRow, tempCol, visited, grid);
//            }
//        }
//
//        // Left Edge and Right Edge
//        for (int row = 1; row < n - 1; row++) {
//            // Left Edge
//            if (grid[row][0] == 1 && visited[row][0] == 0) {
//                dfs(row, 0, tempRow, tempCol, visited, grid);
//            }
//
//            // Right Edge
//            if (grid[row][m - 1] == 1 && visited[row][m - 1] == 0) {
//                dfs(row, m - 1, tempRow, tempCol, visited, grid);
//            }
//        }
//
//        // Node that doesn't visit from the boundary
//        int count = 0;
//        for (int row = 1; row < n - 1; row++) {
//            for (int col = 1; col < m - 1; col++) {
//                if (grid[row][col] == 1 && visited[row][col] == 0) count++;
//            }
//        }
//
//        return count;
//    }
//
//    public void dfs(int row, int col, int[] tempRow, int[] tempCol, int[][] visited, int[][] grid) {
//        visited[row][col] = 1;
//        int n = grid.length;
//        int m = grid[0].length;
//
//        for (int i = 0; i < 4; i++) {
//            int n_row = row + tempRow[i];
//            int n_col = col + tempCol[i];
//            if (n_row >= 0 && n_row < n && n_col >= 0 && n_col < m && grid[n_row][n_col] == 1 && visited[n_row][n_col] == 0) {
//                dfs(n_row, n_col, tempRow, tempCol, visited, grid);
//            }
//        }
//    }
}