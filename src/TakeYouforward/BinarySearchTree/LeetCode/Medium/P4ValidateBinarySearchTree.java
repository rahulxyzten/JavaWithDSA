package TakeYouforward.BinarySearchTree.LeetCode.Medium;
// Problem
/*
98. Validate Binary Search Tree

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys strictly less than the node's key.
The right subtree of a node contains only nodes with keys strictly greater than the node's key.
Both the left and right subtrees must also be binary search trees.


Example 1:


Input: root = [2,1,3]
Output: true
Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.


Constraints:

The number of nodes in the tree is in the range [1, 10^4].
-2^31 <= Node.val <= 2^31 - 1
 */

public class P4ValidateBinarySearchTree {
    public static void main(String[] args) {

    }

    // Optimal Solution (Using Range Concept)
    // T(C) = O(N)
    // S(C) = O(1), O(N) {Auxiliary space -> recursive stack)
    public boolean isValidBST(TreeNode root) {
        return solve(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean solve(TreeNode root, long minRange, long maxRange) {
        if (root == null) return true;
        if (root.val >= maxRange || root.val <= minRange) return false;

        return solve(root.left, minRange, root.val) && solve(root.right, root.val, maxRange);
    }
}
