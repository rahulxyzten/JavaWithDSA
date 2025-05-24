package AdityaVerma.Heap.Questions;
//Sort a k sorted array
//sort a nearly sorted array

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class P1SortKSortedArray {
    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        System.out.println(Arrays.toString(kSortedArray(arr, arr.length, 3)));
        System.out.println(nearlySorted(arr, arr.length, 3));
    }

    //T(C) = O(nlogk)
    //S(C) = O(K)
    public static int[] kSortedArray(int arr[], int n, int k) {
        int[] result = new int[n];
        int j = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
            if (minHeap.size() > k) {
                result[j++] = minHeap.poll();
            }
        }

        while (!minHeap.isEmpty()) {
            result[j++] = minHeap.poll();
        }

        return result;
    }

    //GFG
    public static ArrayList<Integer> nearlySorted(int arr[], int num, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
            if (minHeap.size() > k) {
                result.add(minHeap.poll());
            }
        }

        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }

        return result;
    }

}
