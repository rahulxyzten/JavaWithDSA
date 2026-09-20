package TakeYouforward.BinarySearch.CodeStudio.Easy;

// Problem (GFG)
/*
Row with Max 1s in Rowwise Sorted

Given a 2D binary array arr[][] of size n*m consisting of only 1s and 0s. Each row of the array is sorted in non-decreasing order. Find and return the index of the first row that contains the maximum number of 1s. If no such row exists, return -1.

Note: The array follows 0-based indexing.

Examples:

Input: arr[][] = [[0,1,1,1], [0,0,1,1], [1,1,1,1]]
Output: 2
Explanation: Row 2 contains the most number of 1s (4 - 1s). Hence, the output is 2.
Input: arr[][] = [[0,0], [1,1]]
Output: 1
Explanation: Row 1 contains the most number of 1s (2 - 1s). Hence, the output is 1.
Input: arr[][] = [[0,0], [0,0]]
Output: -1
Explanation: No row contains any 1s, so the output is -1.
Constraints:

1 ≤ n, m ≤ 10^3
0 ≤ arr[i][j] ≤ 1
 */

public class P3FindRowWithMaxNumberOf1S {
    public static void main(String[] args) {
        int[][] arr = {{0, 1, 1, 1}, {0, 0, 1, 1}, {1, 1, 1, 1}};
        System.out.println(rowWithMax1s(arr));
    }


    /* Optimal Approach */
    // T(C) = O(n + m)
    // S(C) = O(1)
    public static int rowWithMax1s(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        int i = 0, j = m - 1;
        int ans = -1;

        while (j >= 0 && i < n) {
            if (arr[i][j] == 1) {
                ans = i;
                j--;
            } else i++;
        }

        return ans;
    }

    /* Better Approach */
    // T(C) = O(n*logm)
    // S(C) = O(1)
//    public static int rowWithMax1s(int[][] arr) {
//        int n = arr.length, m = arr[0].length;
//        int ans = -1;
//        int countMax = 0, index = -1;
//        for (int i = 0; i < n; i++) {
//            int countRow1S = m - firstOccurrence(arr[i], m, 1);
//            if (countRow1S > countMax) {
//                countMax = countRow1S;
//                ans = i;
//            }
//        }
//
//        return ans;
//    }
//
//    public static int firstOccurrence(int[] arr, int m, int ele) {
//        int start = 0, end = m - 1;
//        int result = m;
//        // here the default of index must be change to -1 to m
//
//        while (start <= end) {
//            int mid = start + (end - start) / 2;
//            if (ele == arr[mid]) {
//                result = mid;
//                end = mid - 1;
//            } else start = mid + 1;
//        }
//
//        return result;
//    }
}
