package AdityaVerma.Heap.CodeStudio.Easy;

import java.util.PriorityQueue;

public class P2ConnectNRopesMinimumCost {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 6};
        System.out.println(connectRopes(arr));
    }

    //T(C) = O(nlogn)
    //S(C) = O(n)
    public static long connectRopes(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) {
            minHeap.add(num);
        }
        int mincost = 0;
        while (minHeap.size() >= 2) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            mincost += (first + second);
            minHeap.add(first + second);
        }

        return mincost;
    }
}
