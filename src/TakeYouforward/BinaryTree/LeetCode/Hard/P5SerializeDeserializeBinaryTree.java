package TakeYouforward.BinaryTree.LeetCode.Hard;
// Problem
/*
297. Serialize and Deserialize Binary Tree

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.



Example 1:


Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]
Example 2:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000
 */

import java.util.LinkedList;
import java.util.Queue;

public class P5SerializeDeserializeBinaryTree {
    public static void main(String[] args) {

    }

    // Encodes a tree to a single string.
    // T(C) = O(N)
    // S(C) = O(N) + O(N) = O(N)
    public String serialize(TreeNode root) {
        if (root == null) return "";

        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.append("# ");
            } else {
                result.append(node.val + " ");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return result.toString();
    }

    // Decodes your encoded data to tree.
    // T(C) = O(N) + O(N) = O(N)
    // S(C) = O(N) + O(N) O(N) = O(N)
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        if (data.charAt(0) == '#') return null;

        String[] values = data.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < values.length) {
            TreeNode node = queue.poll();

            if (!values[i].equals("#")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(values[i]));
                node.left = leftNode;
                queue.offer(leftNode);
            }
            i++;

            if (!values[i].equals("#")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(values[i]));
                node.right = rightNode;
                queue.offer(rightNode);
            }
            i++;
        }

        return root;
    }
}