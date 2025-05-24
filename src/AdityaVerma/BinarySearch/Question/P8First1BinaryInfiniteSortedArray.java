package AdityaVerma.BinarySearch.Question;
//Find the Index of First 1 in an infinite Binary Sorted Array

//Kunal Kushwaha Bala BEST
public class P8First1BinaryInfiniteSortedArray {
    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,};
        System.out.println(infiniteSorted(arr));
    }

    public static int infiniteSorted(int[] arr) {
        int start = 0;
        int end = 1;
        while (1 > arr[end]) {
//            start = end;
            start = end + 1;
            end = end * 2;
        }
//        while (1 > arr[end]) {
//            int temp = end + 1;
//            end = end + (end - start + 1) * 2;
//            start = temp;
//        }
        return binarySearch(arr, start, end);
    }

    static int binarySearch(int[] arr, int start, int end) {
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (1 == arr[mid]) {
                result = mid;
                end = mid - 1;
            } else if (1 > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }
}
