package AdityaVerma.BinarySearch.Question;
//Binary Search on Answer Concept
//Search An Element in Bitonic Array


/*IMPORTANT*/
// Good One but Long code and lots of edge cases
//So go for the Kunal Kushwaha code (BEST CODE) which is less and
//also maintain time and space complexity
public class P12SearchInBitonicArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 12, 4, 2};
//        int[] arr = {1, 2, 3, 5, 2, 1};
        int target = 12;
        System.out.println(searchBitonicArray(arr, target));
    }

    static int searchBitonicArray(int[] arr, int target) {
        int index = maximumBitonicArray(arr);
        int a = orderAgnosticBS(arr, 0, index - 1, target);
        int b = orderAgnosticBS(arr, index, arr.length - 1, target);
        if (a == -1 && b == -1) return -1;
        else if (a == -1) return b;
        else return a;
    }

    static int maximumBitonicArray(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid > 0 && mid < n - 1) {
                if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) return mid;
                else if (arr[mid + 1] > arr[mid]) start = mid + 1;
                else end = mid - 1;
            } else if (mid == 0) {
                if (arr[0] > arr[1]) return 0;
                else return 1;
            } else if (mid == n - 1) {
                if (arr[n - 1] > arr[n - 2]) return n - 1;
                else return n - 2;
            }
        }
        return -1;
    }

    static int orderAgnosticBS(int[] arr, int start, int end, int target) {
        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) return mid;
            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
