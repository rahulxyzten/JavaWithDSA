package TakeYouforward.BinaryTree.CodeStudio.Medium;
//Problem (Code studio)
/*
All Root to Leaf Paths In Binary Tree.
Moderate
0/80
Average time to solve is 25m
Contributed by
79 upvotes
Asked in companies
Problem statement
You are given an arbitrary binary tree consisting of 'N' nodes numbered from 1 to 'N'. Your task is to print all the root to leaf paths of the binary tree.

A leaf of a binary tree is the node which does not have a left child and a right child.



For Example :
Given a binary tree :

All the root to leaf paths are :
1 2 4
1 2 5
1 3
Note :

1. Two nodes may have the same value associated with it.
2. The root node will be fixed and will be provided in the function.
3. Note that the nodes in a path will appear in a fixed order. For example, 1 2 3 is not the same as 2 1 3.
4. Each path should be returned as a string consisting of nodes in order and separated by a space.
5. The path length may be as small as ‘1’.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
5
1 2 3 4 5 -1 -1 -1 -1 -1 -1
Sample Output 1 :
1 2 4
1 2 5
1 3
Explanation for Sample Input 1:

All the root to leaf paths are :
1 2 4
1 2 5
1 3
Sample Input 2 :
7
1 2 3 4 -1 5 6 -1 7 -1 -1 -1 -1 -1 -1
Sample Output 2 :
1 3 5
1 3 6
1 2 4 7
Constraints :
1 <= N <= 3*10^3

Time Limit : 1 sec
 */

//Problem (GFG)
/*
Root to Leaf Paths
Difficulty: MediumAccuracy: 43.65%Submissions: 108K+Points: 4
Given a Binary Tree of nodes, you need to find all the possible paths from the root node to all the leaf nodes of the binary tree.

Example 1:

Input:
       1
    /     \
   2       3
Output:
1 2
1 3
Explanation:
All possible paths:
1->2
1->3
Example 2:

Input:
         10
       /    \
      20    30
     /  \
    40   60
Output:
10 20 40
10 20 60
10 30
Your Task:
Your task is to complete the function Paths() which takes the root node as an argument and returns all the possible paths. (All the paths are printed in new lines by the driver's code.)

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(height of the tree)

Constraints:
1<=n<=104
 */

import java.util.ArrayList;
import java.util.List;

public class P3AllRootToLeafPathsInBinaryTree {
    public static void main(String[] args) {

    }

    //GFG
    //T(C) == O(N) & S(C) = O(N) recursive stack
    public static ArrayList<ArrayList<Integer>> Paths(BinaryTreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        int[] path = new int[10000];
        solveFunctionGFG(root, path, 0, result);
        return result;
    }

    public static void solveFunctionGFG(BinaryTreeNode root, int[] path, int pathLen, ArrayList<ArrayList<Integer>> result) {
        if (root == null) return;

        path[pathLen] = root.data;
        pathLen++;

        if (root.left == null && root.right == null) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < pathLen; i++) {
                temp.add(path[i]);
            }
            result.add(temp);
        } else {
            solveFunctionGFG(root.left, path, pathLen, result);
            solveFunctionGFG(root.right, path, pathLen, result);
        }
    }


    //Code studio
    //T(C) = O(N) & S(C) = O(N) recursive stack
    public static List<String> allRootToLeaf(BinaryTreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        solveFunction(root, result, "");
        return result;
    }

    public static void solveFunction(BinaryTreeNode root, List<String> result, String curr) {
        if (root == null) return;

        curr += root.data + " ";

        if (root.left == null && root.right == null) {
            result.add(curr.trim());
        }

        if (root.left != null)
            solveFunction(root.left, result, curr);
        if (root.right != null)
            solveFunction(root.right, result, curr);
    }


    //Given question based on TUF
    //T(C) = O(N) & S(C) = O(N) recursive stack
    public static List<Integer> allRootToLeafTuf(BinaryTreeNode root, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        solve(root, result, target);
        return result;
    }

    public static boolean solve(BinaryTreeNode root, ArrayList<Integer> result, int target) {
        if (root == null) return false;

        result.add(root.data);
        if (root.data == target) return true;

        if (solve(root.left, result, target) || solve(root.right, result, target)) {
            return true;
        }

        result.remove(result.size() - 1);
        return false;
    }
}
