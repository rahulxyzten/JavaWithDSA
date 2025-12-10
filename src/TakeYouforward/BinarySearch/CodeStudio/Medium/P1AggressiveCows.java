package TakeYouforward.BinarySearch.CodeStudio.Medium;
// Problem
/*
 Aggressive Cows

Problem statement
You are given an array 'arr' consisting of 'n' integers which denote the position of a stall.



You are also given an integer 'k' which denotes the number of aggressive cows.



You are given the task of assigning stalls to 'k' cows such that the minimum distance between any two of them is the maximum possible.



Print the maximum possible minimum distance.



Example:
Input: 'n' = 3, 'k' = 2 and 'arr' = {1, 2, 3}

Output: 2

Explanation: The maximum possible minimum distance will be 2 when 2 cows are placed at positions {1, 3}. Here distance between cows is 2.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
6 4
0 3 4 7 10 9


Sample Output 1 :
3


Explanation to Sample Input 1 :
The maximum possible minimum distance between any two cows will be 3 when 4 cows are placed at positions {0, 3, 7, 10}. Here distance between cows are 3, 4 and 3 respectively.


Sample Input 2 :
5 2
4 2 1 3 6


Sample Output 2 :
5


Expected time complexity:
Can you solve this in O(n * log(n)) time complexity?


Constraints :
2 <= 'n' <= 10 ^ 5
2 <= 'k' <= n
0 <= 'arr[i]' <= 10 ^ 9
Time Limit: 1 sec.
 */

import java.util.Arrays;

public class P1AggressiveCows {
    public static void main(String[] args) {

    }

    // Optimal Solution
    // T(C) = O(nlogn) + O(n * log(max[stalls] - min[stalls]))
    // S(C) = O(1)
    public static int aggressiveCows(int[] stalls, int k) {
        int n = stalls.length;
        if (k > n) return 0;

        Arrays.sort(stalls);
        int start = 1;
        int end = stalls[n - 1] - stalls[0];
        int result = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (canPlace(stalls, k, mid)) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }

    public static boolean canPlace(int[] stalls, int cows, int distance) {
        int count = 1;
        int lastPlace = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if ((stalls[i] - lastPlace) >= distance) {
                count++;
                lastPlace = stalls[i];
            }
            if (count >= cows) return true;
        }

        return false;
    }


    // Brute Force Approach
    // T(C) = O(nlogn) + O(n * (max[stalls] - min[stalls]))
    // S(C) = O(1)
//       for (int d = 1; d <= maxDist; d++) {
//        if (canPlace(stalls, cows, d)) {
//            ans = d;
//        }
//    }
}
