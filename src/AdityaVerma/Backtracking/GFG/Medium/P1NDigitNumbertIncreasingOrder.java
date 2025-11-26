package AdityaVerma.Backtracking.GFG.Medium;
//problem
/*
N Digit numbers with digits in increasing order

Given an integer n, print all the n digit numbers in increasing order, such that their digits are in strictly increasing order(from left to right).

Example 1:

Input:
n = 1
Output:
0 1 2 3 4 5 6 7 8 9
Explanation:
Single digit numbers are considered to be
strictly increasing order.
Example 2:

Input:
n = 2
Output:
12 13 14 15 16 17 18 19 23....79 89
Explanation:
For n = 2, the correct sequence is
12 13 14 15 16 17 18 19 23 and so on
up to 89.
Your Task:
You don't need to read input or print anything. Your task is to complete the function increasingNumbers() which takes an integer n as an input parameter and returns the list of numbers such that their digits are in strictly increasing order.

Expected Time Complexity: O(9n)
Expected Auxiliary Space: O(n)

Constraints:
1 <= n <= 9
*/

import java.util.ArrayList;

public class P1NDigitNumbertIncreasingOrder {
    public static void main(String[] args) {
        System.out.println(increasingNumbers(2));
    }

    // T(C) = O(9^N * N)
    // Total number of node => O(9^N)
    // Work done by a node => Contracting the integer from ArrayList takes O(N)
    // S(C) = O(9^N) + O(N) = O(9^N)
    // Total number of integer in ArrayList +  recursion stack (depth of the recursion)
    public static ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        if (n == 1) {
            for (int i = 0; i <= 9; i++) {
                result.add(i);
            }
            return result;
        }
        // This base condition for n == 1 must need
        // If not written then in solve function it add [1->9] to result
        // The answer is [0->9]

        ArrayList<Integer> op = new ArrayList<>();
        solve(n, op, result);
        return result;
    }

    public static void solve(int n, ArrayList<Integer> op, ArrayList<Integer> result) {
        if (n == 0) {
            int ans = 0;
            for (int num : op) {
                ans = ans * 10 + num;
            }
            result.add(ans);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (op.size() == 0 || op.get(op.size() - 1) < i) {
                op.add(i);
                solve(n - 1, op, result);
                op.remove(op.size() - 1);
            }
        }
    }
}
