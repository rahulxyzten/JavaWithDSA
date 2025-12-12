package TakeYouforward.StackAndQueue.Leetcode.Easy;
//Problem
/*
20. Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false


Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 */

import java.util.Stack;

public class P3ValidParentheses {
    public static void main(String[] args) {
        String s = "[(()]";
        System.out.println(isValid(s));
    }

    // Optimal Solution (Using Stack)
    // T(C) = O(N)
    // S(C) = O(N)
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        // You can use for(char ch : s.toCharArray())
        // The time complexity and space complexity is same in both the case
        /*
        space used by the toCharArray() method, as it does not create a new array but simply
        returns a reference to the existing character array of the string.

        So, to clarify, the space complexity of the provided code is O(1) because the extra space used
        by the algorithm does not scale with the input size. Therefore, it's constant space complexity.
         */
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                st.push(s.charAt(i));
            } else {
                if (st.isEmpty()) return false;

                char temp = st.pop();
                if ((s.charAt(i) == ')' && temp == '(') || (s.charAt(i) == ']' && temp == '[') || (s.charAt(i) == '}' && temp == '{')) {
                    continue;
                } else {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }

    // Using an Array as a Stack
    // T(C) = O(N)
    // S(C) = O(N)
//    public static boolean isValid(String s) {
//        char[] st = new char[s.length()];
//        int j = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
//                st[j] = s.charAt(i);
//                j++;
//            } else {
//                if (j == 0) return false;
//
//                j--;
//                if ((s.charAt(i) == ')' && st[j] == '(') || (s.charAt(i) == ']' && st[j] == '[') || (s.charAt(i) == '}' && st[j] == '{')) {
//                    continue;
//                } else {
//                    return false;
//                }
//            }
//        }
//
//        return j == 0;
//    }
}
