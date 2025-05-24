package TakeYouforward.BitManipulation.LeetCode.Medium;
//Problem
/*
29. Divide Two Integers

Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

Return the quotient after dividing dividend by divisor.

Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.



Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = 3.33333.. which is truncated to 3.
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = -2.33333.. which is truncated to -2.


Constraints:

-231 <= dividend, divisor <= 231 - 1
divisor != 0
 */

public class P1DivideTwoIntegers {
    public static void main(String[] args) {
        System.out.println(divide(10, 3));
//        System.out.println(divide(-2147483648, -1));
        //Above return Integer.MAX_VALUE
//        System.out.println(divide(-2147483648, 1));
        //Above return Integer.MIN_VALUE;
    }

    /*Waiting for another best Solution*/
    //Optimal solution
    //T(C) = O((Log n)^2)
    //S(C) = O(1)
    //The divided value is never equal to or greater-than 2147483648 because the maximum value of Integer is 2147483647,
    //but it values is equal to but never smaller-than -2147483648 because the minimum value of Integer is -2147483648
    public static int divide(int dividend, int divisor) {
        if (dividend == divisor) return 1;
        boolean sign = true;
        if (dividend >= 0 && divisor < 0) sign = false;
        if (dividend < 0 && divisor > 0) sign = false;
        long n = Math.abs((long) dividend), d = Math.abs((long) divisor);
        long ans = 0;
        while (n >= d) {
            int count = 0;
            while (n >= (d << (count + 1))) count++;
            //below line for hold the testcases for n = -2147483648, d =  -1
            //because 2^31 (1<<count) and count = 31 gives -2147483648
            //so if count = 31 the ans store -2147483648 instate of 2147483648
            //because of  ans = Integer.MAX_VALUE + 1L;
            if (count == 31) {
                ans = Integer.MAX_VALUE + 1L;
            } else {
                ans += (1L << count);
            }
            n = n - (d << (count));
        }
        if (ans >= Math.pow(2, 31) && sign) return Integer.MAX_VALUE;
        if (ans >= Math.pow(2, 31) && !sign) return Integer.MIN_VALUE;

        return (sign) ? (int) ans : (int) (-1 * ans);
    }
}
