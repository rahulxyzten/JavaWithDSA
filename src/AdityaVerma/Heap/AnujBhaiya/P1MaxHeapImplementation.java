package AdityaVerma.Heap.AnujBhaiya;
//Max Heap Implementation

public class P1MaxHeapImplementation {
    public static void main(String[] args) {
//        int[] arr = {10, 5, 3, 2, 4};
//        int[] arr = {40, 30, 10, 20, 15};
        // Array representation of Max-Heap
        //     10
        //    /  \
        //   5    3
        //  / \
        // 2   4
        int max = 1000;
        int[] arr = new int[max];
//        arr[0] = 10;
//        arr[1] = 5;
//        arr[2] = 3;
//        arr[3] = 2;
//        arr[4] = 4;
//        arr[0] = 40;
//        int n = 5;
//        int key = 15;
//        arr[1] = 30;
//        arr[2] = 10;
//        arr[3] = 20;
//        arr[4] = 15;
        arr[0] = 5;
        arr[1] = 3;
        arr[2] = 17;
        arr[3] = 10;
        arr[4] = 84;
        arr[5] = 19;
        int n = 6;
        //build heap
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        n = insertNode(arr, n, 6);
        n = insertNode(arr, n, 22);
        n = insertNode(arr, n, 9);

//        n = deleteRoot(arr, n);

        System.out.println(extractMax(arr));
        n = n - 1;

        System.out.println(isLeaf(4, n));

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //Function to insert a new node to the heap
    public static int insertNode(int[] arr, int n, int Key) {
        n = n + 1;
        arr[n - 1] = Key;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
//        int i = n - 1;
//        while (i > 0) {
//            int parent = (i - 1) / 2;
//            if (arr[parent] < arr[i]) {
//                swap(arr, i, parent);
//                i = parent;
//            } else {
//                break;
//            }
//        }

        // return new size of Heap
        return n;
    }


    //Function to delete the root from Heap
    public static int deleteRoot(int arr[], int n) {
        swap(arr, 0, n - 1);
        n = n - 1;
        heapify(arr, n, 0);

//        int i = 0;
//        while (i < n) {
//            int largest = i;
//            int left = 2 * i + 1;
//            int right = 2 * i + 2;
//
//            // If left child is larger than root
//            if (left < n && arr[left] > arr[largest])
//                largest = left;
//            // If right child is larger than largest so far
//            if (right < n && arr[right] > arr[largest])
//                largest = right;
//
//            // If largest is not root
//            if (largest != i) {
//                swap(arr, i, largest);
//                i = largest;
//            } else {
//                break;
//            }
//
//        }

        // return new size of Heap
        return n;
    }

    public static int extractMax(int[] arr) {
        int popped = arr[0];
        swap(arr, 0, arr.length - 1);
        heapify(arr, arr.length - 1, 0);
        return popped;
    }

    //Returning ture if given node is leaf
    public static boolean isLeaf(int pos, int n) {
        return pos >= (n / 2) && pos <= n;
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    //Swap function
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
