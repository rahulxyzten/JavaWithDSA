package TakeYouforward.Graph.LeetCode.Easy;
// Problem
/*
733. Flood Fill

You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value of the image. You are also given three integers sr, sc, and color. Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill:

Begin with the starting pixel and change its color to color.
Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel, either horizontally or vertically) and shares the same color as the starting pixel.
Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if it matches the original color of the starting pixel.
The process stops when there are no more adjacent pixels of the original color to update.
Return the modified image after performing the flood fill.



Example 1:

Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2

Output: [[2,2,2],[2,2,0],[2,0,1]]

Explanation:



From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.

Note the bottom corner is not colored 2, because it is not horizontally or vertically connected to the starting pixel.

Example 2:

Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0

Output: [[0,0,0],[0,0,0]]

Explanation:

The starting pixel is already colored with 0, which is the same as the target color. Therefore, no changes are made to the image.



Constraints:

m == image.length
n == image[i].length
1 <= m, n <= 50
0 <= image[i][j], color < 2^16
0 <= sr < m
0 <= sc < n
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

public class P1FloodFill {
    public static void main(String[] args) {

    }

    // T(C) = O((n X m) X 4)
    // S(C) = O(n X m) + O(n X m)
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int initialColor = image[sr][sc];
        int[][] visited = new int[n][m];
        bfs(sr, sc, initialColor, color, visited, image);
        return image;
    }

    public void bfs(int ro, int co, int initialColor, int color, int[][] visited, int[][] image) {
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(ro, co));
        visited[ro][co] = 1;
        image[ro][co] = color;

        int n = image.length;
        int m = image[0].length;

        while (!queue.isEmpty()) {
            int row = queue.peek().row;
            int col = queue.peek().col;
            queue.poll();

            for (int tempRow = -1; tempRow <= 1; tempRow++) {
                for (int tempCol = -1; tempCol <= 1; tempCol++) {
                    if ((tempRow == tempCol) || (tempRow == -1 && tempCol == 1) || (tempRow == 1 && tempCol == -1)) {
                        continue;
                    }

                    int n_row = row + tempRow;
                    int n_col = col + tempCol;
                    if (n_row >= 0 && n_row < n && n_col >= 0 && n_col < m && image[n_row][n_col] == initialColor && visited[n_row][n_col] == 0) {
                        visited[n_row][n_col] = 1;
                        image[n_row][n_col] = color;
                        queue.add(new Pair(n_row, n_col));
                    }
                }
            }

//            int[] tempRow = {-1, 0, +1, 0};
//            int[] tempCol = {0, +1, 0, -1};
//
//            for (int i = 0; i < 4; i++) {
//                int n_row = row + tempRow[i];
//                int n_col = col + tempCol[i];
//                if (n_row >= 0 && n_row < n && n_col >= 0 && n_col < m && image[n_row][n_col] == initialColor && visited[n_row][n_col] == 0) {
//                    visited[n_row][n_col] = 1;
//                    image[n_row][n_col] = color;
//                    queue.add(new Pair(n_row, n_col));
//                }
//            }
        }
    }
}