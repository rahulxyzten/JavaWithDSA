package TakeYouforward.BinaryTree.CodeStudio.Hard;
// Problem (GFG)
/*
 Burning Tree

Given the root of a binary tree and a target node, determine the minimum time required to burn the entire tree if the target node is set on fire. In one second, the fire spreads from a node to its left child, right child, and parent.

Note: The tree contains unique values.

Examples :

Input: root = [1, 2, 3, 4, 5, 6, 7], target = 2

Output: 3
Explanation: Initially 2 is set to fire at 0 sec
At 1 sec: Nodes 4, 5, 1 catches fire.
At 2 sec: Node 3 catches fire.
At 3 sec: Nodes 6, 7 catches fire.
It takes 3s to burn the complete tree.
Input: root = [1, 2, 3, 4, 5, N, 7, 8, N, N, 10], target = 10

Output: 5
Explanation: Initially 10 is set to fire at 0 sec
At 1 sec: Node 5 catches fire.
At 2 sec: Node 2 catches fire.
At 3 sec: Nodes 1 and 4 catches fire.
At 4 sec: Node 3 and 8 catches fire.
At 5 sec: Node 7 catches fire.
It takes 5s to burn the complete tree.
Constraints:
1 ≤ number of nodes ≤ 10^5
1 ≤ node->data ≤ 10^5
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class P2BurningTree {
    public static void main(String[] args) {

    }

    public static void markParents(HashMap<Node, Node> parent_track, Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.left != null) {
                parent_track.put(current.left, current);
                queue.offer(current.left);
            }
            if (current.right != null) {
                parent_track.put(current.right, current);
                queue.offer(current.right);
            }
        }
    }

    // Optimal solution
    // 863. All Nodes Distance K in Binary Tree (Logic)
    // T(C) = O(N) + O(N) + O(N) = O(N)
    // S(C) = O(N) + O(N) + O(N) + O(N) + O(N) = O(N)
    public int minTime(Node root, int target) {
        HashMap<Node, Node> parent_track = new HashMap<>();
        markParents(parent_track, root);

        HashMap<Node, Boolean> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Node start = findStart(root, target);
        queue.offer(start);
        visited.put(start, true);
        int count = 0;

        while (!queue.isEmpty()) {
            count++;

            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                if (current.left != null) {
                    if (!visited.containsKey(current.left)) {
                        queue.add(current.left);
                        visited.put(current.left, true);
                    }
                }

                if (current.right != null) {
                    if (!visited.containsKey(current.right)) {
                        queue.add(current.right);
                        visited.put(current.right, true);
                    }
                }

                if (parent_track.get(current) != null) {
                    if (!visited.containsKey(parent_track.get(current))) {
                        queue.add(parent_track.get(current));
                        visited.put(parent_track.get(current), true);
                    }
                }
            }
        }

        return count - 1;
    }

    // Code of how to find the Node if the value is given
    public static Node findStart(Node root, int start) {
        if (root == null) return null;

        if (root.data == start) return root;

        Node leftResult = findStart(root.left, start);
        if (leftResult != null) return leftResult;

        return findStart(root.right, start);
    }
}