package TakeYouforward.BinaryTree.LeetCode.Easy;
//Problem
/*
94. Binary Tree Inorder Traversal

Given the root of a binary tree, return the inorder traversal of its nodes' values.



Example 1:
Input: root = [1,null,2,3]
Output: [1,3,2]

Example 2:
Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]


Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100


Follow up: Recursive solution is trivial, could you do it iteratively?
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P2BinaryTreeInorderTraversal {
    public static void main(String[] args) {

    }

    //Iterative Solution
    //T(C) = O(N)
    //S(C) = O(N)
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while (true) {
            if (node != null) {
                st.push(node);
                node = node.left;
            } else {
                if (st.isEmpty()) break;
                node = st.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }

//    //Recursive Solution
//    //T(C) = O(N)
//    //S(C) = O(N)
//    public static List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        inOrder(root, result);
//        return result;
//    }
//
//    public static void inOrder(TreeNode node, List<Integer> result) {
//        if (node == null) return;
//        inOrder(node.left, result);
//        result.add(node.val);
//        inOrder(node.right, result);
//    }
}
