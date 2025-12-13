package KunalKushwaha.Cp6String.Leetcode.Easy;
//Problem
/*
205. Isomorphic Strings

Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.



Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true


Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.
 */

public class P4IsomorphicStrings {
    public static void main(String[] args) {
//        String s = "egg", t = "add";
//        String s = "foo", t = "bar";
        String s = "paper", t = "title";
        System.out.println(isIsomorphic(s, t));
    }


    //T(C) = O(N) and S(C) = O(1)
    // Because the size of mpp1 and mpp2 each of size 256.
    // The space required by these arrays is constant,
    // as it does not depend on the input size.
    public static boolean isIsomorphic(String s, String t) {
        int[] mpp1 = new int[256];
        int[] mpp2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (mpp1[s.charAt(i)] != mpp2[t.charAt(i)])
                return false;

            mpp1[s.charAt(i)] = i + 1;
            mpp2[t.charAt(i)] = i + 1;
        }

        return true;
    }
}
