package TakeYouforward.Graph.GFG.Hard;
// Problem
/*
Alien Dictionary

A new alien language uses the English alphabet, but the order of letters is unknown. You are given a list of words[] from the alien language’s dictionary, where the words are claimed to be sorted lexicographically according to the language’s rules.

Your task is to determine the correct order of letters in this alien language based on the given words. If the order is valid, return a string containing the unique letters in lexicographically increasing order as per the new language's rules. If there are multiple valid orders, return any one of them.

However, if the given arrangement of words is inconsistent with any possible letter ordering, return an empty string ("").

A string a is lexicographically smaller than a string b if, at the first position where they differ, the character in a appears earlier in the alien language than the corresponding character in b. If all characters in the shorter word match the beginning of the longer word, the shorter word is considered smaller.

Note: Your implementation will be tested using a driver code. It will print true if your returned order correctly follows the alien language’s lexicographic rules; otherwise, it will print false.

Examples:

Input: words[] = ["baa", "abcd", "abca", "cab", "cad"]
Output: true
Explanation: A possible corrct order of letters in the alien dictionary is "bdac".
The pair "baa" and "abcd" suggests 'b' appears before 'a' in the alien dictionary.
The pair "abcd" and "abca" suggests 'd' appears before 'a' in the alien dictionary.
The pair "abca" and "cab" suggests 'a' appears before 'c' in the alien dictionary.
The pair "cab" and "cad" suggests 'b' appears before 'd' in the alien dictionary.
So, 'b' → 'd' → 'a' → 'c' is a valid ordering.
Input: words[] = ["caa", "aaa", "aab"]
Output: true
Explanation: A possible corrct order of letters in the alien dictionary is "cab".
The pair "caa" and "aaa" suggests 'c' appears before 'a'.
The pair "aaa" and "aab" suggests 'a' appear before 'b' in the alien dictionary.
So, 'c' → 'a' → 'b' is a valid ordering.
Input: words[] = ["ab", "cd", "ef", "ad"]
Output: ""
Explanation: No valid ordering of letters is possible.
The pair "ab" and "ef" suggests "a" appears before "e".
The pair "ef" and "ad" suggests "e" appears before "a", which contradicts the ordering rules.
Constraints:
1 ≤ words.length ≤ 500
1 ≤ words[i].length ≤ 100
words[i] consists only of lowercase English letters.
 */

import java.util.*;

public class P1AlienDictionary {
    public static void main(String[] args) {

    }

    // T(C) = O(N * len) + O(K + E)
    // where N is the number of words in the dictionary
    // ‘len’ is the length up to the index where the first inequality occurs
    // K = no. of nodes, and E = no. of edges.
    // S(C) = O(K) + O(K) + O(K) + O(K) == O(K) {K = number of nodes}
    public String findOrder(String[] words) {
        boolean[] exists = new boolean[26];
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                exists[word.charAt(i) - 'a'] = true;
            }
        }

        int V = 26;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            int len = Math.min(s1.length(), s2.length());
            boolean found = false;

            for (int ptr = 0; ptr < len; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    found = true;
                    break;
                }
            }

            // Edge Case 1
            if (!found && s1.length() > s2.length()) {
                return "";
            }
        }

        List<Integer> topo = topoSort(adj, exists);

        int countExists = 0;
        for (boolean exist : exists) {
            if (exist) countExists++;
        }

        // Edge Case 2
        // Cycle detected
        if (topo.size() != countExists) return "";

        StringBuilder ans = new StringBuilder();
        for (int node : topo) {
            ans.append((char) (node + 'a'));
        }

        return ans.toString();
    }

    public ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj, boolean[] exists) {
        int[] indegree = new int[26];
        for (ArrayList<Integer> list : adj) {
            for (int num : list) {
                indegree[num]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (indegree[i] == 0 && exists[i]) {
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
                if (indegree[neighbour] == 0 && exists[neighbour]) queue.add(neighbour);
            }
        }

        return result;
    }
}
