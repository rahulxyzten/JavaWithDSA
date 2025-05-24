package AdityaVerma.Heap.Questions;
//Sort an array by frequency in both ascending or descending order of frequency

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

public class P2FrequencySort {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 3, 2, 2, 4};
        System.out.println(Arrays.toString(frequencySort(arr)));
    }


    //T(C) = O(N)
    //S(C) = O(N)
    public static int[] frequencySort(int[] arr) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        //key = array element , value = element frequency
        for (int num : arr) {
            mpp.put(num, mpp.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.key != b.key ? a.key - b.key : a.value - b.value);
        //if you want the array in ascending order of frequency then use MinHeap

//        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> a.key != b.key ? b.key - a.key : b.value - a.value);
//        //if you want the array in descending order of frequency then use MaxHeap

        for (int num : mpp.keySet()) {
            minHeap.add(new Pair(mpp.get(num), num));
            //key = element frequency, value = array element
        }

        int i = 0;
        while (!minHeap.isEmpty()) {
            for (int j = 0; j < minHeap.peek().key; j++) {
                arr[i++] = minHeap.peek().value;
            }
            minHeap.poll();
        }
        return arr;
    }
}
