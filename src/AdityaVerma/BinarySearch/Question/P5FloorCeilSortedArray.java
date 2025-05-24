package AdityaVerma.BinarySearch.Question;
//Find Floor and Ceil of an element in a Sorted Array

public class P5FloorCeilSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 8, 10, 10, 12, 19};
        int element = 9;
        System.out.println(floor(arr, element));
        System.out.println(ceil(arr,element));
    }


    public static int floor(int[] arr, int element) {
        int start = 0, end = arr.length - 1, result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (element == arr[mid]) {
                return arr[mid];
            } else if (arr[mid] < element) {
                result = arr[mid];
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return result;
    }
    public static int ceil(int[] arr, int element) {
        int start = 0, end = arr.length - 1, result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (element == arr[mid]) {
                return arr[mid];
            } else if (arr[mid] > element) {
                result = arr[mid];
                end = mid - 1;
            }
            else if (arr[mid] < element) {
                start = mid + 1;
            }
        }
        return result;
    }
}
