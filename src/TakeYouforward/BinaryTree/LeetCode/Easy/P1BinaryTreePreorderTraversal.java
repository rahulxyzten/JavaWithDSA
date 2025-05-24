package TakeYouforward.BinaryTree.LeetCode.Easy;
//Problem
/*
144. Binary Tree Preorder Traversal

Given the root of a binary tree, return the preorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,2,3]

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

public class P1BinaryTreePreorderTraversal {
    public static void main(String[] args) {

    }

    //Iterative Solution
    //T(C) = O(N)
    //S(C) = O(N)
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> st = new Stack<>();

        st.push(root);
        while (!st.isEmpty()) {
            root = st.pop();
            result.add(root.val);
            if (root.right != null) st.push(root.right);
            if (root.left != null) st.push(root.left);
        }
        return result;
    }

    //Recursive Solution
    //T(C) = O(N)
    //S(C) = O(N)
//    public static List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        preOrder(root, result);
//        return result;
//    }
//
//    public static void preOrder(TreeNode node, List<Integer> result) {
//        if (node == null) return;
//        result.add(node.val);
//        preOrder(node.left, result);
//        preOrder(node.right, result);
//    }
}
