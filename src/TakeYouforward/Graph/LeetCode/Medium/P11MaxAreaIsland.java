package TakeYouforward.Graph.LeetCode.Medium;
// Problem
/*
695. Max Area of Island

You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.



Example 1:


Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] is either 0 or 1.
 */

import java.util.LinkedList;
import java.util.Queue;

class PairA {
    int row, col;

    public PairA(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class P11MaxAreaIsland {
    public static void main(String[] args) {

    }


    /* Using DFS */
    // T(C) = O(N^2) + O(N^2 * 4) {DFS} = O(N*M)
    // S(C) = O(N^2) + O(N^2) = O(N*M)
    /* Using BFS */
    // T(C) = O(N^2) + O(N^2 * 9) {BFS} = O(N*M)
    // S(C) = O(N^2) + O(N^2) = O(N*M)
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] visited = new int[n][m];
        int[] tempRow = {-1, 0, 1, 0};
        int[] tempCol = {0, 1, 0, -1};

        int maxArea = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 1 && visited[row][col] == 0) {
                    // int area = bfs(row, col, visited, grid);
                    int area = dfs(row, col, new int[]{0}, tempRow, tempCol, visited, grid);
                    if (area > maxArea) maxArea = area;
                }
            }
        }

        return maxArea;
    }

    public int dfs(int row, int col, int[] count, int[] tempRow, int[] tempCol, int[][] visited, int[][] grid) {
        visited[row][col] = 1;
        count[0]++;

        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < 4; i++) {
            int n_row = row + tempRow[i];
            int n_col = col + tempCol[i];

            if (n_row >= 0 && n_row < n && n_col >= 0 && n_col < m && grid[n_row][n_col] == 1 && visited[n_row][n_col] == 0) {
                dfs(n_row, n_col, count, tempRow, tempCol, visited, grid);
            }
        }

        return count[0];
    }

//    public int bfs(int ro, int co, int[][] visited, int[][] grid) {
//        int count = 0;
//        Queue<PairA> queue = new LinkedList<>();
//
//        queue.add(new PairA(ro, co));
//        count++;
//        visited[ro][co] = 1;
//
//        int n = grid.length;
//        int m = grid[0].length;
//
//        while (!queue.isEmpty()) {
//            int row = queue.peek().row;
//            int col = queue.peek().col;
//            queue.poll();
//
//            // traverse in the neighbours and mark them if it's a land
//            for (int tempRow = -1; tempRow <= 1; tempRow++) {
//                for (int tempCol = -1; tempCol <= 1; tempCol++) {
//                    if ((tempRow == tempCol) || (tempRow == -1 && tempCol == 1) || (tempRow == 1 && tempCol == -1)) {
//                        continue;
//                    }
//                    int n_row = row + tempRow;
//                    int n_col = col + tempCol;
//                    if (n_row >= 0 && n_row < n && n_col >= 0 && n_col < m && grid[n_row][n_col] == 1 && visited[n_row][n_col] == 0) {
//                        visited[n_row][n_col] = 1;
//                        queue.add(new PairA(n_row, n_col));
//                        count++;
//                    }
//                }
//            }
//        }
//
//        return count;
//    }
}
