package TakeYouforward.Sorting;

import java.util.Arrays;

public class P5QuickSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 5, 7, 4, 1, 3};
        int start = 0, end = arr.length - 1;
        quickSort(arr, start, end);
        System.out.println(Arrays.toString(arr));
    }

    // T(C) = O(nlogn)
    // S(C) = O(1)
    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int pIndex = partition(arr, start, end);
        quickSort(arr, start, pIndex - 1);
        quickSort(arr, pIndex + 1, end);
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start, j = end;

        while (i < j) {
            while (arr[i] <= pivot && i < end) {
                i++;
            }
            while (arr[j] > pivot && j > start) {
                j--;
            }
            if (i < j) swap(arr, i, j);
        }
        swap(arr, start, j);

        return j;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
