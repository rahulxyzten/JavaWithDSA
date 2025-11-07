package TakeYouforward.BinarySearch.CodeStudio.Easy;
//Problem
/*
 Square Root of a number

Problem statement
You are given a positive integer ‘n’.



Your task is to find and return its square root. If ‘n’ is not a perfect square, then return the floor value of sqrt(n).



Example:
Input: ‘n’ = 7

Output: 2

Explanation:
The square root of the number 7 lies between 2 and 3, so the floor value is 2.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
6
Sample Output 1:
2
Explanation of Sample Input 1:
The square root of the given number 6 lies between 2 and 3, so the floor value is 2.
Sample Input 2:
100
Sample Output 2:
10
Explanation of Sample Output 2:
The square root of the given number 100 is 10.
Expected Time Complexity:
Try solving this in O(log(n)).
Constraints:
0 <= n <= 10 ^ 9

Time Limit: 1 sec.
 */

public class P4SquareRootOfANumber {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(sqrtN(n));
    }

    //Optimal Solution T(C) = logn & S(C) = O(1)
    public static int sqrtN(long N) {
        long start = 1, end = N;
        long result = 0; //0 <= n <= 10 ^ 9

        while (start <= end) {
            long mid = start + (end - start) / 2;
            long val = mid * mid;
            if (val == N) return (int) mid;
            else if (val < N) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return (int) result;
    }
}
