package KunalKushwaha.Cp6String.Leetcode.Medium;
//Problem
/*
151. Reverse Words in a String

Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.



Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.


Constraints:

1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.


Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
 */

import java.util.ArrayList;

public class P1ReverseWordsInString {
    public static void main(String[] args) {
//        String s = "the sky is blue";
//        String s = "  hello world  ";
        String s = "a good   example";
//        String s = "   ab   cd ra  ";
        System.out.println(reverseWords(s));
    }


    // Optimal Approach
    // T(C) = O(N)
    // N is the length of the string
    // S(C) = O(N), Answer Space
    public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();

        int i = s.length() - 1;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') i--;

            if (i < 0) break;

            int end = i;

            while (i >= 0 && s.charAt(i) != ' ') i--;

            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(s.substring(i + 1, end + 1));
        }

        return result.toString();
    }


    // Better Approach
    // T(C) = O(N + M)
    // N is the length of the string, M is the number of words in the string.
    // S(C) = O(M + N)
    public static String reverseWords(String s) {
        ArrayList<String> words = new ArrayList<>();
        int n = s.length();
        int start, end;

        int i = 0;
        while (i < n) {
            while (i < n && s.charAt(i) == ' ') i++;

            if (i >= n) break;

            start = i;

            while (i < n && s.charAt(i) != ' ') i++;
            end = i;

            words.add(s.substring(start, end));
        }


        StringBuilder result = new StringBuilder();
        for (int j = words.size() - 1; j >= 0; j--) {
            result.append(words.get(j));

            if (j != 0) result.append(" ");
        }

        return result.toString();
    }

    // Direct Better Approach
//    public static String reverseWords(String s) {
//        String[] str = s.trim().split("\\s+");
//        //trim and split take O(N)
//        StringBuilder out = new StringBuilder();
//        for (int i = str.length - 1; i >= 0; i--) {
//            if (i == 0) {
//                out.append(str[i]);
//            } else {
//                out.append(str[i]).append(" ");
//            }
//        }
//        return out.toString();
//    }


    // My Brute force Approach
    // T(C) = O(3N) + O(M)
    //  S(C) = O(2N) + O(M)
    // Extra time O(2N) and space O(N) for this s = s.trim().replaceAll("\\s+", " ");
    public static String reverseWords(String s) {
        s = s.trim().replaceAll("\\s+", " ");
        // trim and split takes O(N)

        ArrayList<String> ls = new ArrayList<>();
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                ls.add(s.substring(start, i));
                start = i + 1;
            }
        }
        ls.add(s.substring(start));

//        ArrayList<String> ls = new ArrayList<>();
//        StringBuilder words = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == ' ') {
//                ls.add(words.toString());
//                words.setLength(0);
//            } else {
//                words.append(s.charAt(i));
//            }
//        }
//        ls.add(words.toString());

        StringBuilder result = new StringBuilder();
        for (int i = ls.size() - 1; i >= 0; i--) {
            result.append(ls.get(i));

            if (i != 0) result.append(" ");
        }

        return result.toString();
    }

    /*
    \s: This part represents a single whitespace character. Whitespace characters
        include spaces, tabs, newlines, carriage returns, and other similar characters.
    "+": This quantifier means "one or more occurrences of the preceding element"
         (in this case, the whitespace character).
    "\\s+": together means "one or more whitespace characters."
     */

}
