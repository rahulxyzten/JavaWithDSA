package TakeYouforward.BinarySearch.LeetCode.Easy;
// Problem
/*
441. Arranging Coins

You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.

Given the integer n, return the number of complete rows of the staircase you will build.

Example 1:


Input: n = 5
Output: 2
Explanation: Because the 3rd row is incomplete, we return 2.
Example 2:


Input: n = 8
Output: 3
Explanation: Because the 4th row is incomplete, we return 3.


Constraints:

1 <= n <= 2^31 - 1
 */

public class P5ArrangingCoins {
    public static void main(String[] args) {
        int n = 1804289383;
        System.out.println(arrangeCoins(n));
    }

    // Optimal Solution
    // T(C) = O(logn)
    // S(C) = O(1)
    public static int arrangeCoins(int n) {
        int start = 1, end = n;
        int result = 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long coinsRequired = ((long) mid * (mid + 1)) / 2;
            // or make every variable long
            // and in the return time do (int) mid or (int) result
            if (coinsRequired == n) return mid;
            else if (coinsRequired < n) {
                result = mid;
                start = mid + 1;
            } else end = mid - 1;
        }

        return result;
    }
}
