package AdityaVerma.BinarySearch.Question;
//Find position of an element in an Infinite Sorted Array

public class P7InfiniteSortedArray {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 19, 20, 22, 23, 80, 90, 100};
//        int target = 90;
        //This code for infinite sorted array if we check for 90
        //Then after one of  the while condition end = 32 which is array index out of bound condition
        //Otherwise code is perfect for infinite sorted array
        /* IMPORTANT */
        //For the above problem check the kunal Kushwaha Code (BEST CODE)
        long[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 19, 20, 22, 23, 80, 90, 100};
        long target = 90;
        System.out.println(infiniteSorted(arr, target));
    }


    //Right code (Kunal Kushwaha Code)
    public static int infiniteSorted(long[] arr, long target) {
        long start = 0L;
        long end = 1L;
        long n = arr.length;
        while (end < n && target > arr[(int) end]) {
            //Array is long but the array indexes is integer,
            start = end + 1;
            end = end  * 2;
        }
        return binarySearch(arr, start, Math.min(n-1, end), target);
    }

    static int binarySearch(long[] arr, long start, long end, long target) {
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (target == arr[(int)mid]) {
                return (int) mid;
            } else if (target > arr[(int) mid]) {
                start = mid + 1;
            } else {
                end = mid - 1; ;
            }
        }
        return -1;
    }



//    public static int infiniteSorted(int[] arr, int target) {
//        int start = 0;
//        int end = 1;
//
//        while (target > arr[end]) {
//           start = end + 1;
//            end = end  * 2;
//        }
//        return binarySearch(arr, start, end, target);
//    }
//
//    static int binarySearch(int[] arr, int start, int end, int target) {
//        while (start <= end) {
//            int mid = start + (end - start) / 2;
//            if (target == arr[mid]) {
//                return mid;
//            } else if (target > arr[mid]) {
//                start = mid + 1;
//            } else {
//                end = mid - 1; ;
//            }
//        }
//        return -1;
//    }
}
