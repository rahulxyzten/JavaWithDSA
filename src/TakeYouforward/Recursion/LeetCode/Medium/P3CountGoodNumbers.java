package TakeYouforward.Recursion.LeetCode.Medium;
//Problem
/*
1922. Count Good Numbers

A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).

For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. However, "3245" is not good because 3 is at an even index but is not even.
Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 109 + 7.

A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.



Example 1:

Input: n = 1
Output: 5
Explanation: The good numbers of length 1 are "0", "2", "4", "6", "8".
Example 2:

Input: n = 4
Output: 400
Example 3:

Input: n = 50
Output: 564908303


Constraints:

1 <= n <= 1015
 */

public class P3CountGoodNumbers {
    public static long MOD = 1_000_000_007;

    public static void main(String[] args) {

//        long n = 50;
        long n = 1924;
        System.out.println(countGoodNumbers(n));
    }

    //Optimal Solution
    //T(C) = O(logn)
    //S(C) = O(logn) Recursive stack
    public static int countGoodNumbers(long n) {
        long noOdd = n / 2;
        long noEven = (n / 2) + (n % 2);

        return (int) ((pow(4, noOdd, 1L) * pow(5, noEven, 1L)) % MOD);
        // Since the answer may be large, return it modulo 109 + 7 (Given)
        // So when you think the ans is large then modulo the ans with MOD
    }

    public static long pow(long x, long n, long ans) {
        if (n <= 0) return ans % MOD;

        if (n % 2 != 0) {
            ans *= x;
            ans %= MOD;
            // So when you think the ans is large then modulo the ans with MOD
            // which is given
            n -= 1;
        } else {
            x *= x;
            x %= MOD;
            // here also after some iteration x is large so modulo the x with MOD
            // which is given
            n /= 2;
        }

        return pow(x, n, ans);
    }


    // Brute Force Approach
    // Time Limit Exceeded Error
    // T(C) = O(n)
    // S(C) = O(1)
//    public static int countGoodNumbers(long n) {
//        long ans = 1L;
//        for (int i = 0; i < n; i++) {
//            if (i % 2 != 0) {
//                ans *= 4;
//                ans %= MOD;
//            } else {
//                ans *= 5;
//                ans %= MOD;
//            }
//        }
//
//        return (int) (ans % MOD);
//    }
}
