package TakeYouforward.BinaryTree.LeetCode.Medium;
// Problem
/*
863. All Nodes Distance K in Binary Tree

Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

You can return the answer in any order.



Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
Example 2:

Input: root = [1], target = 1, k = 3
Output: []


Constraints:

The number of nodes in the tree is in the range [1, 500].
0 <= Node.val <= 500
All the values Node.val are unique.
target is the value of one of the nodes in the tree.
0 <= k <= 1000
 */

import java.util.*;

public class P6AllNodesDistanceKInBinaryTree {
    public static void main(String[] args) {

    }

    public void markParents(HashMap<TreeNode, TreeNode> parent_track, TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
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

    // Optimal Solution
    // T(C) = O(N) + O(N) + O(N) = O(N)
    // S(C) = O(N) + O(N) + O(N) + O(N) = O(N)
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parent_track = new HashMap<>();
        markParents(parent_track, root);

        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.put(target, true);
        int curr_level = 0;

        while (!queue.isEmpty()) {
            if (curr_level == k) break;
            int levelSize = queue.size();

            curr_level++;
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
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

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }

        return result;
    }
}
