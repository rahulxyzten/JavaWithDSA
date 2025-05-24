package TakeYouforward.Recursion.LeetCode.Easy;
//problem
/*
125. Valid Palindrome

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.


Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
 */

public class P1ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
//     String s = "abaaaa";
        System.out.println(isPalindrome(s));
    }


    //using Recursion
    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        //[^a-zA-Z0-9] mans all characters containing [^a-zA-Z0-9] is in the string and all
        //other non-alphanumeric characters are set to ""
        //after removing all uppercase are converted to lowercase

        return check(s, 0);
    }

    public static boolean check(String s, int i) {
        int n = s.length();
        if (i >= n / 2) return true;
        if (s.charAt(i) != s.charAt(n - i - 1)) return false;

        return check(s, i + 1);
    }


//    Not using Recursion
//    public static boolean isPalindrome(String s) {
//        int left = 0, right = s.length() - 1;
//        while (left < right){
//            char l = s.charAt(left), r = s.charAt(right);
//            if (!Character.isLetterOrDigit(l)) left++;
//            else if(!Character.isLetterOrDigit(r)) right--;
//            else if(Character.toLowerCase(l) != Character.toLowerCase(r)) return  false;
//            else { //this is condition if both are same
//                left++;
//                right--;
//            }
//        }
//        return true;
//    }
}
