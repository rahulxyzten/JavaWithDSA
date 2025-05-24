package TakeYouforward.Recursion.LeetCode.Medium;
//problem
/*
50. Pow(x, n)

Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25


Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
n is an integer.
Either x is not zero or n > 0.
-104 <= xn <= 104
 */

public class P1Pow {
    public static void main(String[] args) {
//        double x = 2.00000;
//        int n = 10;
//        double x = 2.10000;
//        int n = 3;
        double x = 2.00000;
        int n = -2;
        System.out.println(myPow(x, n));
    }

    //Optimal Solution using Recursion
    //T(C) = O(logn)
    //S(C) = O(logn) Recursive stack
//    public static double myPow(double x, int n) {
//        double ans = 1.0;
//        long nn = n;
//        if (nn < 0) nn = -1 * nn;
//        double result = solve(ans, x, nn);
//        if (n < 0) result = 1.0/result;
//        return result;
//    }
//
//    public static double solve(double ans, double x, long nn) {
//        if (nn <= 0) return ans;
//        if (nn % 2 == 1) {
//            ans = ans * x;
//            nn = nn - 1;
//        } else {
//            x = x * x;
//            nn = nn / 2;
//        }
//        return solve(ans, x, nn);
//    }


    //Optimal Solution not using Recursion
    //T(C) = O(logn)
    //S(C) = O(1)
    public static double myPow(double x, int n) {
        double ans = 1.0;
        long nn = n;
        if (nn < 0) {
            nn = -1 * nn;
        }
        while (nn > 0) {
            if (nn % 2 == 1) {
                ans = ans * x;
                nn = nn - 1;
            } else {
                x = x * x;
                nn = nn / 2;
            }
        }
        if (n < 0) ans = 1.0 / ans;
        return ans;
    }
}
