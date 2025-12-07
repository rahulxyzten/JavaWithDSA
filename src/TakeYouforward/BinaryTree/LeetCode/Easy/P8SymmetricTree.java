package TakeYouforward.BinaryTree.LeetCode.Easy;
//Problem
/*
101. Symmetric Tree

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).



Example 1:


Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:


Input: root = [1,2,2,null,3,null,3]
Output: false


Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100


Follow up: Could you solve it both recursively and iteratively?
 */

public class P8SymmetricTree {
    public static void main(String[] args) {

    }

    // T(C) = O(N) {Total number of recursive calls}
    // S(C) = O(H) {Recursive stack}
    // Balanced tree: h=O(logn)
    // Skewed tree: h=O(n)
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        return checkSymmetric(root.left, root.right);
    }

    public static boolean checkSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        //if both the node are null

        if (node1 == null || node2 == null) return false;
        //if one of the node is null and another one is not null

        return (node1.val == node2.val) && checkSymmetric(node1.left, node2.right) && checkSymmetric(node1.right, node2.left);
    }
}
