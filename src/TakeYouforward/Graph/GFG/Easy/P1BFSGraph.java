package TakeYouforward.Graph.GFG.Easy;
// Problem
/*
BFS of graph

Given a connected undirected graph containing V vertices, represented by a 2-d adjacency list adj[][], where each adj[i] represents the list of vertices connected to vertex i. Perform a Breadth First Search (BFS) traversal starting from vertex 0, visiting vertices from left to right according to the given adjacency list, and return a list containing the BFS traversal of the graph.

Note: Do traverse in the same order as they are in the given adjacency list.

Examples:

Input: adj[][] = [[2, 3, 1], [0], [0, 4], [0], [2]]

Output: [0, 2, 3, 1, 4]
Explanation: Starting from 0, the BFS traversal will follow these steps:
Visit 0 → Output: 0
Visit 2 (first neighbor of 0) → Output: 0, 2
Visit 3 (next neighbor of 0) → Output: 0, 2, 3
Visit 1 (next neighbor of 0) → Output: 0, 2, 3, 1
Visit 4 (neighbor of 2) → Final Output: 0, 2, 3, 1, 4
Input: adj[][] = [[1, 2], [0, 2], [0, 1, 3, 4], [2], [2]]

Output: [0, 1, 2, 3, 4]
Explanation: Starting from 0, the BFS traversal proceeds as follows:
Visit 0 → Output: 0
Visit 1 (the first neighbor of 0) → Output: 0, 1
Visit 2 (the next neighbor of 0) → Output: 0, 1, 2
Visit 3 (the first neighbor of 2 that hasn't been visited yet) → Output: 0, 1, 2, 3
Visit 4 (the next neighbor of 2) → Final Output: 0, 1, 2, 3, 4
Constraints:
1 ≤ V = adj.size() ≤ 10^4
0 ≤ adj[i][j] ≤ 10^4
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P1BFSGraph {
    public static void main(String[] args) {

    }

    // T(C) = O(N) + O(2E)
    // S(C) = O(3N) = O(N)
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfsResult = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[adj.size()];
        // Given -> Graph is 0 based indexing

        queue.add(0);
        visited[0] = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            bfsResult.add(node);

            ArrayList<Integer> neighbours = adj.get(node);
            for (int neighbour : neighbours) {
                if (visited[neighbour] == 0) {
                    queue.add(neighbour);
                    visited[neighbour] = 1;
                }
            }
        }

        return bfsResult;
    }
}