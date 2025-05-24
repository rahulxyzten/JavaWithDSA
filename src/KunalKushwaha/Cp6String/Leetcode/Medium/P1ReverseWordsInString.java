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

public class P1ReverseWordsInString {
    public static void main(String[] args) {
//        String s = "the sky is blue";
//        String s = "  hello world  ";
//        String s = "a good   example";
        String s = "   ab   cd ra  ";
        System.out.println(reverseWords(s));
    }



    //T(C) = O(N + M) and S(C) = O(N + M)
    /*
Time Complexity (T(C)):

The code first trims the input string using trim(), which takes O(N) time, where N is the length of the input string.
Then, it splits the string using split("\\s+"), where "\s+" is a regular expression to split the string based on one or more whitespace characters. This also takes O(N) time.
The for loop runs for the number of words in the string (the length of the array after splitting), so its time complexity is O(M), where M is the number of words in the string.
Inside the loop, the StringBuilder out is updated, and each append operation takes constant time.
Combining these steps, the overall time complexity is O(N + M).

Space Complexity (S(C)):

The space complexity is determined by the space used to store the array str, which contains the individual words after splitting the string. The size of this array is proportional to the number of words in the string, so its space complexity is O(M).
The StringBuilder out is used to construct the reversed string. In the worst case, the length of the reversed string is equal to the length of the input string. Therefore, the space complexity of out is also O(N).
Combining these space complexities, the overall space complexity is O(N + M).

In summary:

Time Complexity (T(C)): O(N + M)
Space Complexity (S(C)): O(N + M)
     */
    public static String reverseWords(String s) {
        String[] str = s.trim().split("\\s+");
        //trim and split take O(N)
        StringBuilder out = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            if (i == 0) {
                out.append(str[i]);
            } else {
                out.append(str[i]).append(" ");
            }
        }
        return out.toString();
    }

    /*
    \s: This part represents a single whitespace character. Whitespace characters
        include spaces, tabs, newlines, carriage returns, and other similar characters.
    "+": This quantifier means "one or more occurrences of the preceding element"
         (in this case, the whitespace character).
    "\\s+": together means "one or more whitespace characters."
     */

    /*My solution */
//    public static String reverseWords(String s) {
//        s = s.replaceAll("\\s+", " ");
//        s = s.trim();
//        String[] arr = s.split(" ");
//        int start = 0, end = arr.length - 1;
//        while (start < end) {
//            String temp = arr[end];
//            arr[end] = arr[start];
//            arr[start] = temp;
//            start++;
//            end--;
//        }
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < arr.length; i++) {
//            if (i == arr.length - 1) {
//                result.append(arr[i]);
//            } else {
//                result.append(arr[i]).append(" ");
//            }
//        }
//        return result.toString();
//    }



    /* Short code but long time O(n^2) */
//    public static String reverseWords(String s) {
//        String result = "";
//        int i = 0;
//        int n = s.length();
//        while (i < n) {
//            while (i < n && s.charAt(i) == ' ') i++;
//            if (i >= n) break;
//            int j = i + 1;
//            while (j < n && s.charAt(j) != ' ') j++;
//            String sub = s.substring(i, j);
//            if (result.length() == 0) result = sub;
//            else result = sub + " " + result;
//            i = j + 1;
//        }
//        return result;
//    }

    //Why this code is not work (WRONG CODE FOR ABOVE QUESTION)
    //This is wrong code if not clear then go for dry run and check that it is give wrong ans
    //It is work for only this type of input
    //Input: s=”this is an amazing program”
    //Output: “program amazing an is this”
    //if the input like this it gives wrong ans
    //input: s = "   ab   cd ra  "
    //output: " ra cd   ab"
    //Go for the first solution which complexity is T(C) = O(N) and S(C) = O(N)
    //T(C) = O(N) and S(C) = O(1)
//    public static String reverseWords(String s) {
//        int left = 0, right = s.length() - 1;
//        String ans = "", temp = "";
//        while (left <= right) {
//            char ch = s.charAt(left);
//            if (ch != ' ') {
//                temp += ch;
//            } else {
//                if (ans.equals("")) {
//                    ans = temp;
//                } else {
//                    ans = temp + " " + ans;
//                }
//                temp = "";
//            }
//            left++;
//        }
//        if (!temp.equals("")) {
//            if (ans.equals("")) {
//                ans = temp;
//            } else {
//                ans = temp + " " + ans;
//            }
//        }
//
//        return ans;
//    }

}
