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

    //OPTIMAL SOLUTION
    //T(C) = O(N) and S(C) = O(2N)
    /*
    Time Complexity:
    The StringBuilder append operation takes O(N), where N is the length of the goal string.
    The indexOf operation on the StringBuilder also takes O(N).
    Therefore, the overall time complexity is O(N), where N is the length of the input strings.
    Space Complexity:
    The StringBuilder is used to concatenate the goal string with itself,
    resulting in a string of length 2N.
     */
    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        StringBuilder str = new StringBuilder(goal);
        str = str.append(str);
        //We observe that if we repeat the goal string twice then
        //the start string is present inside it if it roted string
        return (str.indexOf(s) != -1);
    }


    //My solution T(C) = O(N^2) and S(C) = O(N)
    /*
    Time Complexity:
    The code uses a loop that iterates through each character in the string s.
    Inside the loop, there are constant-time operations such as string manipulation
    (charAt(), substring(), concatenation). The loop runs s.length() times. For each iteration,
     the operations inside the loop take O(s) time complexity (substring operation).
     Space Complexity:
     The space complexity is O(s), where s is the length of the input string.
     This is because in each iteration, a new string is created with a length of at most s.
     */
//    public static boolean rotateString(String s, String goal) {
//        for (int i = 0; i < s.length(); i++) {
//            if (goal.indexOf(s) == 0) return true;
//            char temp = s.charAt(0);
//            s = s.substring(1);
//            s = s + temp;
//        }
//        return false;
//    }
}
