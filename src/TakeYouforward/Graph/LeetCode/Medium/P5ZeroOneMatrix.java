package TakeYouforward.Graph.LeetCode.Medium;
// Problem
/*
542. 01 Matrix

Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two cells sharing a common edge is 1.

Example 1:


Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
Example 2:


Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]


Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 10^4
1 <= m * n <= 10^4
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.


Note: This question is the same as 1765: https://leetcode.com/problems/map-of-highest-peak/
 */

import java.util.*;

class Node {
    int row, col, distance;

    public Node(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}

public class P5ZeroOneMatrix {
    public static void main(String[] args) {

    }

    // T(C) = O(n*m) + O((n*m)*4)
    // S(C) = O(n*m) + O(n*m) + O(n*m)
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<Node> queue = new LinkedList<>();
        int[][] visited = new int[n][m];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (mat[row][col] == 0) {
                    queue.add(new Node(row, col, 0));
                    visited[row][col] = 1;
                }
            }
        }

        int[] tempRow = {-1, 0, +1, 0};
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
                    queue.add(new Node(n_row, n_col, distance + 1));
                    visited[n_row][n_col] = 1;
                }
            }
        }

        return result;
    }
}