package AdityaVerma.Heap.AnujBhaiya;
//Min Heap Implementation

class MinHeap {
    private int[] arr;
    private int capacity;
    private int current_heap_size;

    public MinHeap(int n) {
        capacity = n;
        arr = new int[capacity];
        current_heap_size = 0;
    }

    public void insertKey(int Key) {
        current_heap_size = current_heap_size + 1;
        arr[current_heap_size - 1] = Key;
        for (int i = (current_heap_size / 2) - 1; i >= 0; i--) {
            heapify(arr, i);
        }
    }

    public void deleteKey(int index) {
        swap(arr, index, current_heap_size - 1);
        current_heap_size = current_heap_size - 1;
        heapify(arr, index);
    }

    //Function to delete the root from Heap
    public int extractMin() {
        int popped = arr[0];
        swap(arr, 0, current_heap_size - 1);
        current_heap_size = current_heap_size - 1;
        heapify(arr, 0);
        return popped;
    }


    public void heapify(int[] arr, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < current_heap_size && arr[left] < arr[largest])
            largest = left;

        if (right < current_heap_size && arr[right] < arr[largest])
            largest = right;

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest);
        }
    }

    //Swap function
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //Print heap
    public void print() {
        for (int i = 0; i < current_heap_size; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}

public class P2MinHeapImplementation {
    public static void main(String[] args) {
        MinHeap h = new MinHeap(11);
        h.insertKey(9);
        h.insertKey(4);
        h.insertKey(7);
        h.insertKey(2);
        h.insertKey(8);
        h.insertKey(11);
        h.insertKey(5);
        h.insertKey(1);
//        h.print();
        System.out.println(h.extractMin());
        System.out.println(h.extractMin());
        h.deleteKey(2);
        h.deleteKey(3);
        h.print();
    }
}
