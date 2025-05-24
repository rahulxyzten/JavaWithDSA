package TakeYouforward.Sorting;

import java.util.Arrays;

public class P1SelectionSort {
    public static void main(String[] args) {
        int[] arr = {9, 46, 24, 52, 20, 13};
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) min = j;
            }
            swap(arr, i, min);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int i, int min) {
        int temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
    }
}
