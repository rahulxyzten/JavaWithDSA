package AdityaVerma.Heap.AnujBhaiya;

import java.util.Arrays;

//Building Max Heap From Array
//Heapify Algorithm
public class P3BuildingMaxHeapFromArray {
    public static void main(String[] args) {
//        int[] arr = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        int[] arr = {5, 3, 17, 10, 84, 19, 6, 22, 9};
        buildHeap(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    //T(C) = O(N)
    //S(C) = O(1)
    public static void buildHeap(int[] arr, int n) {
        int startIdx = (n / 2) - 1;
        for (int i = startIdx; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }
}
