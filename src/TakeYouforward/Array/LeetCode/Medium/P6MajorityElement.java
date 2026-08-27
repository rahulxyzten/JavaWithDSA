package TakeYouforward.Array.LeetCode.Medium;
// Question

/*
169. Majority Element

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2


Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109


Follow-up: Could you solve the problem in linear time and in O(1) space?
 */

/*
Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
 */


import java.util.HashMap;

public class P6MajorityElement {
    public static void main(String[] args) {
//        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int[] nums = {3, 2, 3};
        System.out.println(majorityElement(nums));
    }


    /* Optimal approach ( O(N) time complexity & O(1) space complexity )*/
    /* Moore’s Voting Algorithm */
    public static int majorityElement(int[] nums) {
        // int n = nums.length;
        int ele = 0, count = 0;

        for (int num : nums) {
            if (count == 0) {
                ele = num;
                count = 1;
            } else if (num == ele) count++;
            else count--;
        }

        // // Verification no need here (You may assume that the majority element always exists in the array.)
        // int count1 = 0;
        // for (int num : nums) {
        //     if (num == ele)
        //         count1++;
        // }

        // if (count1 > n / 2)
        //     return ele;

        return ele;
    }


    /* Better Approach (Using hashing) ( O(NlogN) == O(N) time complexity & O(N) space complexity )  */
//    public static int majorityElement(int[] nums) {
//        int n = nums.length;
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for (int num : nums) {
//            int value = map.getOrDefault(num, 0);
//            map.put(num, value + 1);
//
//            if ((value + 1) > n / 2)
//                return num;
//        }
//
//        return -1;
//    }


    /* Brute force Approach (find count > (n/2)) (Runtime 1451ms & memory is 48.66mb) */
//    public static int majorityElement(int[] nums) {
//        int n = nums.length;
//        for (int i = 0; i < n; i++) {
//            int count = 0;
//            for (int j = 0; j < n; j++) {
//                if (nums[i] == nums[j]) count++;
//            }
//            if (count > (n/2)) return nums[i];
//        }
//        return -1;
//    }


    /* Brute force Approach (3ms 48.8MB) (Sorting and return n/2 index element*/
//    public static int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        int n = nums.length;
//        return nums[n / 2];
//        //after array is sort the majority element present at index n/2
//
//    }
}
