package KunalKushwaha.CP4Arrays.Leetcode.Easy;

/*
1470. Shuffle the Array

Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].

Return the array in the form [x1,y1,x2,y2,...,xn,yn].



Example 1:

Input: nums = [2,5,1,3,4,7], n = 3
Output: [2,3,5,4,1,7]
Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
Example 2:

Input: nums = [1,2,3,4,4,3,2,1], n = 4
Output: [1,4,2,3,3,2,4,1]
Example 3:

Input: nums = [1,1,2,2], n = 2
Output: [1,2,1,2]


Constraints:

1 <= n <= 500
nums.length == 2n
1 <= nums[i] <= 10^3
 */

import java.util.Arrays;

public class P7ShuffleArray {
    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 4, 7};
        int n = 3;
        System.out.println(Arrays.toString(shuffle(nums, 3)));
    }


    // T(C) = O(N)
    // S(C) = O(N)
    public static int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        int j = 0; // Index for the second half of the array

        for (int i = 0; i < n; i++) {
            result[j++] = nums[i]; // Store xi
            result[j++] = nums[i + n]; // Store yi
        }

        return result;
    }

//    public static int[] shuffle(int[] nums, int n) {
//        int[] result = new int[nums.length];
//        int index = 0;
//
//        for (int i = 0; i < 2 * n; i += 2) {
//            result[i] = nums[index];
//            result[i + 1] = nums[index + n];
//            index++;
//        }
//
//        return result;
//    }
}

