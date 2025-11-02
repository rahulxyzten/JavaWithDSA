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
        System.out.println(Arrays.toString(getFloorAndCeil(arr, n, x)));
//        System.out.println(ceilingInSortedArray(n, x, arr));
    }

    // T(C) = O(2logn)
    // S(C) = O(1)
    public static int[] getFloorAndCeil(int[] a, int n, int x) {
        int floor = getFloor(a, n, x);
        int ceil = getCeil(a, n, x);
        return new int[]{floor, ceil};
    }

    public static int getFloor(int[] a, int n, int x) {
        int result = -1;
        int start = 0, end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] == x) return a[mid];
            else if (a[mid] < x) {
                result = a[mid];
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }

    public static int getCeil(int[] a, int n, int x) {
        int result = -1;
        int start = 0, end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] == x) return a[mid];
            else if (a[mid] > x) {
                result = a[mid];
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }


    //    public static int ceilingInSortedArray(int n, int x, int[] arr) {
//        int ceil = ceil(arr, x);
//        int floor = floor(arr, x);
//
//        System.out.print(floor + " ");
//
//        return ceil;
//    }
//
//    public static int floor(int[] arr, int element) {
//        int start = 0, end = arr.length - 1, result = -1;
//        while (start <= end) {
//            int mid = start + (end - start) / 2;
//            if (element == arr[mid]) {
//                return arr[mid];
//            } else if (arr[mid] < element) {
//                result = arr[mid];
//                start = mid + 1;
//            } else {
//                end = mid - 1;
//            }
//        }
//        return result;
//    }
//
//    public static int ceil(int[] arr, int element) {
//        int start = 0, end = arr.length - 1, result = -1;
//        while (start <= end) {
//            int mid = start + (end - start) / 2;
//            if (element == arr[mid]) {
//                return arr[mid];
//            } else if (arr[mid] > element) {
//                result = arr[mid];
//                end = mid - 1;
//            } else if (arr[mid] < element) {
//                start = mid + 1;
//            }
//        }
//        return result;
//    }
}
