package KunalKushwaha.Cp6String.Leetcode.Easy;
//Problem
/*
242. Valid Anagram

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 typically using all the original letters exactly once.



Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false


Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.


Follow up: What if the inputs contain Unicode characters? How would you adapt your
solution to such a case?
 */

public class P6ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }


    //Optimal Solution
    //T(C) = O(N) and S(C) = O(1)
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] mpp1 = new int[130];
        for (int i = 0; i < s.length(); i++) {
            mpp1[s.charAt(i)]++;
            mpp1[t.charAt(i)]--;
        }

        for (int count : mpp1) {
            if (count != 0) return false;
        }

        return true;
    }


    // Brute Force Approach
    // T(C) = O(N)
    // S(C) = O(1)
    // But here, 2 arrays are used, although the space complexity S(C) = (1)
    // Still, it takes more space
//    public static boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) return false;
//
//        int[] mpp1 = new int[130];
//        int[] mpp2 = new int[130];
//        for (int i = 0; i < s.length(); i++) {
//            mpp1[s.charAt(i)]++;
//            mpp2[t.charAt(i)]++;
//        }
//
//        for (int i = 0; i < mpp1.length; i++) {
//            if (mpp1[i] != mpp2[i])
//                return false;
//        }
//
//        return true;
//    }
}
