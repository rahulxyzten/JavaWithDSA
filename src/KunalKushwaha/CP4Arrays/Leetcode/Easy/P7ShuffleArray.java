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


    public static int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        int j = 0; // Index for the second half of the array

        for (int i = 0; i < n; i++) {
            result[j++] = nums[i]; // Store xi
            result[j++] = nums[i + n]; // Store yi
        }
          // Pre incrementer a++ (first print then increment )
         // 1st iteration j++ = 0 (j value is 0 then increment by 1) and j = 1 (j value is 1 then increment by 2 for the next iteration)
         // 1st iteration j++ = 0 (j value is 2 then increment by 3) and j = 1 (j value is 3 then increment by 4 for the next iteration)
         // 1st iteration j++ = 0 (j value is 4 then increment by 5) and j = 1 (j value is 5)
        return result;
    }
//    public static int[] shuffle(int[] nums, int n) {
//        int[] result = new int[nums.length];
//        int j = 0; // Index for the second half of the array
//
//        for (int i = 0; i < n; i++) {
//            result[j] = nums[i];
//            result[j + 1] = nums[i + n]; // j + 1 means the original j is not increasing
//            j = j + 2;
//            // for i = 0 result[0] result[1]
//            // for i = 1 result[2] result[3]
//            // for i = 2 result[4] result[5]
//        }
//        return result;
//    }


//    public static int[] shuffle(int[] nums, int n) {
//        int[] result = new int[nums.length];
//        int j = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (i % 2 == 0) {
//                result[i] = nums[j];
//                j++;
//            } else {
//                result[i] = nums[n];
//                n++;
//            }
//        }
//        return result;
//    }

}

