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

import java.util.*;

public class P2SortCharactersByFrequency {
    public static void main(String[] args) {
//        String s = "tree";
        String s = "Aabb";
        System.out.println(frequencySort(s));
    }

    //Optimal Solution (Bucket Sort)
    //T(C) = O(n) + O(n) + O(n) = O(n)
    //S(C) = O(n) + O(n) = O(n)
    public static String frequencySort(String s) {
        StringBuilder result = new StringBuilder();

        // Step - 1
        HashMap<Character, Integer> mpp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            mpp.put(s.charAt(i), mpp.getOrDefault(s.charAt(i), 0) + 1);
        }

        // Step - 2
        List<Character>[] arr = new ArrayList[s.length() + 1];
        // declares an array of lists. Each element of the array is a list that can hold (Character objects)
        for (char ch : mpp.keySet()) {
            if (arr[mpp.get(ch)] == null) {
                arr[mpp.get(ch)] = new ArrayList<>();
            }
            arr[mpp.get(ch)].add(ch);
        }

        // Step - 3
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] != null) {
                for (char ch : arr[i]) {
                    for (int j = 0; j < i; j++) {
                        result.append(ch);
                    }
                }
            }
        }

        return result.toString();
    }


    // Brute Force Approach (HashTable + Sort)
    // T(C) = O(n) + O(nlogn) + O(n) = O(n + nlogn)
    // S(C) = O(n) + O(n) + O(n) = O(n)
//    public static String frequencySort(String s) {
//        StringBuilder result = new StringBuilder();
//
//        //Count the occurrence on each character
//        HashMap<Character, Integer> mpp = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            mpp.put(s.charAt(i), mpp.getOrDefault(s.charAt(i), 0) + 1);
//        }
//
//        //Sorting the keySet according to keyValue
//        List<Character> chars = new ArrayList<>(mpp.keySet());
//        Collections.sort(chars, (a, b) -> (mpp.get(b) - mpp.get(a)));
//
//        //Build String
//        for (char ch : chars) {
//            for (int i = 0; i < mpp.get(ch); i++) {
//                result.append(ch);
//            }
//        }
//
//        return result.toString();
//    }
}


// TUF Problem
// Optimal Approach
// T(C) = O(n) + O(nlogn) + O(n) = O(n + nlogn)
// S(C) =  O(k), where k is the constant 26 for the frequency array.
//class Pair {
//    int freq;
//    char ch;
//
//    Pair(int freq, char ch) {
//        this.freq = freq;
//        this.ch = ch;
//    }
//}
//
//    public List<Character> frequencySort(String s) {
//        Pair[] freqArray = new Pair[26];
//
//        for (int i = 0; i < 26; i++) {
//            freqArray[i] = new Pair(0, (char) ('a' + i));
//        }
//
//        for (int i = 0; i < s.length(); i++) {
//            freqArray[s.charAt(i) - 'a'].freq++;
//        }
//
//        Arrays.sort(freqArray, (p1, p2) -> {
//            if (p1.freq != p2.freq) return p2.freq - p1.freq;
//            return p1.ch - p2.ch;
//        });
//
//        List<Character> result = new ArrayList<>();
//        for (Pair pair : freqArray) {
//            if (pair.freq > 0) result.add(pair.ch);
//        }
//
//        return result;
//    }
