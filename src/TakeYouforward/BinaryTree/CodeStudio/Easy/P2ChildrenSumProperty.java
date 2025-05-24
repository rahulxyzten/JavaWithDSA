package TakeYouforward.BinaryTree.CodeStudio.Easy;

//Problem (CodeStudio 1)
/*
Children Sum Property
Moderate
80/80
Average time to solve is 36m
Contributed by
179 upvotes
Asked in companies
Problem statement
Given a binary tree of nodes 'N', you need to modify the value of its nodes, such that the tree holds the Children sum property.

A binary tree is said to follow the children sum property if, for every node of that tree, the value of that node is equal to the sum of the value(s) of all of its children nodes( left child and the right child).

Note :
 1. You can only increment the value of the nodes, in other words, the modified value must be at least equal to the original value of that node.
 2. You can not change the structure of the original binary tree.
 3. A binary tree is a tree in which each node has at most two children.
 4. You can assume the value can be 0 for a NULL node and there can also be an empty tree.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= T <= 10^2
0 <= N <= 10^2
1 <= node.Value <= 10^6

Time Limit : 1 sec
Sample Input 1 :
1
2 35 10 2 3 5 2 -1 -1 -1 -1 -1 -1 -1 -1
Sample Output 1 :
Valid ( One of the possible answers is : 45 35 10 32 3 8 2 -1 -1 -1 -1 -1, thus if the user modifies the given tree like this, the output printed will be valid).
Explanation For Sample Input 1 :
The tree can be represented as follows :

The value at the root node is 2 which is less than the sum of its children’s values (35 + 10). So we simply increase the value at the root node to 45. The node with value  = 35 has children with values 2 and 3 so their sum i.s 2 + 3 = 5 < 35. As we can't decrement any value, so instead we have to increase the sum of children and thus we update 35's children (2 and 3) as 30 and 5 so that 30 + 5 = 35 and the same is done for the children of the node with value = 10.
The final tree looks like this :

Note that there can be many other valid solutions.
Sample Input 2 :
1
10 5 5 -1 -1 -1 -1
Sample Output 2 :
Valid
 */

//Problem (GFG)
/*
Children Sum in a Binary Tree
Difficulty: MediumAccuracy: 51.58%Submissions: 162K+Points: 4
Given a binary tree having n nodes. Check whether all of its nodes have the value equal to the sum of their child nodes. Return 1 if all the nodes in the tree satisfy the given properties, else it return 0.

For every node, data value must be equal to the sum of data values in left and right children. Consider data value as 0 for NULL child.  Also, leaves are considered to follow the property.

Example 1:

Input:
Binary tree
       35
      /   \
     20  15
    /  \  /  \
   15 5 10 5
Output:
1
Explanation:
Here, every node is sum of its left and right child.
Example 2:

Input:
Binary tree
       1
     /   \
    4    3
   /
  5
Output:
0
Explanation:
Here, 1 is the root node and 4, 3 are its child nodes. 4 + 3 = 7 which is not equal to the value of root node. Hence, this tree does not satisfy the given condition.
Your Task:
You don't need to read input or print anything. Your task is to complete the function isSumProperty() that takes the root Node of the binary tree as input and returns 1 if all the nodes in the tree satisfy the following properties, else it returns 0.

Expected Time Complexiy: O(n).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= n <= 105
1 <= Data on nodes <= 105


 */

//Problem (CodeStudio 2)
/*
Children Sum Property
Easy
0/40
34 upvotes
Problem statement
Return true if all non-leaf nodes in a given binary tree have a value that is equal to the sum of their child nodes, otherwise return false..



For Example:

Output: true
Explanation: Node 2 and 3 are children of Node 1 and (3+1)=4.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
4
5 3 2 3 -1 -1 -1 -1 -1
Sample Output 1:
true
Explanation Of Sample Input 1:

Node 1: The sum of its child nodes is 3 + 2 = 5, which is equal to its value.
Node 2: The sum of its child nodes is 3, which is equal to its value.
Node 3: It is a leaf node with no child nodes, so the condition is satisfied.
Node 4: It is a leaf node with no child nodes, so the condition is satisfied.
Sample Input 2:
6
7 3 4 3 -1 2 3 -1 -1 -1 -1 -1 -1
Sample Output 2:
false
Explanation Of Sample Input 2:

Node 1: The sum of its child nodes is 3 + 4 = 7, which is equal to its value.
Node 2: The sum of its child nodes is 3, which is equal to its value.
Node 3: The sum of its child nodes is 2 + 3 = 5, which is not equal to its value 4, so the condition is not satisfied. Hence the answer is false.
Constraints:
1 <= N <= 10^3
1 <= data <= 10^5
Time Limit: 1 sec
 */

public class P2ChildrenSumProperty {
    public static void main(String[] args) {

    }

    //TUF Version (CodeStudio 1) (Medium)
    //Optimal Solution T(C) = O(N) & S(C) = O(H) Height of the Binary Tree OR O(N) if Binary Tree is a Skew Tree
    public static void changeTree(Node root) {
        if (root == null) return;
        int child = 0;

        if (root.left != null) child += root.left.data;
        if (root.right != null) child += root.right.data;

        if (child >= root.data) root.data = child;
        else {
            if (root.left != null) root.left.data = root.data;
            if (root.right != null) root.right.data = root.data;
        }

        changeTree(root.left);
        changeTree(root.right);

        int tot = 0;
        if (root.left != null) tot += root.left.data;
        if (root.right != null) tot += root.right.data;
        if (root.left != null || root.right != null) root.data = tot;
    }

    //GFG Version (Medium)
    //BEST CODE T(C) = O(N) & S(C) = O(N) recursive stack or height of the Binary Tree
    public static int isSumProperty(Node root) {
        if (root == null || (root.left == null && root.right == null)) return 1;

        if (root.left != null) root.data -= root.left.data;
        if (root.right != null) root.data -= root.right.data;

        if (root.data == 0) {
            if (isSumProperty(root.left) == 1 && isSumProperty(root.right) == 1) return 1;
            else return 0;
        }

        return 0;
    }


    //Code studio 2 Version (Easy)
    //BEST CODE T(C) = O(N) & S(C) = O(N) recursive stack or height of the Binary Tree
    public static boolean isParentSum(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        if (root.left != null) root.data -= root.left.data;
        if (root.right != null) root.data -= root.right.data;

        if (root.data == 0) {
            return isParentSum(root.left) && isParentSum(root.right);
        }

        return false;
    }

    //MY solution
//    public static boolean isParentSum(Node root) {
//
//        // If node is null or a leaf node, return true (leaf nodes satisfy the condition)
//        if (root == null || (root.left == null && root.right == null)) {
//            return true;
//        }
//
//        // Initialize left and right child values
//        int left = (root.left != null) ? root.left.data : 0;
//        int right = (root.right != null) ? root.right.data : 0;
//
//        // Check if current node satisfies the sum condition
//        boolean currentCheck = (root.data == left + right);
//
//        // Recursively check left and right subtrees
//        boolean leftCheck = isParentSum(root.left);
//        boolean rightCheck = isParentSum(root.right);
//
//        // Return true if the current node and its subtrees satisfy the condition
//        return currentCheck && leftCheck && rightCheck;
//    }
}
