package TakeYouforward.Array.LeetCode.Medium;
//Problem
/*
229. Majority Element II
Medium
8.1K
359
Companies
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.



Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]


Constraints:

1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109


Follow up: Could you solve the problem in linear time and in O(1) space?
 */

import java.util.*;

public class P7MajorityElement2 {
    public static void main(String[] args) {
//        int[] nums = {1, 2};
//        int[] nums = {1};
//        int[] nums = {3, 2, 3};
        int[] nums = {1, 1, 1, 3, 3, 2, 2, 2};
        majorityElement(nums);
        System.out.println(majorityElement(nums));
    }

    //Optimal Approach T(C) = (O(N) + O(N) and S(C) = O(1)
    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> ls = new ArrayList<>();
        int count1 = 0, count2 = 0, ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (count1 == 0 && nums[i] != ele2) {
                count1 = 1;
                ele1 = nums[i];
            } else if (count2 == 0 && nums[i] != ele1) {
                count2 = 1;
                ele2 = nums[i];
            } else if (ele1 == nums[i]) count1++;
            else if (ele2 == nums[i]) count2++;
            else {
                count1--;
                count2--;
            }
        }
        int cnt1 = 0, cnt2 = 0;
        for (int num : nums) {
            if (num == ele1) cnt1++;
            if (num == ele2) cnt2++;
        }
        if (cnt1 > n / 3) ls.add(ele1);
        if (cnt2 > n / 3) ls.add(ele2);

        for (Integer element : ls) {
            System.out.print(element + " ");
        }

        return ls;
    }


    //Better Approach (O(N*logN)time & O(N)space) (Using Hashing)
    /*
    We are using a map data structure. Insertion in the map takes logN time. And we are doing it for N elements. So,
    it results in the first term O(N*logN).
    If we use unordered_map instead, the first term will be O(N) for the best and average case and for the worst case,
    it will be O(N2).
    */
//    public static List<Integer> majorityElement(int []nums) {
//        int n = nums.length;
//        Map<Integer, Integer> map = new HashMap<>();
//        List<Integer> list = new ArrayList<>();
//        int min = (n / 3) + 1;
//
//        for (int num: nums){
//            int val = map.getOrDefault(num, 0);
//            map.put(num, val + 1);
//
//            if (map.get(num) == min) list.add(num);
//            if (list.size() == 2) return list;
//        }
//
//        return list;
//    }

    //Brute Force Approach (O(N^2)time O(1)space)
//    public static List<Integer> majorityElement(int[] nums) {
//        int n = nums.length; //size of the array
//        List<Integer> ls = new ArrayList<>(); // list of answers
//
//        for (int i = 0; i < n; i++) {
//            //selected element is v[i]:
//            // Checking if v[i] is not already
//            // a part of the answer:
//            if (ls.size() == 0 || ls.get(0) != nums[i]) {
//                int cnt = 0;
//                for (int j = 0; j < n; j++) {
//                    // counting the frequency of v[i]
//                    if (nums[j] == nums[i]) {
//                        cnt++;
//                    }
//                }
//
//                // check if frquency is greater than n/3:
//                if (cnt > (n / 3))
//                    ls.add(nums[i]);
//            }
//
//            if (ls.size() == 2) break;
//        }
//
//        for (Integer element : ls) {
//            System.out.print(element + " ");
//        }
//
//        return ls;
//    }
}
