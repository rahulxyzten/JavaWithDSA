package TakeYouforward.Sorting;

import java.util.Arrays;

public class P2BubbleSort {
    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};
        int n = arr.length;
        for (int i = n - 1; i > 0; i--) {
            int didSwap = 0;
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    didSwap = 1;
                }
            }
            if (didSwap == 0) break;
        }

        System.out.println(Arrays.toString(arr));
    }

    // T(C) = O(n^2)
    // S(C) = O(1)
    public static void swap(int[] arr, int i, int min) {
        int temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
    }
}
