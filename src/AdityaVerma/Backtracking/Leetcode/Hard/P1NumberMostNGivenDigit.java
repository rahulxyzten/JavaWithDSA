package AdityaVerma.Backtracking.Leetcode.Hard;
//problem
/*
902. Numbers At Most N Given Digit Set

Given an array of digits which is sorted in non-decreasing order. You can write numbers using each digits[i] as many times as we want. For example, if digits = ['1','3','5'], we may write numbers such as '13', '551', and '1351315'.

Return the number of positive integers that can be generated that are less than or equal to a given integer n.

Example 1:

Input: digits = ["1","3","5","7"], n = 100
Output: 20
Explanation:
The 20 numbers that can be written are:
1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
Example 2:

Input: digits = ["1","4","9"], n = 1000000000
Output: 29523
Explanation:
We can write 3 one digit numbers, 9 two digit numbers, 27 three digit numbers,
81 four digit numbers, 243 five digit numbers, 729 six digit numbers,
2187 seven digit numbers, 6561 eight digit numbers, and 19683 nine digit numbers.
In total, this is 29523 integers that can be written using the digits array.
Example 3:

Input: digits = ["7"], n = 8
Output: 1


Constraints:

1 <= digits.length <= 9
digits[i].length == 1
digits[i] is a digit from '1' to '9'.
All the values in digits are unique.
digits is sorted in non-decreasing order.
1 <= n <= 10^9
 */

public class P1NumberMostNGivenDigit {
    public static void main(String[] args) {
//        String[] digits = {"1", "3", "5", "7"};
//        int n = 100;

        String[] digits = {"1", "4", "9"};
        int n = 1000000000;

//        String[] digits = {"7"};
//        int n = 8;

        System.out.println(atMostNGivenDigitSet(digits, n));
    }

    // The code is works for small n, because the code correctly generates all possible
    // combinations of the given digits (1 <= n <= 10^9)
    // It hit TLE (Time Limit Exceeded) or StackOverflowError for very large inputs due to brute-force enumeration.
//    public static int atMostNGivenDigitSet(String[] digits, int n) {
//        int[] nums = new int[digits.length];
//        for (int i = 0; i < digits.length; i++) {
//            nums[i] = Integer.parseInt(digits[i]);
//        }
//        int[] result = new int[1];
//
//        solve(nums, n, 0, result);
//        return result[0];
//    }
//
//    public static void solve(int[] nums, int n, int ans, int[] result) {
//        if (ans > n) return;
//
//        for (int i = 0; i < nums.length; i++) {
//            int temp = ans * 10 + nums[i];
//            if (temp <= n) result[0]++;
//            solve(nums, n, temp, result);
//        }
//    }


    public static int solve(String digits[], int m, String nstr, int noOfDigits, int index) {
        if (index >= noOfDigits) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            char ch = digits[i].charAt(0);
            if (ch == nstr.charAt(index)) {
                ans += solve(digits, m, nstr, noOfDigits, index + 1);
            } else if (ch < nstr.charAt(index)) {
                ans += (int) Math.pow(m, noOfDigits - index - 1);
            }
        }
        return ans;
    }

    public static int atMostNGivenDigitSet(String[] digits, int n) {
        int m = digits.length;
        String nstr = Integer.toString(n);
        int noOfDigits = nstr.length();
        int ans = 0;
        for (int i = 1; i < noOfDigits; i++) {
            ans += (int) Math.pow(m, i);
        }
        ans += solve(digits, m, nstr, noOfDigits, 0);
        return ans;
    }
}
