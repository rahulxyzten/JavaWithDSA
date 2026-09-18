package KunalKushwaha.Cp5Searching.BinarySearch.Assignment.Medium;

public class P1fFirst1BinaryInfiniteSortedArray {
    public static void main(String[] args) {
        long[] arr = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1};
        System.out.println(firstIndex(arr, arr.length));
    }

    // T(C) = O(logn) + O(logn) = O(2long)
    // S(C) = O(1)
    public static long firstIndex(long arr[], long n) {
        long start = 0L, end = 1L;

        while (end < n && 1L > arr[(int) end]) {
            start = end + 1;
            end = end * 2;
        }

        return binarySearch(arr, start, Math.min(n - 1, end));
    }

    static long binarySearch(long[] arr, long start, long end) {
        long result = -1;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (1L == arr[(int) mid]) {
                result = mid;
                end = mid - 1; // Continue searching left for first 1
            } else {
                start = mid + 1; // arr[mid] == 0, so search right
            }
        }

        return result;
    }
}
