package KunalKushwaha.Cp6String.Leetcode.Easy;
//Problem
/*
14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
 */

import java.util.Arrays;

public class P3LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
//        String[] strs = {"dog", "racecar", "car"};
//        String str = "rahul";
//        System.out.println(str.indexOf(""));
        System.out.println(longestCommonPrefix(strs));
    }

    // Optimal Solution
    // T(C) = O(N * logN) + O(M)
    // N = number of strings
    // M = minimum length of a string
    // S(C) = O(M)
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return result.toString();
            } else {
                result.append(first.charAt(i));
            }
        }

        return result.toString();
    }

    // Brute Force Approach
    // T(C) = O(strs.[0].length() * strs.length)
    // S(C) = O(strs[0].length())
    /*
    i == strs[j].length() means any other sting is smaller than first sting
    example ["flower","flow","flowht"]
    The for break at when i == strs[1].length() then return "flow"
     */
//    public static String longestCommonPrefix(String[] strs) {
//        for (int i = 0; i < strs[0].length(); i++) {
//            for (int j = 1; j < strs.length; j++) {
//                if (i == strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
//                    return strs[0].substring(0, i);
//                }
//            }
//        }
//
//        return strs[0];
//    }


    // By using In-build function -> indexOf()
    /*
    T(C) = O(n * m), where n is the number of strings in the array, and m is the length of the longest string.
    S(C) = O(m), where m is the length of the longest string, as we store the prefix string.
     */
    // Go for the dry run if not understand
    /* DRY RUN
        Flower => prefix = Flower
        Flow => prefix = Flow
        Flight => prefix = Fl
        return Fl;
     */
//    public static String longestCommonPrefix(String[] strs) {
//        String prefix = strs[0];
//        for (String s : strs)
//            while (s.indexOf(prefix) != 0)
//                prefix = prefix.substring(0, prefix.length() - 1);
//        return prefix;
//    }
}
