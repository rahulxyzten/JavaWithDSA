package TakeYouforward.BinarySearch.LeetCode.Easy;
// Problem
/*
1539. Kth Missing Positive Number

Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Return the kth positive integer that is missing from this array.

Example 1:

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
Example 2:

Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.


Constraints:

1 <= arr.length <= 1000
1 <= arr[i] <= 1000
1 <= k <= 1000
arr[i] < arr[j] for 1 <= i < j <= arr.length


Follow up:

Could you solve this problem in less than O(n) complexity?
 */

public class P2KthMissingPositiveNumber {
    public static void main(String[] args) {
//        int[] arr = {2, 3, 4, 7, 11};
//        int k = 5;

//        int[] arr = {1, 2, 3, 4};
//        int k = 2;

        int[] arr = {4, 7, 9};
        int k = 3;

        System.out.println(findKthPositive(arr, k));
    }

    // Optimal Solution
    // T(C) = O(logN)
    // S(C) = O(1)
    public static int findKthPositive(int[] arr, int k) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int missingNumbers = arr[mid] - (mid + 1);
            if (missingNumbers < k) start = mid + 1;
            else end = mid - 1;
        }

        return (end + 1 + k);
    }

    // Better Approach
    // T(C) = O(N)
    // S(C) = O(1)
//    public static int findKthPositive(int[] arr, int k) {
//        for (int num : arr) {
//            if (num <= k) {
//                k++;
//            } else {
//                break;
//            }
//        }
//
//        return k;
//    }

    // Brute Force Approach
    // T(C) = O(N + K)
    // S(C) = O(1)
//    public static int findKthPositive(int[] arr, int k) {
//        int missingVal = 1;
//        int i = 0;
//
//        while (k != 0) {
//            if (i == arr.length || missingVal != arr[i]) {
//                missingVal++;
//                k--;
//            } else {
//                missingVal++;
//                i++;
//            }
//        }
//
//        return missingVal - 1;
//    }
}
