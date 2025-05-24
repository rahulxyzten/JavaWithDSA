package KunalKushwaha.Cp6String.Leetcode.Easy;
//Problem
/*
1021. Remove Outermost Parentheses

A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.

For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.

Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.

Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.



Example 1:

Input: s = "(()())(())"
Output: "()()()"
Explanation:
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
Example 2:

Input: s = "(()())(())(()(()))"
Output: "()()()()(())"
Explanation:
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
Example 3:

Input: s = "()()"
Output: ""
Explanation:
The input string is "()()", with primitive decomposition "()" + "()".
After removing outer parentheses of each part, this is "" + "" = "".


Constraints:

1 <= s.length <= 105
s[i] is either '(' or ')'.
s is a valid parentheses string.
 */

public class P1RemoveOutermostParentheses {
    public static void main(String[] args) {
        String s = "(()())(())";
        System.out.println(removeOuterParentheses(s));
    }

    //BEST CODE T(C) = O(N) & S(C) = O(N)
    public static String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (char c : s.toCharArray()){
            if (c == '('){
                if (count > 0) result.append(c);
                count++;
            }
            else {
                count--;
                if (count > 0) result.append(c);
            }
        }
        //The count is == 0 when it comes to outer parenthesis so in that
        //not insert the bracket and another time insert the bracket
        return result.toString();
    }

//    public static String removeOuterParentheses(String s) {
//        StringBuilder result = new StringBuilder();
//        int count = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i)== '('){
//                if (count > 0){
//                    result.append("(");
//                }
//                count++;
//            }else {
//                count--;
//                if (count > 0){
//                    result.append(")");
//                }
//            }
//        }
//
//        return result.toString();
//    }
}
