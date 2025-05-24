package AdityaVerma.Recursion.Leetcode.Medium;
//problem
/*
78. Subsets

Given an integer array nums of unique elements, return all possible
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]


Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
 */

import java.util.ArrayList;
import java.util.List;

public class P2Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    //Best Code Love Babbar if the ip is given an array if
    //the ip is given String go for Aditya verma Solution
    // T(C) = O(O^2) and S(C) = O(N)
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> op = new ArrayList<>();
        findSubsets(nums, 0, op, result);
        return result;
    }

    public static void findSubsets(int[] nums, int i, List<Integer> op, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(op);
            return;
        }
        findSubsets(nums, i + 1, op, result);
        op.add(nums[i]);
        findSubsets(nums, i + 1, new ArrayList<>(op), result);
        // In Java, when you add or remove elements from a list, you are modifying the
        // original list so always take a new ArrayList and append op there
        op.remove(op.size() - 1);
        return;
    }


    /*This code takes long time and long space
    Go for above code which is best (love babbar)
     */

//    public static List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> list = new ArrayList<>();
//        List<Integer> ip = new ArrayList<>();
//        for (int num : nums) {
//            ip.add(num);
//        }
//        List<Integer> op = new ArrayList<>();
//        findSubsets(list, ip, op);
//        return list;
//    }
//
//    /*
//    when you pass a List to a method, the changes made to the list inside the method affect the original list outside the method
//    basically when a list is called inside the method then it takes the reference
//      ex=> List<Integer> op1 = op; // here op1 take the reference of the op list changes made to op1 directly effect the op list
//                                   //That is going to be wrong in output so take a new list and append the op list to that new list
//                    //like
//                    List<Integer> op1 = new ArrayList<>(op);
//    but in the string it takes the copy of the string
//    ex=>  String op1 = op; //here op1 String take a copy of op string so the changes made op1 not reflected to op string
//     */
//    public static void findSubsets(List<List<Integer>> list, List<Integer> ip, List<Integer> op) {
//        if (ip.size() == 0) {
//            list.add(op);
//            return;
//        }
//        List<Integer> op1 = new ArrayList<>(op);
//        List<Integer> op2 = new ArrayList<>(op);
//        op2.add(ip.get(0));
//        ip.remove(0);
//        findSubsets(list, new ArrayList<>(ip), op1); // Pass a copy of ip
//        findSubsets(list, new ArrayList<>(ip), op2); // Pass a copy of ip
//        return;
//    }
}
