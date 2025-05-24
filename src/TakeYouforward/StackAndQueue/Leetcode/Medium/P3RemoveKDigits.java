package TakeYouforward.StackAndQueue.Leetcode.Medium;
//Problem
/*
402. Remove K Digits

Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.



Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.


Constraints:

1 <= k <= num.length <= 105
num consists of only digits.
num does not have any leading zeros except for the zero itself.
 */

import java.util.Stack;

public class P3RemoveKDigits {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(removeKdigits(num, k));

//        String num = "10200";
//        int k = 1;
//        System.out.println(removeKdigits(num, k));
    }

    //Optimal Solution
    //T(C) = O(N)
    //S(C) = O(N)
    public static String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";

        Stack<Character> stack = new Stack<>();
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && c < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) != '0') {
                return result.toString().substring(i, result.length());
            }
        }
        return "0";
    }
}
