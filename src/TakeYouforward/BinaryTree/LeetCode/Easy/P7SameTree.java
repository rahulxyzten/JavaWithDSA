package TakeYouforward.BinaryTree.LeetCode.Easy;
//Check if two trees are identical
//Problem
/*
100. Same Tree

Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.



Example 1:


Input: p = [1,2,3], q = [1,2,3]
Output: true
Example 2:


Input: p = [1,2], q = [1,null,2]
Output: false
Example 3:


Input: p = [1,2,1], q = [1,1,2]
Output: false


Constraints:

The number of nodes in both trees is in the range [0, 100].
-104 <= Node.val <= 104
 */

public class P7SameTree {
    public static void main(String[] args) {

    }

    //T(C) = O(N+M) where N is the number of nodes in the first Binary Tree and M is the number of nodes in the second Binary Tree.
    //S(C) = O(1)
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        //If both nodes are NULL

        if (p == null || q == null) return false;
        // If only one of the nodes is NULL

        //Using recursive preOrder traversal
        return (p.val == q.val) && isSameTree(p.left , q.left) && isSameTree(p.right, q.right);
    }
}
