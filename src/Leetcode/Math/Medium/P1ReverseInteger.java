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
//        int x = -123;
        int x = 120;
        System.out.println(reverse(x));
    }

    //Runtime 1 ms and Memory 39.3 MB
    public static int reverse(int x) {

        long reversedx = 0;
        int remainder;

        int temp = x;

        while (temp != 0) {
            remainder = temp % 10;
            reversedx = (reversedx * 10) + remainder;
            temp /= 10;
        }
        if (reversedx > Integer.MAX_VALUE || reversedx < Integer.MIN_VALUE)
            return 0;
        //versing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0
        return (int) reversedx;
    }

    //Runtime 1 ms and Memory 40 MB
//    public int reverse(int x) {
//        long rev= 0;
//        while( x != 0){
//            rev= rev*10 + x % 10;
//            x= x/10;
//            if( rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
//                return 0;
//        }
//        return (int) rev;
//    }
}
