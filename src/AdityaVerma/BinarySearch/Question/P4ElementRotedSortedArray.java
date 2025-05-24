package AdityaVerma.BinarySearch.Question;
//Find an Element in a Rotated Sorted Array

public class P4ElementRotedSortedArray {
    public static void main(String[] args) {
        int[] arr = {11,12,15,18,2,5,6,8};
        int target = 6;
        int index = arrayRotated(arr);
        int a = binarySearch(arr,0,index-1,target);
        int b = binarySearch(arr,index,arr.length - 1,target);
        int result;
        if (a== -1 && b== -1) result = -1;
        else if(a == -1) result = b;
        else result = a;
        System.out.println(result);
    }
    static int arrayRotated(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        int n = arr.length;
        while (start <= end){
            int mid = start + (end - start)/2;
            int next = (mid+1) % n;
            int prev = (mid+n - 1) % n;
            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]){
                return mid;
            }
            else if(arr[mid] <= arr[end]){
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return 0;
    }
    static int binarySearch(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
