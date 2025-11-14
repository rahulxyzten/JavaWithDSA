package TakeYouforward.Recursion.CodeStudio.Easy;
//problem
/*
 N to 1 without loop

Problem statement
You are given an integer ‘n’.



Your task is to return an array containing integers from ‘n’ to ‘1’ (in decreasing order) without using loops.



Note:
In the output, you will see the array returned by you.
Example:
Input: ‘n’ = 5

Output: 5 4 3 2 1

Explanation: An array containing integers from ‘n’ to ‘1’ is [5, 4, 3, 2, 1].
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
5
Sample Output 1 :
5 4 3 2 1
Explanation Of Sample Input 1:
Input: ‘n’ = 5

Output: 5 4 3 2 1

Explanation: An array containing integers from ‘5’ to ‘1’ is [5, 4, 3, 2, 1].
Sample Input 2:
2
Sample Output 2:
2 1
Explanation Of Sample Input 2:
Input: ‘n’ = 2

Output: 2 1

Explanation: An array containing integers from ‘2’ to ‘1’ is [2, 1].
Expected Time Complexity:
The expected time complexity is O(n), where 'n' is the given integer.
Expected Space Complexity:
The expected space complexity is O(n), where 'n' is the given integer.
Constraints:
1 <= n <= 10^4

Time Limit: 1-sec
 */

import java.util.Arrays;

public class P1PrintNto1WithoutLoop {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.toString(printNos(n)));
    }

    // T(C) = O(N)
    // S(C) = O(N), stack space used for recursive calls.
    public static int[] printNos(int x) {
        int[] arr = new int[x];
        print(arr, x, x);
        return arr;
    }

    public static void print(int[] arr, int x, int n) {
        if (x == 0) return;
        arr[n - x] = x;
        print(arr, x - 1, n);
    }
}
