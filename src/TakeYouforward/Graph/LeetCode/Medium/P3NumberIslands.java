package TakeYouforward.Graph.LeetCode.Medium;
// Problem (LeetCode)
/*
200. Number of Islands

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.


Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
 */

// Problem (GFG)
/*
Find the number of islands

Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid) consisting of 'W's (Water) and 'L's (Land). Find the number of islands.

Note: An island is either surrounded by water or the boundary of a grid and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.

Examples:

Input: grid[][] = [['L', 'L', 'W', 'W', 'W'],
                ['W', 'L', 'W', 'W', 'L'],
                ['L', 'W', 'W', 'L', 'L'],
                ['W', 'W', 'W', 'W', 'W'],
                ['L', 'W', 'L', 'L', 'W']]
Output: 4
Explanation:
The image below shows all the 4 islands in the grid.

Input: grid[][] = [['W', 'L', 'L', 'L', 'W', 'W', 'W'],
                ['W', 'W', 'L', 'L', 'W', 'L', 'W']]
Output: 2
Expanation:
The image below shows 2 islands in the grid.

Constraints:
1 ≤ n, m ≤ 500
grid[i][j] = {'L', 'W'}
 */

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row, col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class P3NumberIslands {
    public static void main(String[] args) {

    }

    // T(C) = O(N^2) + O(N^2) = O(N*M)
    // S(C) = O(N^2) + O(N^2 * 9) {BFS} = O(N*M)
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] visited = new int[n][m];

        int count = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == '1' && visited[row][col] == 0) {
                    count++;
                    bfs(row, col, visited, grid);
                }
            }
        }

        return count;
    }

    public void bfs(int ro, int co, int[][] visited, char[][] grid) {
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(ro, co));
        visited[ro][co] = 1;

        int n = grid.length;
        int m = grid[0].length;

        while (!queue.isEmpty()) {
            int row = queue.peek().row;
            int col = queue.peek().col;
            queue.poll();

            // traverse in the neighbours and mark them if it's a land
            for (int tempRow = -1; tempRow <= 1; tempRow++) {
                for (int tempCol = -1; tempCol <= 1; tempCol++) {
                    // Remove this if condition in GFG version => 8 direction need to check
                    // In LeetCode version => 4 direction need to check to add this if condition
                    if ((tempRow == tempCol) || (tempRow == -1 && tempCol == 1) || (tempRow == 1 && tempCol == -1)) {
                        continue;
                    }
                    int n_row = row + tempRow;
                    int n_col = col + tempCol;
                    if (n_row >= 0 && n_row < n && n_col >= 0 && n_col < m && grid[n_row][n_col] == '1' && visited[n_row][n_col] == 0) {
                        visited[n_row][n_col] = 1;
                        queue.add(new Pair(n_row, n_col));
                    }
                }
            }
        }
    }
}