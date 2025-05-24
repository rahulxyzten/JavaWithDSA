package TakeYouforward.BinaryTree.LeetCode.Medium;
//Problem
/*
662. Maximum Width of Binary Tree
Solved
Medium
Topics
Companies
Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.

It is guaranteed that the answer will in the range of a 32-bit signed integer.



Example 1:


Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).
Example 2:


Input: root = [1,3,2,5,null,null,9,6,null,7]
Output: 7
Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).
Example 3:


Input: root = [1,3,2,5]
Output: 2
Explanation: The maximum width exists in the second level with length 2 (3,2).


Constraints:

The number of nodes in the tree is in the range [1, 3000].
-100 <= Node.val <= 100
 */

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    TreeNode node;
    int index;

    public Pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}

public class P5MaximumWidthBinaryTree {
    public static void main(String[] args) {

    }

    //Optimal Solution
    //T(C) = O(N) & S(C) = O(N)
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int maxWidth = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int minIndex = q.peek().index;
            int firstIndex = 0, lastIndex = 0;
            for (int i = 0; i < size; i++) {
                int currIndex = q.peek().index - minIndex;
                TreeNode node = q.peek().node;
                q.poll();

                if (i == 0) firstIndex = currIndex;
                if (i == size - 1) lastIndex = currIndex;

                if (node.left != null)
                    q.offer(new Pair(node.left, currIndex * 2 + 1));
                if (node.right != null)
                    q.offer(new Pair(node.right, currIndex * 2 + 2));
            }
            maxWidth = Math.max(maxWidth, lastIndex - firstIndex + 1);
        }
        return maxWidth;
    }
}
