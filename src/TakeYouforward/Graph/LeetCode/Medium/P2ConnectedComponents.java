package TakeYouforward.Graph.LeetCode.Medium;
// Problem
/*
Connected Components
https://takeuforward.org/data-structure/connected-components

Problem Statement: Given an undirected Graph consisting of V vertices numbered from 0 to V-1 and E edges. The ith edge is represented by [ai,bi], denoting a edge between vertex ai and bi. We say two vertices u and v belong to a same component if there is a path from u to v or v to u. Find the number of connected components in the graph.

A connected component is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.

Examples:
Input: V=4, edges=[[0,1],[1,2]]
Output: 2
Explanation: Vertices {0,1,2} forms the first component and vertex 3 forms the second component.

Input:V = 7, edges = [[0, 1], [1, 2], [2, 3], [4, 5]]
Output: 3
Explanation: The edges [0, 1], [1, 2], [2, 3] form a connected component with vertices {0, 1, 2, 3}
The edge [4, 5] forms another connected component with vertices {4, 5}.
Therefore, the graph has 3 connected components: {0, 1, 2, 3}, {4, 5}, and the isolated vertices {6}.
 */

import java.util.ArrayList;
import java.util.List;

public class P2ConnectedComponents {
    public static void main(String[] args) {

    }

    // T(C) = O(N) + O(2E) {creation of adj} + O(N) + O(N + 2E)
    // S(C) = O(N) + O(N) + O(N)
    public int findNumberOfComponent(int V, List<List<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // 0 - based indexing
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }
//         int[][] edges
//        for (int[] e : edges) {
//            adj.get(e[0]).add(e[1]);
//            adj.get(e[1]).add(e[0]);
//        }

        int[] visited = new int[V];
        int components = 0;
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                components++;
                dfs(i, visited, adj);
            }
        }

        return components;
    }

    public void dfs(int node, int[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = 1;
        ArrayList<Integer> neighbours = adj.get(node);
        for (int neighbour : neighbours) {
            if (visited[neighbour] == 0) {
                dfs(neighbour, visited, adj);
            }
        }
    }
}