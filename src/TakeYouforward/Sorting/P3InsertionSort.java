package TakeYouforward.Sorting;

import java.util.Arrays;

public class P3InsertionSort {
    public static void main(String[] args) {
        int[] arr = {14, 9, 15, 2, 6, 8, 13};
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                swap(arr, j - 1, j);
                j--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
