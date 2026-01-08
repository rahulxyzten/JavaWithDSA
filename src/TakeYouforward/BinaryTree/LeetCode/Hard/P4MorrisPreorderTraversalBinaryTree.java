package TakeYouforward.BinaryTree.LeetCode.Hard;
// Problem
/*
144. Binary Tree Preorder Traversal

Given the root of a binary tree, return the preorder traversal of its nodes' values.

Example 1:

Input: root = [1,null,2,3]

Output: [1,2,3]

Explanation:



Example 2:

Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

Output: [1,2,4,5,6,7,3,8,9]

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

public class P4MorrisPreorderTraversalBinaryTree {
    public static void main(String[] args) {

    }

    // Morris Preorder Traversal of a Binary Tree
    // T(C) = O(N) + O(N) = O(N)
    // S(C) = O(1)
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                preorder.add(curr.val);
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
                    preorder.add(curr.val);
                    curr = curr.left;
                } else { // (temp.right == curr) Remove the thread
                    temp.right = null;
                    curr = curr.right;
                }
            }
        }

        return preorder;
    }
}
