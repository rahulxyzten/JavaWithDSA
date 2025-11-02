package AdityaVerma.BinarySearch.Question;
//Count of an element in sorted array
/*
https://www.naukri.com/code360/problems/occurrence-of-x-in-a-sorted-array_630456
 */

//Count = Last Occurrence - First Occurrence + 1

public class P2CountSortedArray {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 9, 10, 14, 15, 20, 30, 40, 45, 70};
//        int element = 4;
        int[] arr = {1, 2, 4, 4, 5};
        int element = 6;
//        int count = 0;
//        int firstOccur = firstOccurrence(arr, element);
//        int lastOccur = lastOccurrence(arr, element);
//        if (firstOccur == -1 && lastOccur == -1) {
//            count = 0;
//        } else {
//            count = lastOccur - firstOccur + 1;
//        }
//        System.out.println("The count of " + element + " is " + count);
    }

    // T(C) = O(2logn)
    // S(C) = O(1)
    public static int count(int arr[], int n, int x) {
        int firstIndex = search(arr, x, true);
        if (firstIndex == -1) return 0;

        int lastIndex = search(arr, x, false);
        return lastIndex - firstIndex + 1;
    }

    public static int search(int[] arr, int target, boolean findStartIndex) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                result = mid;
                if (findStartIndex) end = mid - 1;
                else start = mid + 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }


//        public static int count(int arr[], int n, int x) {
//        int count = 0;
//        int firstOccur = firstOccurrence(arr, x);
//        int lastOccur = lastOccurrence(arr, x);
//        if (firstOccur == -1 && lastOccur == -1) {
//            return 0;
//        }else{
//             count =  lastOccur - firstOccur + 1;
//        }
//
//        return count;
//    }

//    static int firstOccurrence(int[] arr, int element) {
//        int start = 0;
//        int end = arr.length - 1;
//        int result = -1;
//        boolean isAsc = arr[start] < arr[end];
//
//        while (start <= end) {
//            int mid = start + (end - start) / 2;
//
//            if (element == arr[mid]) {
//                result = mid;
//                end = mid - 1;
//            }
//            //Ena sadhabele aag aag k thelba nehita pachh pachh k thelba first aau last ta paibarlagai
//            else {
//                if (isAsc) {
//                    if (element > arr[mid]) {
//                        start = mid + 1;
//                    } else {
//                        end = mid - 1;
//                    }
//                } else {
//                    if (element > arr[mid]) {
//                        end = mid - 1;
//                    } else {
//                        start = mid + 1;
//                    }
//                }
//            }
//        }
//
//        return result;
//    }

//    static int lastOccurrence(int[] arr, int element) {
//        int start = 0;
//        int end = arr.length - 1;
//        int result = -1;
//        boolean isAsc = arr[start] < arr[end];
//
//        while (start <= end) {
//            int mid = start + (end - start) / 2;
//
//            if (element == arr[mid]) {
//                result = mid;
//                start = mid + 1;
//            } else {
//                if (isAsc) {
//                    if (element > arr[mid]) {
//                        start = mid + 1;
//                    } else {
//                        end = mid - 1;
//                    }
//                } else {
//                    if (element > arr[mid]) {
//                        end = mid - 1;
//                    } else {
//                        start = mid + 1;
//                    }
//                }
//            }
//        }
//
//        return result;
//    }
}
