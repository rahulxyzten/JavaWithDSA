package TakeYouforward.Graph.Questions;

import java.util.ArrayList;
import java.util.Scanner;

public class P1GraphRepresentation {

    // Using Adjacency Matrix
    // S(C) = O(N*N) = O(N^2)
//    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        // number of nodes
//        int n = s.nextInt();
//        // number of edges
//        int m = s.nextInt();
//
//        // Adjacency matrix
//        int[][] adj = new int[n + 1][n + 1];
//
//        // Creating Graph
//        for (int i = 0; i < m; i++) {
//            int u = s.nextInt();
//            int v = s.nextInt();
//            adj[u][v] = 1;
//            // remove this below line in case of directed graph.
//            // Directed graph: edge from u to v
//            adj[v][u] = 1;
//        }
//    }

    // Using Adjacency Lists
    // S(C) = O(2M) {Undirected graph}
    // S(C) = O(M) {Directed graph}
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // number of nodes
        int n = s.nextInt();
        // number of edges
        int m = s.nextInt();

        // Adjacency Lists
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Creating Graph
        for (int i = 0; i < m; i++) {
            int u = s.nextInt();
            int v = s.nextInt();
            adj.get(u).add(v);
            // remove this below line in case of directed graph.
            // Directed graph: edge from u to v
            adj.get(v).add(u);
        }

        // Printing Graph
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.println(i + " " + adj.get(i).get(j));
            }
        }
    }
}