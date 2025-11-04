package AdityaVerma.BinarySearch.Question;
//Minimum Difference Element in a Sorted Array

public class P9MinimumDifferenceElementSortedArray {
    public static void main(String[] args) {
//        int[] arr = {1, 3, 8, 10, 15};
        int[] arr = {4, 6, 10};
        int key = 2;
        System.out.println(minimumDifference(arr, key));
    }

    // T(C) = O(logn)
    // S(C) = O(1)
    public static int minimumDifference(int[] arr, int key) {
        int start = 0, end = arr.length - 1;
        if (key < arr[0]) return arr[0];
        if (key > arr[end]) return arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key == arr[mid]) return arr[mid];
            else if (key > arr[mid]) start = mid + 1;
            else end = mid - 1;
        }

        if (Math.abs(arr[start] - key) < Math.abs(arr[end] - key)) return arr[start];
        else return arr[end];
    }
}
