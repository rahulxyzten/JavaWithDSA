package TakeYouforward.BinarySearchTree.LeetCode.Medium;
// Problem
/*
230. Kth Smallest Element in a BST

Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Example 1:


Input: root = [3,1,4,null,2], k = 1
Output: 1
Example 2:


Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3


Constraints:

The number of nodes in the tree is n.
1 <= k <= n <= 10^4
0 <= Node.val <= 10^4


Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
 */

import java.util.ArrayList;
import java.util.List;

public class P3KthSmallestElementBST {
    public static void main(String[] args) {

    }

    // Optimal Solution
    // Morris Inorder Traversal of a Binary Tree
    // T(C) = O(N) + O(N) = O(N)
    // S(C) = O(1)
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                k--;
                if (k == 0) return curr.val;
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
                    k--;
                    if (k == 0) return curr.val;
                    curr = curr.right;
                }
            }
        }

        return 0;
    }


    // Brute Force Approach
    // T(C) = O(N) + O(NlogN)
    // S(C) = O(N) + O(N) {Recursive Stack}
//    public int kthSmallest(TreeNode root, int k) {
//        List<Integer> ls = new ArrayList<>();
//        preorder(root, ls);
//        ls.sort((a, b) -> a - b);
//
//        // kth_largest
//        // ls.get(ls.size() - k);
//
//        // kth_smallest
//        return ls.get(k - 1);
//    }
//
//    public static void preorder(TreeNode root, List<Integer> ls) {
//        if (root == null) return;
//        ls.add(root.val);
//        preorder(root.left, ls);
//        preorder(root.right, ls);
//    }

}