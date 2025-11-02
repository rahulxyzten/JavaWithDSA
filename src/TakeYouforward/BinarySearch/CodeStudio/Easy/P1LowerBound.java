package TakeYouforward.BinarySearch.CodeStudio.Easy;
//Question
/*
https://www.naukri.com/code360/problems/lower-bound_8165382
 */
//Implement Lower Bound

public class P1LowerBound {
    public static void main(String[] args) {

//        int[] arr = {1, 2, 2, 3, 3, 5};
//        int n = arr.length;
//        int x = 6;

//        int[] arr = {1, 3, 5, 6};
//        int x = 5;
//        int n = arr.length;

//        int[] arr = {1};
//        int x = 1;
//        int n = arr.length;

        int[] arr = {3, 5, 8, 15, 19};
        int x = 9;
        int n = arr.length;

        System.out.println(lowerBound(arr, n, x));
    }

    // T(C) = O(logn)
    // S(C) = O(1)
    public static int lowerBound(int[] arr, int n, int x) {
        int start = 0;
        int end = n - 1;
        int result = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= x) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    //Problem in below code
/*
nums = [1]
target = 1
Output 1
Expected 0
 */
//    public static int lowerBound(int[] arr, int n, int x) {
//        if (arr[0] > x) return 0;
//        if (arr[n - 1] < x) return n;
//        int start = 1;
//        int end = n - 2;
//        int result = n;
//        //If in the first of while the condition is false, so it  return n (which is length of arr
//        while (start <= end) {
//            int mid = start + (end - start) / 2;
//            if (arr[mid] >= x) {
//                result = mid;
//                end = mid - 1;
//            } else {
//                start = mid + 1;
//            }
//        }
//        return result;
//    }
//    public static int lowerBound(int[] arr, int n, int x) {
//        int start = 0;
//        int end = n - 1;
//        int result = n;
//        while (start <= end) {
//            int mid = start + (end - start) / 2;
//            if (arr[mid] >= x) {
//                result = mid;
//                end = mid - 1;
//            } else {
//                start = mid + 1;
//            }
//        }
//
//        return result;
//    }
}
