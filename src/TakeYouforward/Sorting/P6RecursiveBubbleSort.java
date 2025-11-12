package TakeYouforward.Sorting;

import java.util.Arrays;

public class P6RecursiveBubbleSort {
    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};

        // if the array in the sorted order then the best case occurs
//        int[] arr = {1,2,3,4,5};

        int n = arr.length;
        bubbleSort(arr, n - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr, int i) {
        if (i == 0) return;
        int didSwap = 0;
        for (int j = 0; j <= i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                swap(arr, j, j + 1);
                didSwap = 1;
            }
        }
        if (didSwap == 0) return;

        bubbleSort(arr, i - 1);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //For BEST CASE T(C) = (N)
    // if the array in the sorted order then the best case occurs
    // the code is word for unsorted array also but that is not Best Case
    //Worst Case = Average case = T(C) (N^2)
    //the small optimization is done using variable or checker didSwap
}
