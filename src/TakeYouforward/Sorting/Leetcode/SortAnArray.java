package TakeYouforward.Sorting.Leetcode;
//Problem
/*
912. Sort an Array

Given an array of integers nums, sort the array in ascending order and return it.

You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.



Example 1:

Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
Example 2:

Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
Explanation: Note that the values of nums are not necessairly unique.


Constraints:

1 <= nums.length <= 5 * 104
-5 * 104 <= nums[i] <= 5 * 104
 */

import java.util.ArrayList;
import java.util.Arrays;

public class SortAnArray {
    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        System.out.println(Arrays.toString(sortArray(nums)));

    }

    public static int[] sortArray(int[] nums) {
//        quickSort(nums, 0, nums.length - 1);
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    // T(C) = O(nlogn)
    // S(C) = O(n)
    public static void mergeSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    public static void merge(int[] nums, int start, int mid, int end) {
        int left = start, right = mid + 1;
        ArrayList<Integer> temp = new ArrayList<>();

        while (left <= mid && right <= end) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            } else {
                temp.add(nums[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(nums[left]);
            left++;
        }

        while (right <= end) {
            temp.add(nums[right]);
            right++;
        }

        for (int i = start; i <= end; i++) {
            nums[i] = temp.get(i - start);
        }
    }

    // T(C) = O(nlogn)
    // S(C) = O(1)
//    public static void quickSort(int[] nums, int start, int end) {
//        if (start < end) {
//            int pIndex = partition(nums, start, end);
//            quickSort(nums, start, pIndex - 1);
//            quickSort(nums, pIndex + 1, end);
//        }
//    }
//
//    public static int partition(int[] nums, int start, int end) {
//        int pivot = nums[start];
//        int i = start, j = end;
//        while (i < j) {
//            while (nums[i] <= pivot && i < end) {
//                i++;
//            }
//            while (nums[j] > pivot && j > start) {
//                j--;
//            }
//            if (i < j) swap(nums, i, j);
//        }
//        swap(nums, start, j);
//        return j;
//    }
//
//    public static void swap(int[] arr, int i, int j) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
}
