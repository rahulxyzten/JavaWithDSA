package AdityaVerma.BinarySearch.Question;
//Binary Search on Answer Concept
//Find maximum element in Bitonic Array
//Finding the peak Element is same as finding the maximum element in Bitonic Array


/*IMPORTANT*/
// Good One but Long code and lots of edge cases
//So go for the Kunal Kushwaha code (BEST CODE) which is less and
//also maintain time and space complexity
public class P11MaximumInBitonicArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 12, 4, 2};
//                int[] arr= {1,2,3,2,1};
        System.out.println(maximumBitonicArray(arr));
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

}
