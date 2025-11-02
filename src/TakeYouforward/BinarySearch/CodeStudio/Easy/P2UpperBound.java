package TakeYouforward.BinarySearch.CodeStudio.Easy;
//Question
/*
https://www.naukri.com/code360/problems/implement-upper-bound_8165383
 */
//Implement Upper Bound

import java.util.ArrayList;
import java.util.Arrays;

public class P2UpperBound {
    public static void main(String[] args) {
//        int[] arr = {1,2,5,6,10};
//        int x = 10;

//        int[] arr = {1, 5, 5, 7, 7, 9, 10};
//        int x = 5;

        int[] arr = {1};
        int x = 1;

        int n = arr.length;
        System.out.println(upperBound(arr, x, n));
    }

    /*Best Code */
    // T(C) = O(logn)
    // S(C) = O(1)
    public static int upperBound(int[] arr, int x, int n) {
        int start = 0;
        int end = n - 1;
        int result = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > x) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }


//    public static int upperBound(int []arr, int x, int n){
//        if (arr[0] > x) return 0;
//        if (arr[n - 1] < x) return n;
//        int start = 1;
//        int end = n - 2;
//        int result = n;
//        //If in the first of while the condition is false, so it  return n (which is length of arr
//        while (start <= end) {
//            int mid = start + (end - start) / 2;
//            if (arr[mid] > x) {
//                result = mid;
//                end = mid - 1;
//            } else {
//                start = mid + 1;
//            }
//        }
//        return result;
//    }


    public static class P1FindRowWithMaxNumOf1S {
        public static void main(String[] args) {
            ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
            matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
            matrix.add(new ArrayList<>(Arrays.asList(0, 0, 1)));
            matrix.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
            int n = 3;
            int m = 3;
            System.out.println(rowMaxOnes(matrix, n, m));
        }


        //T(C) = O(nlogm)
        //S(C) = O(1)
        public static int rowMaxOnes(ArrayList<ArrayList<Integer>> mat, int n, int m) {
            int countMax = 0, index = -1;
            for (int i = 0; i < n; i++) {
                int countRow1S = m - firstOccurrence(mat.get(i), m, 1);
                if (countRow1S > countMax) {
                    countMax = countRow1S;
                    index = i;
                }
            }
            return index;
        }

        public static int firstOccurrence(ArrayList<Integer> arr, int m, int ele) {
            int start = 0, end = m - 1;
            int index = m;
            //here the default of index must be change to -1 to m becz
            //if the array has not one then it return -1
            //if the i = 2 then countrow1s = 3 - (-1) = 4, but it has to 0
            //so if m return then countrow1s = 3 - 3 = 0 that is right
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (ele == arr.get(mid)) {
                    index = mid;
                    end = mid - 1;
                } else if (ele < arr.get(mid)) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return index;
        }
    }
}
