package AdityaVerma.Heap.CodeStudio.Medium;
//Problem
/*
Convert Min Heap To Max Heap

You are given an array of size ‘N’ which is an array representation of min-heap.



You need to convert this min-heap array representation to a max-heap array representation. Return the max-heap array representation.



For Example
Corresponding to given min heap : [1,2,3,6,7,8]

It can be converted to the following max heap: [8,7,3,6,2,1]

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
6
1 2 3 4 5 6
Sample Output 1:
true
Explanation to Sample Input 1:
The min-heap representation is:-

One of the possible max heap for a given min-heap
is [6,5,4,2,3,1]

Sample Input 2:
7
3 5 6 7 9 12 7
Sample Output 2:
true
Constraints:
1 <= ’N’ <= 5000
1 <= arr[ i ] <= 10^5

where, 'N' denotes the size of the array and arr[i] denotes the elements of the input array.

Time Limit : 1 sec
 */

import java.util.Arrays;

public class P1ConvertMinHeapToMaxHeap {
    public static void main(String[] args) {
        int[] arr = {3, 5, 9, 6, 8, 20, 10, 12, 18, 9};
        System.out.println(Arrays.toString(MinToMaxHeap(arr.length, arr)));
    }

    //T(C) = O(N)
    //S(C) = O(N) Recursive stack
    public static int[] MinToMaxHeap(int n, int[] arr) {
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        return arr;
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
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }
}
