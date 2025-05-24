package TakeYouforward.BinaryTree.LeetCode.Medium;
//Problem
/*
199. Binary Tree Right Side View

Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.



Example 1:


Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
Example 2:

Input: root = [1,null,3]
Output: [1,3]
Example 3:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 */

import java.util.*;

public class P3BinaryTreeRightSideView {
    public static void main(String[] args) {

    }

    //Optimal Solution (Using Recursion)
    //T(C) = O(N)
    //S(C) = O(N)
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        rightView(root, 0, result);
        return result;
    }

    //right View
    public void rightView(TreeNode node, int level, List<Integer> result) {
        if (node == null) return;
        if (level == result.size()) result.add(node.val);
        rightView(node.right, level + 1, result);
        rightView(node.left, level + 1, result);
    }

    //left view
    public void leftView(TreeNode node, int level, List<Integer> result) {
        if (node == null) return;
        if (level == result.size()) result.add(node.val);
        leftView(node.left, level + 1, result);
        leftView(node.right, level + 1, result);
    }


    //Brute Force Approach (Level Order Traversal) (Iterative Approach)
    //T(C) = O(N) + O(logN) + O(N)
    //S(C) = O(N) + O(N)
//    public List<Integer> rightSideView(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        if (root == null) return result;
//        Queue<TreeNode> q = new LinkedList<>();
//        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
//        q.offer(root);
//        int level = 1;
//        while (!q.isEmpty()) {
//            int size = q.size();
//            List<Integer> temp = new ArrayList<>();
//            for (int i = 0; i < size; i++) {
//                TreeNode node = q.poll();
//                temp.add(node.val);
//                if (node.left != null) q.add(node.left);
//                if (node.right != null) q.add(node.right);
//            }
//            map.put(level, temp);
//            level++;
//        }
//
//        //For Right View
//        for (List<Integer> row : map.values()) {
//            result.add(row.get(row.size() - 1));
//        }
//
//        //For Left View
////        for (List<Integer> row : map.values()) {
////            result.add(row.get(1));
////        }
//        return result;
//    }
}
