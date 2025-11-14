package TakeYouforward.Recursion.CodeStudio.Easy;
//Problem
/*
1 to N Without Loop

Problem statement
You are given an integer ‘n’.



Your task is to return an array containing integers from 1 to ‘n’ (in increasing order) without using loops.



Example:
Input: ‘n’ = 5

Output: 1 2 3 4 5

Explanation: An array containing integers from ‘1’ to ‘n’ is [1, 2, 3, 4, 5].
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
5
Sample Output 1 :
1 2 3 4 5
Explanation Of Sample Input 1:
The array contains all integers from 1 to 5 in ascending order.
Sample Input 2:
2
Sample Output 2:
1 2
Explanation Of Sample Input 2:
The array contains all integers from 1 to 2 in ascending order.
Expected Time Complexity:
The expected time complexity is O(n), where 'n' is the given integer.
Constraints:
1 <= n <= 10^6

Time Limit: 1-sec
 */

import java.util.Arrays;

public class P1Print1toNWithoutLoop {
    public static void main(String[] args) {
        int x = 5;
        System.out.println(Arrays.toString(printNos(x)));
    }

    // T(C) = O(N)
    // S(C) = O(N), stack space used for recursive calls.
    // Backtracking
    public static int[] printNos(int x) {
        int[] arr = new int[x];
        print(arr, x);
        return arr;
    }

    public static void print(int[] arr, int x) {
        if (x == 1) {
            arr[x - 1] = x;
            return;
        }
        print(arr, x - 1);
        arr[x - 1] = x;
    }

    // Forward Recursion
//    public static int[] printNos(int x) {
//        int[] arr = new int[x];
//        print(arr, 0, x);
//        return arr;
//    }
//
//    public static void print(int[] arr, int i, int n) {
//        if (i == n) return;
//        arr[i] = i + 1;
//        print(arr, i + 1, n);
//    }
}
