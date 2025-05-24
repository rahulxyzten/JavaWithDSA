package AdityaVerma.Heap.Leetcode.Medium;
//Problem
/*
658. Find K Closest Elements

Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b


Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]


Constraints:

1 <= k <= arr.length
1 <= arr.length <= 104
arr is sorted in ascending order.
-104 <= arr[i], x <= 104
 */

import java.util.*;

class Pair {
    int key;
    int value;

    Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class P2FindKClosestElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4, x = 3;
        System.out.println(findClosestElements(arr, k, x));
    }

    //T(C) = O(nlogk)
    //S(C) = O(K)
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> a.key != b.key ? b.key - a.key : b.value - a.value);
        /*
        creates a max heap behavior. This is because it prioritizes elements with greater key values.
        If two elements have the same key, it prioritizes the one with the greater value.
         */
        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(new Pair(Math.abs(arr[i] - x), arr[i]));
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll().value);
        }
        Collections.sort(result);
        return result;
    }
}
