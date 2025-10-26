package KunalKushwaha.CP4Arrays.Leetcode.Easy;

/*
1832. Check if the Sentence Is Pangram

A pangram is a sentence where every letter of the English alphabet appears at least once.

Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.



Example 1:

Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English alphabet.
Example 2:

Input: sentence = "leetcode"
Output: false


Constraints:

1 <= sentence.length <= 1000
sentence consists of lowercase English letters.
*/

public class P11StringPangram {
    public static void main(String[] args) {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println(checkIfPangram(sentence));
    }


    /* Memory more but time is 0ms */
//    public static boolean checkIfPangram(String sentence) {
//        if(sentence.length() < 26) {
//            return false;
//        }
//        String alphabets = "abcdefghijklmnopqrstuvwxyz";
//        for(int i = 0; i < alphabets.length(); i++) {
//            if(sentence.indexOf(alphabets.charAt(i)) == -1) {
//                return false;
//            }
//        }
//        return true;
//    }


    /*Below code for applicable for if the string in small letters*/
    // If it also tells for the capital letter then we have to increase the size of
    //  the array to 56 and do some modification to solve the problem
    // T(C) = O(N) and S(C) = O(1)

    public static boolean checkIfPangram(String sentence) {
        int[] ans = new int[26];

        for (int i = 0; i < sentence.length(); i++) {
            int index = sentence.charAt(i) - 'a';
            ans[index] = 1;
        }

        for (int num : ans) {
            if (num == 0) return false;
        }

        return true;
    }

//    public static boolean checkIfPangram(String sentence) {
//        int[] a = new int[26];  // An array to keep track of each letter's occurrence
//
//        for (char c : sentence.toCharArray()) {
//            int index = c - 'a';  // Calculate the index corresponding to the current character
//            a[index] = 1;         // Mark the letter as encountered
//        }
//
//        // Check if all 26 letters have been encountered
//        for (int i = 0; i < 26; i++) {
//            if (a[i] == 0) {
//                return false;  // If any letter is missing, return false
//            }
//        }
//
//        return true;  // All 26 letters have been encountered, return true
//    }


    /*Below code for applicable for if the string in small letters or capital letters*/
    // T((C) = O(N) and S(C) = O(N)
//        public static boolean checkIfPangram(String sentence) {
//        Set<Character> hset = new HashSet<>();
//
//        for (char ch : sentence.toCharArray())
//            hset.add(ch);
//
//        return hset.size() == 26;
//    }

}
