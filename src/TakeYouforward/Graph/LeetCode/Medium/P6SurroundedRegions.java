package TakeYouforward.Graph.LeetCode.Medium;
// Problem
/*
130. Surrounded Regions

You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

Connect: A cell is connected to adjacent cells horizontally or vertically.
Region: To form a region connect every 'O' cell.
Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.

Example 1:

Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]

Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]

Explanation:


In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.

Example 2:

Input: board = [["X"]]

Output: [["X"]]



Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.
 */

public class P6SurroundedRegions {
    public static void main(String[] args) {

    }

    // T(C) = O(m) + O(n) + O(n*m) + O((n*m)*4) == O(n*m)
    // S(C) = O(n*m) + O(n*m) == O(n*m)
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[] tempRow = {-1, 0, 1, 0};
        int[] tempCol = {0, 1, 0, -1};
        int[][] visited = new int[n][m];

        // Top Edge and Bottom Edge
        for (int col = 0; col < m; col++) {
            // Top Edge
            if (board[0][col] == 'O' && visited[0][col] == 0) {
                dfs(0, col, tempRow, tempCol, visited, board);
            }

            // Bottom Edge
            if (board[n - 1][col] == 'O' && visited[n - 1][col] == 0) {
                dfs(n - 1, col, tempRow, tempCol, visited, board);
            }
        }

        // Left Edge and Right Edge
        for (int row = 1; row < n - 1; row++) {
            // Left Edge
            if (board[row][0] == 'O' && visited[row][0] == 0) {
                dfs(row, 0, tempRow, tempCol, visited, board);
            }

            // Right Edge
            if (board[row][m - 1] == 'O' && visited[row][m - 1] == 0) {
                dfs(row, m - 1, tempRow, tempCol, visited, board);
            }
        }

        // Node that doesn't visit from the boundary
        for (int row = 1; row < n - 1; row++) {
            for (int col = 1; col < m - 1; col++) {
                if (board[row][col] == 'O' && visited[row][col] == 0) board[row][col] = 'X';
            }
        }
    }

    public void dfs(int row, int col, int[] tempRow, int[] tempCol, int[][] visited, char[][] board) {
        visited[row][col] = 1;
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < 4; i++) {
            int n_row = row + tempRow[i];
            int n_col = col + tempCol[i];
            if (n_row >= 0 && n_row < n && n_col >= 0 && n_col < m && board[n_row][n_col] == 'O' && visited[n_row][n_col] == 0) {
                dfs(n_row, n_col, tempRow, tempCol, visited, board);
            }
        }
    }

}

/*
        // Top Edge
        for (int col = 0; col < m; col++) {
        if (board[0][col] == 'O' && visited[0][col] == 0) {
        dfs(0, col, tempRow, tempCol, visited, board);
        }
        }

        // Left Edge
        for (int row = 1; row < n; row++) {
        if (board[row][0] == 'O' && visited[row][0] == 0) {
        dfs(row, 0, tempRow, tempCol, visited, board);
        }
        }

        // Bottom Edge
        for (int col = 1; col < m; col++) {
        if (board[n - 1][col] == 'O' && visited[n - 1][col] == 0) {
        dfs(n - 1, col, tempRow, tempCol, visited, board);
        }
        }

        // Right Edge
        for (int row = 1; row < n - 1; row++) {
        if (board[row][m - 1] == 'O' && visited[row][m - 1] == 0) {
        dfs(row, m - 1, tempRow, tempCol, visited, board);
        }
        }
 */