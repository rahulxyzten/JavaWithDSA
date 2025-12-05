package TakeYouforward.BinaryTree.LeetCode.Medium;
//Problem
/*
103. Binary Tree Zigzag Level Order Traversal

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
 */

import java.util.*;

public class P2BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {

    }

    // T(C) = O(N)
    // S(C) = O(N)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Integer[] temp = new Integer[levelSize];
            // Here the data type of array

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                int index = leftToRight ? i : levelSize - 1 - i;
                temp[index] = node.val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            leftToRight = !leftToRight;

            // Arrays.asList() takes O(1) => It creates a wrapper around the existing array (no iteration, copying)
            result.add(Arrays.asList(temp));
        }

        return result;
    }


    //T(C) = O(N) + O(N) {Collections.reverse} = O(N)
    //S(C) = O(N)
//    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        List<List<Integer>> result = new ArrayList<>();
//        if (root == null) return result;
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        boolean leftToRight = true;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            List<Integer> row = new ArrayList<>();
//            for (int i = 0; i < size; i++) {
//                TreeNode node = queue.poll();
//
//                row.add(node.val);
//
//                if (node.left != null) queue.offer(node.left);
//                if (node.right != null) queue.offer(node.right);
//            }
//            if (!leftToRight) Collections.reverse(row);
//            result.add(row);
//
//            leftToRight = !leftToRight;
//        }
//        return result;
//    }
}
