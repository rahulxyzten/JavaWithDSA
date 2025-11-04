package AdityaVerma.BinarySearch.Question;
//Find an element or searching an element in a Nearly Sorted array

public class P4SearchingNearlySortedArray {
    public static void main(String[] args) {
        int[] arr = {5, 10, 30, 20, 40};
        int target = 40;
        System.out.println(nearlySortedArray(arr, target));
    }

    // T(C) = O(logn)
    // S(C) = O(1)
    public static int nearlySortedArray(int[] arr, int target) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (mid - 1 >= start && target == arr[mid - 1]) {
                return mid - 1;
            } else if (mid + 1 <= end && target == arr[mid + 1]) {
                return mid + 1;
            } else if (target > arr[mid]) {
                start = mid + 2;
            } else {
                end = mid - 2;
            }
        }

        return -1;
    }
}
