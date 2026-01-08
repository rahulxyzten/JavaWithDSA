package TakeYouforward.BinaryTree.LeetCode.Hard;
// Problem
/*
94. Binary Tree Inorder Traversal

Given the root of a binary tree, return the inorder traversal of its nodes' values.



Example 1:

Input: root = [1,null,2,3]

Output: [1,3,2]

Explanation:



Example 2:

Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

Output: [4,2,6,5,7,1,3,9,8]

Explanation:



Example 3:

Input: root = []

Output: []

Example 4:

Input: root = [1]

Output: [1]



Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100


Follow up: Recursive solution is trivial, could you do it iteratively?
 */


import java.util.ArrayList;
import java.util.List;

public class P3MorrisInorderTraversalBinaryTree {
    public static void main(String[] args) {

    }

    // Morris Inorder Traversal of a Binary Tree
    // T(C) = O(N) + O(N) = O(N)
    // S(C) = O(1)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                inorder.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode temp = curr.left; // curr left node

                // Find the last right Node of left subtree
                while (temp.right != null && temp.right != curr) {
                    temp = temp.right;
                }

                // Create the thread
                if (temp.right == null) {
                    temp.right = curr;
                    curr = curr.left;
                } else { // (temp.right == curr) Remove the thread
                    temp.right = null;
                    inorder.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return inorder;
    }
}
