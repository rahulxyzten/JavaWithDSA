package AdityaVerma.BinarySearch.CodeStudio.Medium;
//Question
/*
https://www.naukri.com/code360/problems/ceiling-in-a-sorted-array_1825401
 */
//Ceil The Floor

import java.util.Arrays;

public class P1CeilTheFloor {
    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 7, 8, 10};
        int n = arr.length;
        int x = 2;
        System.out.println(ceilingInSortedArray(n, x, arr));
    }

    public static int ceilingInSortedArray(int n, int x, int[] arr) {
        int ceil = ceil(arr, x);
        int floor = floor(arr, x);

        System.out.print(floor + " ");

        return ceil;
    }

    public static int floor(int[] arr, int element) {
        int start = 0, end = arr.length - 1, result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (element == arr[mid]) {
                return arr[mid];
            } else if (arr[mid] < element) {
                result = arr[mid];
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

    public static int ceil(int[] arr, int element) {
        int start = 0, end = arr.length - 1, result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (element == arr[mid]) {
                return arr[mid];
            } else if (arr[mid] > element) {
                result = arr[mid];
                end = mid - 1;
            } else if (arr[mid] < element) {
                start = mid + 1;
            }
        }
        return result;
    }
}
