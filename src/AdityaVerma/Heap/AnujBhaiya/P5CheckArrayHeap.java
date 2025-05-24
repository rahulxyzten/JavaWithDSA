package AdityaVerma.Heap.AnujBhaiya;
//check the given array is a max heap or not

public class P5CheckArrayHeap {
    public static void main(String[] args) {
//        int[] arr = {90, 15, 10, 7, 12, 2, 7, 3};
        int[] arr = {9, 15, 10, 7, 12, 11};
        System.out.println(isMaxHeap(arr, arr.length));
    }

    //T(C) = O(N)
    //S(C) = O(1)
    public static boolean isMaxHeap(int[] arr, int n) {
        for (int i = 0; i <= (n / 2) - 1; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < n && arr[left] > arr[i])
                return false;
            if (right < n && arr[right] > arr[i])
                return false;
        }
        return true;
    }
}
