package TakeYouforward.BinarySearchTree.LeetCode.Easy;
// Problem (Optimal Approach is of Hard Level)
/*
653. Two Sum IV - Input is a BST

Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.



Example 1:


Input: root = [5,3,6,2,4,null,7], k = 9
Output: true
Example 2:


Input: root = [5,3,6,2,4,null,7], k = 28
Output: false


Constraints:

The number of nodes in the tree is in the range [1, 10^4].
-10^4 <= Node.val <= 10^4
root is guaranteed to be a valid binary search tree.
-10^5 <= k <= 10^5
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P2TwoSumIVInputBST {
    public static void main(String[] args) {

    }

    // will do letter how to do it in one stack
    // next and previous in one functions
    // and how to remove the redundant steps
    private Stack<TreeNode> st1 = new Stack<>();
    private Stack<TreeNode> st2 = new Stack<>();

    public void pushAllLeft(TreeNode root) {
        while (root != null) {
            st1.push(root);
            root = root.left;
        }
    }

    public void pushAllRight(TreeNode root) {
        while (root != null) {
            st2.push(root);
            root = root.right;
        }
    }

    public int next() {
        TreeNode top = st1.pop();
        pushAllLeft(top.right);
        return top.val;
    }

    public int previous() {
        TreeNode top = st2.pop();
        pushAllRight(top.left);
        return top.val;
    }

    public void BSTIterator(TreeNode root) {
        st1 = new Stack<>();
        st1.push(root);
        pushAllLeft(root.left);

        st2 = new Stack<>();
        st2.push(root);
        pushAllRight(root.right);
    }

    // Optimal Approach
    // T(C) = O(N)
    // S(C) = O(H) + O(H)
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator(root);
        int i = next(), j = previous();
        while (i < j) {
            int sum = i + j;
            if (sum == k) return true;
            else if (sum < k) i = next();
            else j = previous();
        }

        return false;
    }

    // Brute Force Approach
    // Morris Inorder Traversal + Two Sum (Optimal Solution)
    // T(C) = O(2N) + O(N) = O(N)
    // S(C) = O(N)
//    public boolean findTarget(TreeNode root, int k) {
//        List<Integer> sortedArray = new ArrayList<>();
//        morrisInorderTraversal(root, sortedArray);
//
//        // Two Sum (Optimal Solution -> Two Pointer)
//        int left = 0, right = sortedArray.size() - 1;
//        while (left < right) {
//            int sum = sortedArray.get(left) + sortedArray.get(right);
//            if (sum == k) return true;
//            else if (sum < k) left++;
//            else right--; // (sum > k)
//        }
//
//        return false;
//    }
//
//    public void morrisInorderTraversal(TreeNode root, List<Integer> inorder) {
//        TreeNode curr = root;
//
//        while (curr != null) {
//            if (curr.left == null) {
//                inorder.add(curr.val);
//                curr = curr.right;
//            } else {
//                TreeNode temp = curr.left; // curr left node
//
//                // Find the last right Node of left subtree
//                while (temp.right != null && temp.right != curr) {
//                    temp = temp.right;
//                }
//
//                // Create the thread
//                if (temp.right == null) {
//                    temp.right = curr;
//                    curr = curr.left;
//                } else { // (temp.right == curr) Remove the thread
//                    temp.right = null;
//                    inorder.add(curr.val);
//                    curr = curr.right;
//                }
//            }
//        }
//    }

}