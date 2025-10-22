package KunalKushwaha.Cp2ConditonalsLoop;

/*
Divisors of a Number

You are given an integer n. You need to find all the divisors of n. Return all the divisors of n as an array or list in a sorted order.



A number which completely divides another number is called it's divisor.


Examples:
Input: n = 6
Output = [1, 2, 3, 6]
Explanation: The divisors of 6 are 1, 2, 3, 6.

Input: n = 8
Output: [1, 2, 4, 8]
Explanation: The divisors of 8 are 1, 2, 4, 8.

Constraints:
1 <= n <= 1000
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Divisors {
    public static void main(String[] args) {
        int n = 6;
        int[] ans = divisors(n);
        System.out.println(Arrays.toString(ans));
    }

    //Brute Force Approach
//     Time Complexity: O(N), we check for every number from 1 to N.
//     Space Complexity: O(N), extra space used for storing divisors.
//    public static int[] divisors(int n) {
//        List<Integer> res = new ArrayList<>();
//
//        for (int i = 1; i <= n; i++) {
//            if (n % i == 0) {
//                res.add(i);
//            }
//        }
//
//        int[] ans = new int[res.size()];
//
//        for (int i = 0; i < res.size(); i++) {
//            ans[i] = res.get(i);
//        }
//
//        return ans;
//    }


    //Optimal Approach
    //We can optimise the previous approach by using the property that for any
    // non-negative integer n, if d is a divisor of n then n/d is also a divisor
    // of n. This property is symmetric about the square root of N. Thus,
    // by traversing just the first half we can avoid redundant iteration and
    // computations improving the efficiency of the algorithm.
    /* For the num 36
            1 x 36
            2 x 18
            3 x 12
            4×9
            6 x 6
            9 x 4 ( repeat )
            12 x 3
            18 x 2
            36 x 1
     */
    // Time Complexity: O(sqrt(N)), we check for every number between 1 and square root of N.
    // Space Complexity: O(2*sqrt(N)), extra space used for storing divisors.
    public static int[] divisors(int n) {
        List<Integer> res = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                res.add(i);

                if (i != n / i) { // for 6 x 6
                    res.add(n / i);
                }
            }
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}
