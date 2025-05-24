package AdityaVerma.Heap.Leetcode.Easy;
//Problem
/*
1636. Sort Array by Increasing Frequency

Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.

Return the sorted array.



Example 1:

Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
Example 2:

Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
Example 3:

Input: nums = [-1,1,-6,4,5,-6,1,4,1]
Output: [5,-1,4,4,-6,-6,1,1,1]


Constraints:

1 <= nums.length <= 100
-100 <= nums[i] <= 100
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

class Pair {
    int key;
    int value;

    Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class P1SortArrayByIncreasingFrequency {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3};
        System.out.println(Arrays.toString(frequencySort(nums)));
    }

    //T(C) = O(nlogn)
    //S(C) = O(N)
    public static int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        //key = array element , value = element frequency
        for (int num : nums) {
            mpp.put(num, mpp.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.key != b.key ? a.key - b.key : b.value - a.value);
        //here it says that if the frequency is same sort the element in descending order so  b.value - a.value
        // if a.value - b.value if the frequency is same it sort the element in ascending order so b.value - a.value
        for (int num : mpp.keySet()) {
            minHeap.add(new Pair(mpp.get(num), num));
            //key = element frequency, value = array element
        }

        int i = 0;
        while (!minHeap.isEmpty()) {
            for (int j = 0; j < minHeap.peek().key; j++) {
                nums[i++] = minHeap.peek().value;
            }
            minHeap.poll();
        }

        return nums;
    }
}
