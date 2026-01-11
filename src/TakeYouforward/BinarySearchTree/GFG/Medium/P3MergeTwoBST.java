package TakeYouforward.BinarySearchTree.GFG.Medium;
// Problem
/*
Merge two BST 's

You are given the root of two BSTs, you have to merge this two BST and return the in-order traversal of the new BST.

Examples:

Input: root1 = [3, 1, 5], root2 = [4, 2, 6]

Output: [1, 2, 3, 4, 5, 6]
Explanation: After merging and sorting the two BST we get [1, 2, 3, 4, 5, 6].
Input: root1 = [8, 2, 10, 1, N], root2 = [5, 3, N, 0, N]

Output: [0, 1, 2, 3, 5, 8, 10]
Explanation: After merging and sorting the two BST we get [0, 1, 2, 3, 5, 8, 10].
Constraints:
1 ≤ number of nodes ≤ 10^5
0 ≤ node->data ≤ 10^5
 */

import java.util.ArrayList;

public class P3MergeTwoBST {
    public static void main(String[] args) {

    }

    // Optimal Approach
    // T(C) = O(n) + O(m) + O(n+m)
    // S(C) = O(n) + O(m) + O(n+m)
    public ArrayList<Integer> merge(Node root1, Node root2) {
        ArrayList<Integer> inorder1 = new ArrayList<>();
        inorderTraversal(root1, inorder1);
        ArrayList<Integer> inorder2 = new ArrayList<>();
        inorderTraversal(root2, inorder2);

        ArrayList<Integer> inorder = new ArrayList<>();
        int n = inorder1.size(), m = inorder2.size();
        int i = 0, j = 0;

        while (i < n && j < m) {
            if (inorder1.get(i) < inorder2.get(j)) {
                inorder.add(inorder1.get(i));
                i++;
            } else {
                inorder.add(inorder2.get(j));
                j++;
            }
        }

        while (i < n) {
            inorder.add(inorder1.get(i));
            i++;
        }

        while (j < m) {
            inorder.add(inorder2.get(j));
            j++;
        }

        return inorder;
    }


    // Brute Force Approach
    // T(C) = O(n) + O(m) + O((n+m) * log(n+m)) = O((n+m) * log(n+m))
    // S(C) = O(n+m)
//    public ArrayList<Integer> merge(Node root1, Node root2) {
//        ArrayList<Integer> inorder = new ArrayList<>();
//        inorderTraversal(root1, inorder);
//        inorderTraversal(root2, inorder);
//        inorder.sort((a, b) -> a - b);
//        return inorder;
//    }

    public void inorderTraversal(Node root, ArrayList<Integer> inorder) {
        if (root == null) return;
        inorderTraversal(root.left, inorder);
        inorder.add(root.data);
        inorderTraversal(root.right, inorder);
    }
}