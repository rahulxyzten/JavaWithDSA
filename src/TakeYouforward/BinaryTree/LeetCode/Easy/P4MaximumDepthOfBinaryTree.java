package TakeYouforward.BinaryTree.LeetCode.Easy;
//Maximum Depth of Binary Tree
//Height of a Binary Tree
//Problem
/*
104. Maximum Depth of Binary Tree

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2


Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100
 */

import java.util.LinkedList;
import java.util.Queue;

public class P4MaximumDepthOfBinaryTree {
    public static void main(String[] args) {

    }

    //Using Recursion
    //T(C) = O(N)
    //S(C) = O(n)   (recursive stack)
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right);
    }


    //Using Level Order Traversal
    //T(C) = O(N)
    //S(C) = O(n)
//    public int maxDepth(TreeNode root) {
//        if (root == null) return 0;
//        Queue<TreeNode> q = new LinkedList<>();
//        q.add(root);
//        int level = 0;
//        while (!q.isEmpty()) {
//            int size = q.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode front = q.poll();
//                if (front.left != null) q.add(front.left);
//                if (front.right != null) q.add(front.right);
//            }
//            level++;
//        }
//        return level;
//    }
}
