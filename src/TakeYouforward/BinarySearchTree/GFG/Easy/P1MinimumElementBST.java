package TakeYouforward.BinarySearchTree.GFG.Easy;
// Problem
/*
Minimum element in BST

Given the root of a Binary Search Tree. Your task is to find the minimum element in this given BST.

Examples

Input: root = [5, 4, 6, 3, N, N, 7, 1]
ex-1
Output: 1
Explanation: The minimum element in the given BST is 1.
Input: root = [10, 5, 20, 2]
ex-2
Output: 2
Explanation: The minimum element in the given BST is 2.
Constraints:
0 ≤ number of nodes ≤ 10^5
0 ≤ node->data ≤ 10^5
 */

public class P1MinimumElementBST {
    public static void main(String[] args) {

    }

    // Optimal Solution
    // T(C) = O(logN)
    // S(C) = O(1)
    public int minValue(Node root) {
        int minElement = 0;
        while (root != null) {
            minElement = root.data;
            root = root.left;
        }

        return minElement;
    }

    // Optimal Solution
    // T(C) = O(logN)
    // S(C) = O(1)
    public int maxValue(Node root) {
        int maxElement = 0;
        while (root != null) {
            maxElement = root.data;
            root = root.right;
        }

        return maxElement;
    }
}
