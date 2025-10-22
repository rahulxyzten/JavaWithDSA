package Leetcode.Math.Medium;
//Problem
/*
7. Reverse Integer
Medium
11.6K
12.8K
Companies
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).



Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21


Constraints:

-231 <= x <= 231 - 1
 */

public class P1ReverseInteger {
    public static void main(String[] args) {
        int x = -121;
//        int x = 120;
        System.out.println(reverse(x));
    }


    //Time Complexity: O(log10N + 1) In while loop we divide N by 10 until it becomes 0 which takes log10N iterations.
    //Space Complexity: O(1)
    public static int reverse(int x) {
        long rem, rev = 0;
        // long because in the time of rev * 10 if the number is big then it exceeds the limit of int
        while (x != 0) {
            // Here you can't do x > 0 because the x can be a negative number also
            // if the number is -123 and after -123/10 -12 then it doesn't go further -12
            rem = x % 10;
            rev = (rev * 10) + rem;
            x /= 10;
        }
        if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) return 0;

        return (int) rev;
    }
}
