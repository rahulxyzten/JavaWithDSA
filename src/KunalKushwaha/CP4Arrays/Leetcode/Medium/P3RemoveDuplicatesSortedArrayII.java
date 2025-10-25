package KunalKushwaha.CP4Arrays.Leetcode.Medium;
//problem
/*
80. Remove Duplicates from Sorted Array II

Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.



Example 1:

Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3,_,_]
Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).


Constraints:

1 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
 */
//This is question level 1 Remove Duplicates sorted Array I is on easy folder

import java.util.*;

public class P3RemoveDuplicatesSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
//        int[] nums = {1};
        System.out.println(removeDuplicates(nums));
    }


    /*Optimal Solution (Two Pointer Method) */
    //T(C) = O(N) & S(C) = O(1)
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i == 0 || i == 1 || nums[i - 2] != num) {
                nums[i] = num;
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return i;
    }

    /*Brute Force Approach (Using Hashing) */
    //T(C) = O(2N) & S(C) = O(2N)
//    public static int removeDuplicates(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        List<Integer> list = new ArrayList<>();
//
//        for (int num: nums) {
//            if (map.containsKey(num) && map.get(num) < 2){
//                map.put(num, map.get(num) + 1);
//                list.add(num);
//            } else if (!map.containsKey(num)) {
//                map.put(num, 1);
//                list.add(num);
//            }
//        }
//
//        for (int i = 0; i < list.size(); i++) {
//            nums[i] = list.get(i);
//        }
//
//        System.out.println(list);
//        return list.size();
//    }
}
