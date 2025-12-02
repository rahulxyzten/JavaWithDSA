package TakeYouforward.BinaryTree.LeetCode.Easy;
//Problem
/*
145. Binary Tree Postorder Traversal

Given the root of a binary tree, return the postorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [3,2,1]

Example 2:
Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]


Constraints:

The number of the nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100


Follow up: Recursive solution is trivial, could you do it iteratively?
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P3BinaryTreePostorderTraversal {
    public static void main(String[] args) {

    }

    //Iterative Solution (Using 1 Stack)
    //T(C) = O(2N) = O(N)
    //S(C) = O(N)
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> st = new Stack<>();

        TreeNode curr = root;
        while (curr != null || !st.isEmpty()) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = st.peek().right;
                if (temp == null) {
                    temp = st.peek();
                    result.add(temp.val);
                    st.pop();
                    while (!st.isEmpty() && temp == st.peek().right) {
                        temp = st.peek();
                        result.add(temp.val);
                        st.pop();
                    }
                } else {
                    curr = temp;
                }
            }
        }

        return result;
    }

    // Iterative Solution (Using 2 Stack)
    // T(C) = O(N) + O(N) = O(N)
    // S(C) = O(2N)
//    public static List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        if (root == null) return result;
//        Stack<TreeNode> st1 = new Stack<>();
//        Stack<TreeNode> st2 = new Stack<>();
//
//        st1.push(root);
//        while (!st1.isEmpty()) {
//            root = st1.pop();
//            st2.push(root);
//            if (root.left != null) st1.push(root.left);
//            if (root.right != null) st1.push(root.right);
//        }
//
//        while (!st2.isEmpty()){
//            result.add(st2.pop().val);
//        }
//
//        return result;
//    }

    // Recursive Solution
    // T(C) = O(N)
    // S(C) = O(N), Recursive Stack
//    public static List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        postOrder(root, result);
//        return result;
//    }
//
//    public static void postOrder(TreeNode node, List<Integer> result) {
//        if (node == null) return;
//        postOrder(node.left, result);
//        postOrder(node.right, result);
//        result.add(node.val);
//    }
}
