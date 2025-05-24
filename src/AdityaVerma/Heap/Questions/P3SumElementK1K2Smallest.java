package AdityaVerma.Heap.Questions;
//Sum of Elements between k1 smallest and k2 smallest numbers

import java.util.Collections;
import java.util.PriorityQueue;

public class P3SumElementK1K2Smallest {
    public static void main(String[] args) {
        int[] arr = {1, 3, 12, 5, 15, 11};
        int k1 = 3, k2 = 6;
        System.out.println(sumOfElementsK1K2Smallest(arr, k1, k2));
    }

    //T(C) ==> O(nlogk)
    //S(C) ==> O(K)
    public static int sumOfElementsK1K2Smallest(int[] arr, int k1, int k2) {
        int first = kthSmallest(arr.length, k1, arr);
        int second = kthSmallest(arr.length, k2, arr);
        int sum = 0;
        for (int num : arr) {
            if (num > first && num < second)
                sum += num;
        }
        return sum;
    }

    public static int kthSmallest(int n, int k, int[] arr) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            maxHeap.add(arr[i]);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }

        return maxHeap.peek();
    }
}
