package TakeYouforward.Graph.GFG.Medium;
// Problem
/*
Number of Distinct Islands

Given a boolean 2D matrix grid of size n * m. You have to find the number of distinct islands where a group of connected 1s (horizontally or vertically) forms an island. Two islands are considered to be distinct if and only if one island is not equal to another (not rotated or reflected).

Example 1:

Input:
grid[][] = [[1, 1, 0, 0, 0],
            [1, 1, 0, 0, 0],
            [0, 0, 0, 1, 1],
            [0, 0, 0, 1, 1]]
Output: 1
Explanation:
grid[][] = [[1, 1, 0, 0, 0],
            [1, 1, 0, 0, 0],
            [0, 0, 0, 1, 1],
            [0, 0, 0, 1, 1]]
Same colored islands are equal. We have 2 equal islands, so we have only 1 distinct island.

Example 2:

Input:
grid[][] = [[1, 1, 0, 1, 1],
            [1, 0, 0, 0, 0],
            [0, 0, 0, 0, 1],
            [1, 1, 0, 1, 1]]
Output: 3
Explanation:
grid[][] = [[1, 1, 0, 1, 1],
            [1, 0, 0, 0, 0],
            [0, 0, 0, 0, 1],
            [1, 1, 0, 1, 1]]
Same colored islands are equal.
We have 4 islands, but 2 of them
are equal, So we have 3 distinct islands.

Your Task: You don't need to read or print anything. Your task is to complete the function countDistinctIslands() which takes the grid as an input parameter and returns the total number of distinct islands.

Constraints:
1 ≤ n, m ≤ 500
grid[i][j] == 0 or grid[i][j] == 1
 */

import java.util.*;

//class Node {
//    int row, col;
//
//    public Node(int row, int col) {
//        this.row = row;
//        this.col = col;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Node)) return false;
//        Node other = (Node) o;
//        return this.row == other.row && this.col == other.col;
//    }
//
//    @Override
//    public int hashCode() {
//        return 31 * row + col;
//    }
//}


public class P1NumberDistinctIslands {
    public static void main(String[] args) {

    }

    // T(C) = O(n*m) + O(log(n*m)) {set insertion} + O((n*m)*4) == O(n*m)
    // S(C) = O(n*m) + O(n*m) + O(n*m) == O(n*m)
    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int[] tempRow = {-1, 0, 1, 0};
        int[] tempCol = {0, 1, 0, -1};
        // HashSet<List<Node>> result = new HashSet<>();
        // OK to use HashSet<List<Node>> — but Node must override equals() and hashCode()
        // List<Node> won't work by default because Node needs equals() and hashCode();
        // without them two identical Node objects are not equal.

        Set<List<String>> result = new HashSet<>();
        // List<String> works because String already implements equals() and hashCode(),
        // so identical lists compare equal.


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    List<String> shape = new ArrayList<>();
                    dfs(i, j, i, j, tempRow, tempCol, visited, grid, shape);
                    result.add(shape);
                }
            }
        }

        return result.size();
    }

    public void dfs(int row, int col, int b_row, int b_col, int[] tempRow, int[] tempCol, int[][] visited, int[][] grid, List<String> shape) {
        visited[row][col] = 1;
        shape.add((row - b_row) + "_" + (col - b_col));

        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < 4; i++) {
            int n_row = row + tempRow[i];
            int n_col = col + tempCol[i];
            if (n_row >= 0 && n_row < n && n_col >= 0 && n_col < m && grid[n_row][n_col] == 1 && visited[n_row][n_col] == 0) {
                dfs(n_row, n_col, b_row, b_col, tempRow, tempCol, visited, grid, shape);
            }
        }
    }
}