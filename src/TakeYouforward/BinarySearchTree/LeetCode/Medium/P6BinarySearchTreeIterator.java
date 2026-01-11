package TakeYouforward.BinarySearchTree.LeetCode.Medium;
// Problem
/*
173. Binary Search Tree Iterator

Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):

BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
int next() Moves the pointer to the right, then returns the number at the pointer.
Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.

You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.

Example 1:


Input
["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
[[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
Output
[null, 3, 7, true, 9, true, 15, true, 20, false]

Explanation
BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
bSTIterator.next();    // return 3
bSTIterator.next();    // return 7
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 9
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 15
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 20
bSTIterator.hasNext(); // return False


Constraints:

The number of nodes in the tree is in the range [1, 10^5].
0 <= Node.val <= 10^6
At most 10^5 calls will be made to hasNext, and next.


Follow up:

Could you implement next() and hasNext() to run in average O(1) time and use O(h) memory, where h is the height of the tree?
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class P6BinarySearchTreeIterator {
    public static void main(String[] args) {

    }

    // Optimal Approach
    Stack<TreeNode> st = new Stack<>();

    private void pushAllLeft(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }

    // S(C) = O(H) {height of BST}
    // T(C) = O(H)
    public void BSTIterator(TreeNode root) {
        st = new Stack<>();
        st.push(root);
        pushAllLeft(root.left);
    }

    // T(C) = O(1)
    public int next() {
        TreeNode top = st.pop();
        pushAllLeft(top.right);
        return top.val;
    }

    // T(C) = O(1)
    public boolean hasNext() {
        return !st.isEmpty();
    }


    // Brute Force Approach
//    private List<Integer> inorder = new ArrayList<>();
//    private int pointer;
//
//    public void inorderTraversal(TreeNode root) {
//        if (root == null) return;
//        inorderTraversal(root.left);
//        inorder.add(root.val);
//        inorderTraversal(root.right);
//    }
//
//    // T(C) = O(N)
//    // S(C) = O(N)
//    public void BSTIterator(TreeNode root) {
//        // Initialize pointer to a non-existent value
//        pointer = -1;
//        // Initialize the list to store inorder traversal
//        inorder = new ArrayList<>();
//        inorderTraversal(root);
//    }
//
//    // T(C) = O(1)
//    public int next() {
//        pointer++; // Here only the pointer value increase
//        return inorder.get(pointer);
//    }
//
//    // T(C) = O(1)
//    public boolean hasNext() {
//        return (pointer + 1) < inorder.size();
//    }
}