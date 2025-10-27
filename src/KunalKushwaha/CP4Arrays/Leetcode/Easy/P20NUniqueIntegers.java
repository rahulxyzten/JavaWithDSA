package KunalKushwaha.CP4Arrays.Leetcode.Easy;
//Run the 2 code and check the text case if field then fix this
/*
1304. Find N Unique Integers Sum up to Zero

Given an integer n, return any array containing n unique integers such that they add up to 0.

Example 1:

Input: n = 5
Output: [-7,-1,1,3,4]
Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
Example 2:

Input: n = 3
Output: [-1,0,1]
Example 3:

Input: n = 1
Output: [0]

Constraints:
1 <= n <= 1000
 */

import java.util.Arrays;

public class P20NUniqueIntegers {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumZero(5)));
    }

    // T(C) = O(n)
    // The loop executes n/2 times.
    // Each iteration performs two constant-time assignments so 2 * (n/2) = o(n)
    // S(C) = O(n)
    public static int[] sumZero(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n / 2; i++) {
            result[i] = -(i + 1);
            result[n - 1 - i] = (i + 1);
        }
        return result;
    }
//      for n = 6
//            0 -> 5 (6-1-0)
//            1 -> 4 (6-1-1)
//            2 -> 3 (6-1-2)
//
//      for n = 3
//            0 -> 2 (3-1-0)
//            loop break and at the 1 index 0 is already present.


    //   //Wrong code//
//    public static int[] sumZero(int n) {
//        int[] result = new int[n];
//        for (int i = 0; i < (n - 1)/2; i ++) {
//            result[i] = i + 1;
//            result[i+1] = -(i + 1);
//        }
//        return result;
//    }
}
