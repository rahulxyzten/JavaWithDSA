package TakeYouforward.Sorting;

import java.util.Arrays;

public class P7RecursiveInsertionSort {
    public static void main(String[] args) {
        int[] arr = {14, 9, 15, 2, 6, 8, 13};
        int n = arr.length;
        insertionSort(arr, 1, n);
        System.out.println(Arrays.toString(arr));
    }

    // T(C) = O(n^2)
    // S(C) = O(1)
    public static void insertionSort(int[] arr, int i, int n) {
        if (i == n) return;
        int j = i;
        while (j > 0 && arr[j - 1] > arr[j]) {
            swap(arr, j - 1, j);
            j--;
        }

        insertionSort(arr, i + 1, n);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
