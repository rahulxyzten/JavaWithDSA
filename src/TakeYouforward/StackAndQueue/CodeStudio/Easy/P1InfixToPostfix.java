package TakeYouforward.StackAndQueue.CodeStudio.Easy;
//Problem
/*
 Infix To Postfix

You are given a string 'exp' which is a valid infix expression.



Convert the given infix expression to postfix expression.



Note:
Infix notation is a method of writing mathematical expressions in which operators are placed between operands.

For example, "3 + 4" represents the addition of 3 and 4.

Postfix notation is a method of writing mathematical expressions in which operators are placed after the operands.

For example, "3 4 +" represents the addition of 3 and 4.

Expression contains digits, lower case English letters, ‘(’, ‘)’, ‘+’, ‘-’, ‘*’, ‘/’, ‘^’.


Example:
Input: exp = ‘3+4*8’

Output: 348*+

Explanation:
Here multiplication is performed first and then the addition operation. Hence postfix expression is  3 4 8 * +.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
3^(1+1)

Expected Answer:
311+^


Output printed on console:
311+^


Explanation of Sample Input 1:
For this testcase, we will evaluate 'b' = (1+1) first.

Hence it's equivalent postfix expression will be "11+".

Next we will evaluate 3^b. It's equivalent postfix expression will be "3b^".

Replacing 'b' with it's equivalent postfix we get "311+^".


Sample Input 2:
a+b+c+d-e


Expected Answer:
ab+c+d+e-


Output printed on console:
ab+c+d+e-


Expected Time Complexity:
Try to do this in O(n).


Constraints:
1 <= 'n' <= 5000

‘n’, is the length of EXP
The expression contains digits, lower case English letters, ‘(’, ‘)’, ‘+’, ‘-’, ‘*’, ‘/’, ‘^’.

Time Limit: 1 sec
 */

import java.util.Stack;

public class P1InfixToPostfix {
    public static void main(String[] args) {
//        String exp = "3^(1+1)";
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(exp));
    }

    //T(C) = O(N)
    //S(C) = O(N)
    public static String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder(new String(""));
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            } else if (ch == '(') {
                s.push(ch);
            } else if (ch == ')') {
                while (!s.isEmpty() && s.peek() != '(') {
                    result.append(s.pop());
                }
                s.pop();
            } else {
                while (!s.isEmpty() && precedence(ch) <= precedence(s.peek())) {
                    result.append(s.pop());
                }
                s.push(ch);
            }
        }

        while (!s.isEmpty()) {
            if (s.peek() == '(') return "Invalid Expression";
            result.append(s.pop());
        }

        return result.toString();
    }

    public static int precedence(char ch) {
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }
}
