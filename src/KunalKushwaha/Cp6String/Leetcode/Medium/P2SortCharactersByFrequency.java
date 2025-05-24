package KunalKushwaha.Cp6String.Leetcode.Medium;
//Problem
/*
451. Sort Characters By Frequency

Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.



Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.


Constraints:

1 <= s.length <= 5 * 105
s consists of uppercase and lowercase English letters and digits.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class P2SortCharactersByFrequency {
    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }

    //Optimal Solution (Bucket Sort)
    //T(C) = O(n)
    //S(C) = O(n)
    public static String frequencySort(String s) {
        StringBuilder result = new StringBuilder();

        HashMap<Character, Integer> mpp = new HashMap<>();
        for (char c : s.toCharArray()) {
            mpp.put(c, mpp.getOrDefault(c, 0) + 1);
        }

        List<Character>[] arr = new ArrayList[s.length() + 1];
        //declares an array of lists. Each element of the array is a list that can hold Character objects.


        for (char c : mpp.keySet()) {
            if (arr[mpp.get(c)] == null) {
                arr[mpp.get(c)] = new ArrayList<>();
            }
            arr[mpp.get(c)].add(c);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] != null) {
                for (Character c : arr[i]) {
                    for (int j = 0; j < i; j++) {
                        result.append(c);
                    }
                }
            }
        }

        return result.toString();
    }

    //BruteForce Approach (HashTable + Sort)
    //T(C) = O(nlogn)
    //S(C) = O(n)
//    public static String frequencySort(String s) {
//        StringBuilder result = new StringBuilder();
//
//        //Count the occurrence on each character
//        HashMap<Character, Integer> mpp = new HashMap<>();
//        for (char c : s.toCharArray()) {
//            mpp.put(c, mpp.getOrDefault(c, 0) + 1);
//        }
//
//        //Sorting the keySet according to keyValue
//        List<Character> chars = new ArrayList<>(mpp.keySet());
//        Collections.sort(chars, (a, b) -> (mpp.get(b) - mpp.get(a)));
//        /*
//        The Collections.sort() method sorts the list chars using a comparator.
//        In this case, a lambda expression (a, b) -> (mpp.get(b) - mpp.get(a)) is
//        used as the comparator.
//        Comparator Explanation: The lambda expression (a, b) -> (mpp.get(b) - mpp.get(a))
//        compares two characters a and b based on their respective values in the mpp HashMap.
//        Here's how it works:
//        mpp.get(b) retrieves the value (occurrence count) associated with the character b in the mpp HashMap.
//        mpp.get(a) retrieves the value (occurrence count) associated with the character a in the mpp HashMap.
//        The result of (mpp.get(b) - mpp.get(a)) is then used for comparison.
//        If the result is negative, it means b has a smaller occurrence count than a, so b should come before a in the sorted list.
//        If the result is positive, it means b has a larger occurrence count than a, so b should come after a in the sorted list.
//        If the result is zero, it means both a and b have the same occurrence count, so their relative order in the sorted list is not changed.
//         */
//
//        //Build String
//        for (char c : chars) {
//            for (int i = 0; i < mpp.get(c); i++) {
//                result.append(c);
//            }
//        }
//
//        return result.toString();
//    }


}
