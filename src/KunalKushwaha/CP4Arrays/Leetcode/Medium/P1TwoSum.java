package KunalKushwaha.CP4Arrays.Leetcode.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
1. Two Sum

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.


Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
*/


public class P1TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(nums, target)));
        System.out.println(twoSumm(nums, target));
    }


    /*Optimal Solution when it doesn't ask for index it only ask for yes or no*/
    //(using two-pointer):
    //T(C) =  O(N) + O(N*logN), where N = size of the array
    //S(C) = O(1)
    public static String twoSumm(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) return "YES";
            else if (sum < target) left++;
            else right--;
        }
        return "N0";
    }


    // Optimal Solution when it asks for index and Better Solution when it asks for Yes or No(Using Hashing)
    //T(C) = O(N) where N = size of the array.
    // Reason: The loop runs N times in the worst case and searching
    // in a hashmap takes O(1) generally. So the time complexity is O(N).

    // Note: In the worst case(which rarely happens), the unordered_map takes O(N)
    // to find an element. In that case, the time complexity will be O(N^2).
    // If we use map instead of unordered_map, the time complexity will be O(N* logN)
    // as the map data structure takes logN time to find an element.

    //S(C) = O(N) as we use the map data structure
    public static int[] twoSum(int[] nums, int target) {
        int[] ans = {-1, -1};
        int n = nums.length;
        Map<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int rem = target - num;
            if (mpp.containsKey(rem)) {
                ans[0] = mpp.get(rem);
                ans[1] = i;
                return ans;
            }
            mpp.put(nums[i], i);
        }
        return ans;
    }

//    /*Brute Force (Best Solution)*/
//    //T(C) = O(N^2) & S(C) = O(1)
//    public static int[] twoSum(int[] nums, int target) {
//        int n = nums.length;
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return new int[]{}; // No solution found
//
//
//        /*Brute Force (My solution) */
//        int[] arr = new int[2];
//        int n = nums.length;
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (nums[i] + nums[j] == target) {
//                    arr[0] = i;
//                    arr[1] = j;
//                    return arr;
//                }
//            }
//        }
//        return arr; // No solution found empty array
//
//    }

}
