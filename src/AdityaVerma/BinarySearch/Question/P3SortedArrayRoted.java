package AdityaVerma.BinarySearch.Question;
//Number of times a Sorted array is rotated
//This is for distinct elements

public class P3SortedArrayRoted {
    public static void main(String[] args) {
        int[] arr = {11, 12, 15, 18, 2, 5, 6, 8};
        System.out.println(arrayRotated(arr));
    }

    //TUF Code (BEST)
    // T(C) = O(logn)
    // S(C) = O(1)
    static int arrayRotated(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        if (arr[start] < arr[end]) return 0;
        // The above line is going to be wrong if the array contains duplicates

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < arr[end]) end = mid;
            else start = mid + 1;
        }

        if (start != 0) return start;
        return 0;
    }


    //Aditya Verma Code
//    static int arrayRotated(int[] arr){
//        int start = 0;
//        int end = arr.length - 1;
//        int n = arr.length;
//        while (start <= end){
//            int mid = start + (end - start)/2;
//            int next = (mid+1) % n;
//            int prev = (mid+n - 1) % n;
//            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]){
//                return mid;
//            }
//            //This statement is always in 2nd position otherwise some testcases is field
//            else if(arr[mid] <= arr[end]){
//                end = mid - 1;
//            }
////            else if (arr[start] <= arr[mid]) {
////                    start = mid + 1;
////            }
//            else {
//                start = mid + 1;
//            }
//
//
//        }
//        return 0;
//    }

}
