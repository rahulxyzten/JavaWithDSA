package AdityaVerma.BinarySearch.Leetcode.Medium;
//Problem
/*
875. Koko Eating Bananas
Medium
9K
439
Companies
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.



Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23


Constraints:

1 <= piles.length <= 104
piles.length <= h <= 109
1 <= piles[i] <= 109
 */

public class P6KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
//        int[] piles = {30, 11, 23, 4, 20};
//        int h = 5;
        System.out.println(minEatingSpeed(piles, h));
    }

    /* Optimal Solution */
    public static int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = findMax(piles); //less time complexity
//        int end = Arrays.stream(piles).max().orElse(-1); //more time complexity
        int result = 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(piles, mid, h)) {
                result = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return result;
//        return start;
    }

    public static int findMax(int[] v) {
        int maxi = Integer.MIN_VALUE;
        for (int j : v) {
            maxi = Math.max(maxi, j);
        }
        return maxi;
    }

    public static boolean isValid(int[] arr, int k, int h) {
        int totalH = 0;
        for (int j : arr) {
            //totalH = totalH + Math.ceil(j / k);
            //above line don't work because
            //if 5/2 it gives a 2(int) ceil is 2 because j and k is int, but we need 3, so we have to type cast j and k to double
            // so wright is (double)5/(double)2 it gives 2.5(double) ceil is 3 which is our required element

            totalH +=  Math.ceil((double) j / (double) k);
            if (totalH > h) return false;

        }
//        return totalH <= h; //This line write if the if condition is not written above
                return true;
    }
}
//T(C) & S(C)
/*
Time Complexity: O(N * log(max(a[]))), where max(a[]) is the maximum element in the array and N = size of the array.
Reason: We are applying Binary search for the range [1, max(a[])], and for every value of ‘mid’, we are
 traversing the entire array inside the function named calculateTotalHours().

Space Complexity: O(1) as we are not using any extra space to solve this problem.
*/
