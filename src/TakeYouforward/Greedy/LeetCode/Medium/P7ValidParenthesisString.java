package TakeYouforward.Greedy.LeetCode.Medium;
// Problem
/*
678. Valid Parenthesis String

Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "(*)"
Output: true
Example 3:

Input: s = "(*))"
Output: true


Constraints:

1 <= s.length <= 100
s[i] is '(', ')' or '*'.
 */

public class P7ValidParenthesisString {
    public static void main(String[] args) {
        String s = "()";
//        String s = "(*)";
//        String s = "(*))";
//        System.out.println(checkValidString(s));
    }

    // Optimal Approach
    // T(C) = O(N)
    // S(C) = O(1)
    public static boolean checkValidString(String s) {
        int min = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                min = min + 1;
                max = max + 1;
            } else if (s.charAt(i) == ')') {
                min = min - 1;
                max = max - 1;
            } else {
                min = min - 1;
                max = max + 1;
            }

            if (min < 0) min = 0;
            if (max < 0) return false;
        }

        return min == 0;
    }

    // Brute Force Approach
    // Time Limit Exceeded 80 / 83 testcases passed
    // T(C) = O(3^N)
    // S(C) = O(N) {Recursive Stack)
//    public static boolean checkValidString(String s) {
//        return checkValid(s, 0, s.length(), 0);
//    }
//
//    public static boolean checkValid(String s, int i, int n, int count) {
//        if (count < 0) return false;
//        if (i == n) return count == 0;
//
//        if (s.charAt(i) == '(') return checkValid(s, i + 1, n, count + 1);
//        else if (s.charAt(i) == ')') return checkValid(s, i + 1, n, count - 1);
//        else { // (s.charAt(i) == '*')
//            return checkValid(s, i + 1, n, count + 1) || checkValid(s, i + 1, n, count - 1) || checkValid(s, i + 1, n, count);
//        }
//    }
}
