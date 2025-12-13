package KunalKushwaha.Cp6String.Leetcode.Easy;
//Problem
/*
796. Rotate String

Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.


Example 1:

Input: s = "abcde", goal = "cdeab"
Output: true
Example 2:

Input: s = "abcde", goal = "abced"
Output: false


Constraints:

1 <= s.length, goal.length <= 100
s and goal consist of lowercase English letters.
 */

public class P5RotateString {
    public static void main(String[] args) {
//        String s = "abcde", goal = "cdeab";
        //cdeabcdeab
        String s = "abcde", goal = "abced";
        System.out.println(rotateString(s, goal));
    }

    // Optimal Solution
    //T(C) = O(N) and S(C) = O(2N) = O(N)
    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;

        String doubledG = goal + goal;
        // We observe that if we repeat the goal string twice, then
        // the start string is present inside it, if it is a rotated string
        return doubledG.contains(s);
    }


    // Brute Force Approach
    // Try all possible rotations of s
    // T(C) = O(N^2) and S(C) = O(N)
//    public static boolean rotateString(String s, String goal) {
//        if (s.length() != goal.length()) return false;
//
//        for (int i = 0; i < s.length(); i++) {
//            String rotated = s.substring(i) + s.substring(0, i);
//            if (rotated.equals(goal)) return true;
//        }
//
//        return false;
//    }

}
