package TakeYouforward.Greedy.LeetCode.Hard;
// Problem
/*
135. Candy

There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.



Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.


Constraints:

n == ratings.length
1 <= n <= 2 * 10^4
0 <= ratings[i] <= 2 * 10^4
 */

import java.util.Arrays;

public class P1Candy {
    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        System.out.println(candy(ratings));
        int[] ratings1 = {1, 2, 2};
        System.out.println(candy(ratings1));
        int[] ratings2 = {1, 3, 2, 2, 1};
        System.out.println(candy(ratings2));
        int[] ratings3 = {1, 2, 87, 87, 87, 2, 1};
        System.out.println(candy(ratings3));
        int[] ratings4 = {1, 3, 4, 5, 2};
        System.out.println(candy(ratings4));
        int[] ratings5 = {0, 2, 4, 3, 2, 1, 1, 3, 5, 6, 4, 0, 0};
        System.out.println(candy(ratings5));
    }

    // Better Approach (BEST)
    // T(C) = O(2N) == O(N)
    // S(C) = O(N)
    public static int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0) return 0;

        int[] left = new int[n];
        left[0] = 1;

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        int total = Math.max(left[n - 1], 1);
        int right = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right = right + 1;
            } else {
                right = 1;
            }
            total += Math.max(left[i], right);
        }

        return total;
    }

    // Better Approach
    // T(C) = O(4N) == O(N)
    // S(C) = O(N)
//    public static int candy(int[] ratings) {
//        int n = ratings.length;
//        if (n == 0) return 0;
//
//        int[] givenCandy = new int[n];
//        for (int i = 0; i < n; i++) givenCandy[i] = 1;
//
//        for (int i = 1; i < n; i++) {
//            if (ratings[i] > ratings[i - 1]) {
//                givenCandy[i] = givenCandy[i - 1] + 1;
//            }
//        }
//
//        for (int i = n - 2; i >= 0; i--) {
//            if (ratings[i] > ratings[i + 1]) {
//                givenCandy[i] = Math.max(givenCandy[i], givenCandy[i + 1] + 1);
//            }
//        }
//
//        int total = 0;
//        for (int num : givenCandy) {
//            total += num;
//        }
//
//        return total;
//    }

    // Brute Force Approach
    // T(C) = O(N) + O(N^2) + O(N) == O(N^2)
    // S(C) = O(N)
//    public static int candy(int[] ratings) {
//        int n = ratings.length;
//        if (n == 0) return 0;
//
//        int[] givenCandy = new int[n];
//        for (int i = 0; i < n; i++) {
//            givenCandy[i] = 1;
//        }
//
//        for (int i = 1; i < n; i++) {
//            if (ratings[i] > ratings[i - 1]) {
//                givenCandy[i] = givenCandy[i - 1] + 1;
//            } else if (ratings[i] == ratings[i - 1]) {
//                continue;
//            } else {
//                int j = i;
//                while (j > 0) {
//                    if ((ratings[j - 1] > ratings[j]) && (givenCandy[j - 1] <= givenCandy[j])) {
//                        givenCandy[j - 1] = givenCandy[j] + 1;
//                    }
//                    j--;
//                }
//            }
//        }
//
//        int total = 0;
//        for (int num : givenCandy) {
//            total += num;
//        }
//
//        return total;
//    }
}
