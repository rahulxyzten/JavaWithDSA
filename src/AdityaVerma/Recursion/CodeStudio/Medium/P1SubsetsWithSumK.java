package AdityaVerma.Recursion.CodeStudio.Medium;
//problem
/*
Count Subsets with Sum K

Problem statement
You are given an array 'arr' of size 'n' containing positive integers and a target sum 'k'.

Find the number of ways of selecting the elements from the array such that the sum of chosen elements is equal to the target 'k'.


Since the number of ways can be very large, print it modulo 10 ^ 9 + 7.


Example:
Input: 'arr' = [1, 1, 4, 5]

Output: 3

Explanation: The possible ways are:
[1, 4]
[1, 4]
[5]
Hence the output will be 3. Please note that both 1 present in 'arr' are treated differently.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
4 5
1 4 4 5


Sample Output 1 :
 3


Explanation For Sample Output 1:
The possible ways are:
[1, 4]
[1, 4]
[5]
Hence the output will be 3. Please note that both 1 present in 'arr' are treated differently.


Sample Input 2 :
3 2
1 1 1


Sample Output 2 :
3


Explanation For Sample Output 1:
There are three 1 present in the array. Answer is the number of ways to choose any two of them.


Sample Input 3 :
3 40
2 34 5


Sample Output 3 :
0


Expected time complexity :
The expected time complexity is O('n' * 'k').


Constraints:
1 <= 'n' <= 100
0 <= 'arr[i]' <= 1000
1 <= 'k' <= 1000

Time limit: 1 sec
 */

public class P1SubsetsWithSumK {
    public static void main(String[] args) {
        int[] num = {1, 4, 4, 5};
        int tar = 5;
        System.out.println(findWays(num, tar));
    }

    ////////////Do this problem later in DP so that all the test cases pass/////////////////////
    /*This code works well for small inputs, but it shows a Time Limit Exceeded error for
    large inputs because 1 ≤ N ≤ 10³. Therefore, for larger inputs,
    the Dynamic Programming (DP) approach is the best solution. */

    // T(C) = O(2^N)
    // total number of node O(2^N)
    // work done by a node => O(1)
    // S(C) = O(N)
    // recursion stack (depth of the recursion)
    public static int findWays(int num[], int tar) {
        return solve(num, 0, num.length, tar);
    }

    public static int solve(int[] num, int i, int n, int k) {
        if (k == 0) return 1;
        if (k < 0 || i == n) return 0;

        return solve(num, i + 1, n, k) + solve(num, i + 1, n, k - num[i]);
    }
}
