package TakeYouforward.Graph.GFG.Medium;
// Problem
// Kahn's Algorithm | Topological Sort Algorithm (BFS)
/*
Topological Sort

Given a Directed Acyclic Graph (DAG) of V (0 to V-1) vertices and E edges represented as a 2D list of edges[][], where each entry edges[i] = [u, v] denotes a directed edge u -> v. Return the topological sort for the given graph.

Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u -> v, vertex u comes before v in the ordering.
Note: As there are multiple Topological orders possible, you may return any of them. If your returned Topological sort is correct then the output will be true else false.

Examples:

Input: V = 4, E = 3, edges[][] = [[3, 0], [1, 0], [2, 0]]

Output: true
Explanation: The output true denotes that the order is valid. Few valid Topological orders for the given graph are:
[3, 2, 1, 0]
[1, 2, 3, 0]
[2, 3, 1, 0]
Input: V = 6, E = 6, edges[][] = [[1, 3], [2, 3], [4, 1], [4, 0], [5, 0], [5, 2]]

Output: true
Explanation: The output true denotes that the order is valid. Few valid Topological orders for the graph are:
[4, 5, 0, 1, 2, 3]
[5, 2, 4, 0, 1, 3]
Constraints:
2  ≤  V  ≤  5 x 10^3
1  ≤  E = edges.size()  ≤  min[10^5, (V * (V - 1)) / 2]
0 ≤ edges[i][0], edges[i][1] < V
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P3KahnAlgorithm {
    public static void main(String[] args) {

    }

    // T(C) = O(N) + O(N) + O(N+E) == O(N+E)
    // S(C) == O(N)
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        int[] indegree = new int[V];
        for (ArrayList<Integer> list : adj) {
            for (int num : list) {
                indegree[num]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            ArrayList<Integer> neighbours = adj.get(node);
            for (int neighbour : neighbours) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) queue.add(neighbour);
            }
        }

        return result;
    }
}