package TakeYouforward.BinaryTree.CodeStudio.Easy;
//Problem
//Preorder, Inorder, and Postorder Traversal in one Traversal
/*
 Tree Traversals

You have been given a Binary Tree of 'N'

nodes, where the nodes have integer values.



Your task is to return the ln-Order, Pre-Order, and Post-Order traversals of the given binary tree.



For example :
For the given binary tree:

The Inorder traversal will be [5, 3, 2, 1, 7, 4, 6].
The Preorder traversal will be [1, 3, 5, 2, 4, 7, 6].
The Postorder traversal will be [5, 2, 3, 7, 6, 4, 1].
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
1 2 3 -1 -1 -1  6 -1 -1
Sample Output 1 :
2 1 3 6
1 2 3 6
2 6 3 1
Explanation of Sample Output 1 :
 The given binary tree is shown below:

Inorder traversal of given tree = [2, 1, 3, 6]
Preorder traversal of given tree = [1, 2, 3, 6]
Postorder traversal of given tree = [2, 6, 3, 1]
Sample Input 2 :
1 2 4 5 3 -1 -1 -1 -1 -1 -1
Sample Output 2 :
5 2 3 1 4
1 2 5 3 4
5 3 2 4 1
Explanation of Sample Output 2 :
The given binary tree is shown below:

Inorder traversal of given tree = [5, 2, 3, 1, 4]
Preorder traversal of given tree = [1, 2, 5, 3, 4]
Postorder traversal of given tree = [5, 3, 2, 4, 1]
Constraints :
1 <= 'N' <= 10^5
0 <= 'data' <= 10^5

where 'N' is the number of nodes and 'data' denotes the node value of the binary tree nodes.

Time limit: 1 sec
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Pair {
    TreeNode node;
    int num;

    public Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}

public class P1TreeTraversals {
    public static void main(String[] args) {

    }

    //T(C) = O(3N) = O(N)
    //S(C) = O(4N) = O(N)
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        Stack<Pair> st = new Stack<>();

        st.push(new Pair(root, 1));
        while (!st.isEmpty()) {
            if (st.peek().num == 1) {
                preOrder.add(st.peek().node.data);
                st.peek().num++;
                if (st.peek().node.left != null) st.push(new Pair(st.peek().node.left, 1));
            } else if (st.peek().num == 2) {
                inOrder.add(st.peek().node.data);
                st.peek().num++;
                if (st.peek().node.right != null) st.push(new Pair(st.peek().node.right, 1));
            } else {
                postOrder.add(st.peek().node.data);
                st.pop();
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(inOrder);
        result.add(preOrder);
        result.add(postOrder);
        return result;
    }
}
