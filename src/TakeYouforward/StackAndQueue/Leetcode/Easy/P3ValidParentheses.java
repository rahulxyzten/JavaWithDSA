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

    //T(C) = O(N)
    //S(C) = O(N)
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char c: s.toCharArray()){
            if (c == '(' || c == '[' || c == '{'){
                st.push(c);
            }
            else{
                if (st.isEmpty()) return false;
                char temp = st.pop();
                if ((c == ')' && temp == '(') || (c == ']' && temp =='[') || (c =='}' && temp == '{' ))
                    continue;
                else return false;
            }
        }
        return st.isEmpty();
    }
}
