package KunalKushwaha.Cp5Searching.BinarySearch.Assignment.Easy;

import java.util.Arrays;

//Go for the Aditya Verma Code for this Problem
//Aditya Verma Code (BEST CODE) with no edge cases
public class P1FloorCeil {
    public static void main(String[] args) {
//        int[] arr = {4, 3, 8, 4, 7, 10};
        int[] arr = {1, 2, 3, 4, 8, 10, 10, 12, 19};
        int target = 15;
        System.out.println(ceilingInSortedArray(arr.length, target, arr));
    }

//    //This is for returning the floor and ceil not as index
//    //otherwise return the index as -1
    public static int ceilingInSortedArray(int n, int x, int[] arr) {
        Arrays.sort(arr);
        int floor = floor(arr, x);
        int ceil = ceil(arr, x);
        System.out.print(floor + " ");

        return ceil;
    }

    public static int floor(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return arr[mid];
            }
        }
        if(end >= 0) return arr[end];
        else return -1;
    }

    public static int ceil(int[] arr, int target) {
        if (target > arr[arr.length - 1])
            return -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return arr[mid];
            }
        }
        return arr[start];
    }

//    This is for returning the index of floor and ceil otherwise
//    return the index as -1
//    public static int ceilingInSortedArray(int n, int x, int[] arr) {
//        Arrays.sort(arr);
//        int floor = floor(arr, x);
//        int ceil = ceil(arr, x);
//        System.out.print(floor + " ");
//
//        return ceil;
//    }
//
//    public static int floor(int[] arr, int target) {
//        int start = 0;
//        int end = arr.length - 1;
//        while (start <= end) {
//            int mid = start + (end - start) / 2;
//            if (target < arr[mid]) {
//                end = mid - 1;
//            } else if (target > arr[mid]) {
//                start = mid + 1;
//            } else {
//                return mid;
//            }
//        }
//        if (end >= 0) return end;
//        else return -1;
//    }
//
//    public static int ceil(int[] arr, int target) {
//        if (target > arr[arr.length - 1]) return -1;
//        int start = 0;
//        int end = arr.length - 1;
//        while (start <= end) {
//            int mid = start + (end - start) / 2;
//            if (target < arr[mid]) {
//                end = mid - 1;
//            } else if (target > arr[mid]) {
//                start = mid + 1;
//            } else {
//                return mid;
//            }
//        }
//        return start;
//    }
}
