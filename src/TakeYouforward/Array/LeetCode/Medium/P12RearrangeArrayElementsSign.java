package TakeYouforward.Array.LeetCode.Medium;
//Problem
/*
2149. Rearrange Array Elements by Sign
Medium
Topics
Companies
Hint
You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.

You should return the array of nums such that the the array follows the given conditions:

Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.
Return the modified array after rearranging the elements to satisfy the aforementioned conditions.



Example 1:

Input: nums = [3,1,-2,-5,2,-4]
Output: [3,-2,1,-5,2,-4]
Explanation:
The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not satisfy one or more conditions.
Example 2:

Input: nums = [-1,1]
Output: [1,-1]
Explanation:
1 is the only positive integer and -1 the only negative integer in nums.
So nums is rearranged to [1,-1].


Constraints:

2 <= nums.length <= 2 * 105
nums.length is even
1 <= |nums[i]| <= 105
nums consists of equal number of positive and negative integers.


It is not required to do the modifications in-place.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class P12RearrangeArrayElementsSign {
    public static void main(String[] args) {
//        int[] nums = {3, 1, -2, -5, 2, -4};

        //follow-up questions positive and negative elements (not necessarily equal)
        int[] nums = {1, 2, -4, -5, 3, 4, -7, -9, -11};

        System.out.println(Arrays.toString(rearrangeArray(nums)));
    }

    //Follow-up question
    //T(C) = O(2N)
    //S(C) = O(N)
    public static int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        for (int num : nums) {
            if (num > 0) positive.add(num);
            else negative.add(num);
        }

        if (positive.size() < negative.size()) {
            for (int i = 0; i < positive.size(); i++) {
                nums[2 * i] = positive.get(i);
                nums[2 * i + 1] = negative.get(i);
            }
            int index = positive.size() * 2;
            for (int i = positive.size(); i < negative.size(); i++) {
                nums[index] = negative.get(i);
                index++;
            }
        } else {
            for (int i = 0; i < negative.size(); i++) {
                nums[2 * i] = positive.get(i);
                nums[2 * i + 1] = negative.get(i);
            }
            int index = negative.size() * 2;
            for (int i = negative.size(); i < positive.size(); i++) {
                nums[index] = positive.get(i);
                index++;
            }
        }


        return nums;
    }

    //Optimal Approach
    //T(C) = O(N)
    //S(C) = O(N)
//    public static int[] rearrangeArray(int[] nums) {
//        int[] result = new int[nums.length];
//        int posIndex = 0, negIndex = 1;
//        for (int num : nums) {
//            if (num > 0) {
//                result[posIndex] = num;
//                posIndex += 2;
//            } else {
//                result[negIndex] = num;
//                negIndex += 2;
//            }
//        }
//
//        return result;
//    }

    //Brute force Approach
    //T(C) = O(N + N/2)
    //S(C) = O(N/2 + N/2) = O(N)
//    public static int[] rearrangeArray(int[] nums) {
//        ArrayList<Integer> positive = new ArrayList<>();
//        ArrayList<Integer> negative = new ArrayList<>();
//
//        for (int num : nums) {
//            if (num > 0) positive.add(num);
//            else negative.add(num);
//        }
//        for (int i = 0; i < nums.length / 2; i++) {
//            nums[2 * i] = positive.get(i);
//            nums[2 * i + 1] = negative.get(i);
//        }
//        //if arr.length = 6 then
//        //0,1 >> 2,3 >> 4,5
//
//        return nums;
//    }
}
