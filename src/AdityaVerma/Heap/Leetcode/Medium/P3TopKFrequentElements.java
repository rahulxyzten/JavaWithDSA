package AdityaVerma.Heap.Leetcode.Medium;
//Problem
/*
347. Top K Frequent Elements

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.



Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]


Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.


Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;


public class P3TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    //T(C) = O(nlogk)
    //S(C) = O(K)
    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];

        HashMap<Integer, Integer> mpp = new HashMap<>();
        //key = array element , value = element frequency
        for (int num : nums) {
            mpp.put(num, mpp.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.key != b.key ? a.key - b.key : a.value - b.value);

        for (int num : mpp.keySet()) {
            minHeap.add(new Pair(mpp.get(num), num));
            //key = element frequency, value = array element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int i = 0;
        while (!minHeap.isEmpty()) {
            result[i++] = minHeap.poll().value;
        }

        return result;
    }
}
