package TakeYouforward.Graph.LeetCode.Medium;
// Problem
/*
547. Number of Provinces

There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.



Example 1:


Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:


Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3


Constraints:

1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] is 1 or 0.
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i]
 */

import java.util.ArrayList;

public class P1NumberProvinces {
    public static void main(String[] args) {

    }

    // T(C) = O(N) + O(N^2) {creation of adj} + O(N) + O(N + 2E)
    // S(C) = O(N) + O(N) + O(N)
    // 1 - based indexing
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // There are n cities.
        // 1 based indexing
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // given n x n matrix isConnected
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    // 1 based indexing
                    adj.get(i + 1).add(j + 1);
                    adj.get(j + 1).add(i + 1);
                }
            }
        }

        // There are n cities.
        // 1 based indexing
        int[] visited = new int[n + 1];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0) {
                count++;
                dfs(i, visited, adj);
            }
        }

        return count;
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

    // 0 - based indexing
//    public int findCircleNum(int[][] isConnected) {
//        int n = isConnected.length;
//        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//
//        for (int i = 0; i < n; i++) {
//            adj.add(new ArrayList<>());
//        }
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (isConnected[i][j] == 1 && i != j) {
//                    adj.get(i).add(j);
//                    adj.get(j).add(i);
//                }
//            }
//        }
//
//        int[] visited = new int[n];
//        int count = 0;
//        for (int i = 0; i < n; i++) {
//            if (visited[i] == 0) {
//                count++;
//                dfs(i, visited, adj);
//            }
//        }
//
//        return count;
//    }
}
