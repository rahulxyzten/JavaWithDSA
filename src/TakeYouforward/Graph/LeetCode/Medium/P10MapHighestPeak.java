package TakeYouforward.Graph.LeetCode.Medium;
// Problem (same as 01 Matrix problem)
/*
1765. Map of Highest Peak

You are given an integer matrix isWater of size m x n that represents a map of land and water cells.

If isWater[i][j] == 0, cell (i, j) is a land cell.
If isWater[i][j] == 1, cell (i, j) is a water cell.
You must assign each cell a height in a way that follows these rules:

The height of each cell must be non-negative.
If the cell is a water cell, its height must be 0.
Any two adjacent cells must have an absolute height difference of at most 1. A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter (i.e., their sides are touching).
Find an assignment of heights such that the maximum height in the matrix is maximized.

Return an integer matrix height of size m x n where height[i][j] is cell (i, j)'s height. If there are multiple solutions, return any of them.

Example 1:



Input: isWater = [[0,1],[0,0]]
Output: [[1,0],[2,1]]
Explanation: The image shows the assigned heights of each cell.
The blue cell is the water cell, and the green cells are the land cells.
Example 2:



Input: isWater = [[0,0,1],[1,0,0],[0,0,0]]
Output: [[1,1,0],[0,1,1],[1,2,2]]
Explanation: A height of 2 is the maximum possible height of any assignment.
Any height assignment that has a maximum height of 2 while still meeting the rules will also be accepted.


Constraints:

m == isWater.length
n == isWater[i].length
1 <= m, n <= 1000
isWater[i][j] is 0 or 1.
There is at least one water cell.


Note: This question is the same as 542: https://leetcode.com/problems/01-matrix/
 */

import java.util.LinkedList;
import java.util.Queue;

class NodeM {
    int row, col, distance;

    public NodeM(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}

public class P10MapHighestPeak {
    public static void main(String[] args) {

    }

    // T(C) = O(n*m) + O((n*m)*4)
    // S(C) = O(n*m) + O(n*m) + O(n*m)
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        int[][] visited = new int[n][m];
        Queue<NodeM> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    queue.add(new NodeM(i, j, 0));
                    visited[i][j] = 1;
                }
            }
        }

        int[] tempRow = {-1, 0, 1, 0};
        int[] tempCol = {0, +1, 0, -1};
        int[][] result = new int[n][m];
        while (!queue.isEmpty()) {
            int row = queue.peek().row;
            int col = queue.peek().col;
            int distance = queue.peek().distance;
            result[row][col] = distance;
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int n_row = row + tempRow[i];
                int n_col = col + tempCol[i];
                if (n_row >= 0 && n_row < n && n_col >= 0 && n_col < m && visited[n_row][n_col] == 0) {
                    queue.add(new NodeM(n_row, n_col, distance + 1));
                    visited[n_row][n_col] = 1;
                }
            }
        }

        return result;
    }
}