package TakeYouforward.BinaryTree.LeetCode.Easy;
//Problem
/*
543. Diameter of Binary Tree

Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.



Example 1:


Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input: root = [1,2]
Output: 1


Constraints:

The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100
 */

public class P6DiameterOfBinaryTree {
    int diameter = 0;

    public static void main(String[] args) {

    }

    //Optimal Solution
    //T(C) = O(n)
    //S(C) = O(n) {Recursive Stack}
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
//        diameter[0] = 0;
        getHeight(root, diameter);
        return diameter[0];
    }

    public int getHeight(TreeNode root, int[] diameter) {
        if (root == null) return 0;
        int left = getHeight(root.left, diameter);
        int right = getHeight(root.right, diameter);

        diameter[0] = Math.max(diameter[0], left + right);

        return 1 + Math.max(left, right);
    }


    //Optimal Solution (using global variable)
    //T(C) = O(n)
    //S(C) = O(n) {Recursive Stack}
//    public int diameterOfBinaryTree(TreeNode root) {
//        getHeight(root);
//        return diameter;
//    }
//
//    public int getHeight(TreeNode root) {
//        if (root == null) return 0;
//        int left = getHeight(root.left);
//        int right = getHeight(root.right);
//
//        diameter = Math.max(diameter, left + right);
//
//        return 1 + Math.max(left, right);
//    }

    //Brute Force Approach
    //T(C) = O(n^2)
    //S(C) = O(k) {Recursive Stack}
//    public int diameterOfBinaryTree(TreeNode root) {
//        if (root == null)
//            return 0;
//
//        int lh = getHeight(root.left);
//        int rh = getHeight(root.right);
//
//        diameter = Math.max(diameter, lh + rh);
//
//        diameterOfBinaryTree(root.left);
//        diameterOfBinaryTree(root.right);
//
//        return diameter;
//    }
//
//    public int getHeight(TreeNode root) {
//        if (root == null)
//            return 0;
//        int left = getHeight(root.left);
//        int right = getHeight(root.right);
//
//        return 1 + Math.max(left, right);
//    }
}
