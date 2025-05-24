package TakeYouforward.BinaryTree.LeetCode.Easy;
//Problem
/*
110. Balanced Binary Tree

Given a binary tree, determine if it is
height-balanced

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:


Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:

Input: root = []
Output: true


Constraints:

The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104
 */

public class P5BalancedBinaryTree {
    public static void main(String[] args) {

    }

    //Optimal Solution
    //T(C) = O(N)
    //S(C) = O(k) {Recursive stack}
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        return defHeight(root) != -1;
    }

    public static int defHeight(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = defHeight(root.left);
        if (leftHeight == -1) return -1;

        int rightHeight = defHeight(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }


    //Brute Force Approach
    //T(C) = O(N^2)
    //S(C) = O(K) {Recursive stack}
//    public boolean isBalanced(TreeNode root) {
//        if (root == null) return true;
//
//        int leftHeight = getHeight(root.left);
//        int rightHeight = getHeight(root.right);
//
//        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
//    }
//
//    public int getHeight(TreeNode root) {
//        if (root == null) return 0;
//        int left = getHeight(root.left);
//        int right = getHeight(root.right);
//
//        return 1 + Math.max(left, right);
//    }
}
