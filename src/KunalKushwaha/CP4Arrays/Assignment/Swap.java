package KunalKushwaha.CP4Arrays.Assignment;
//Reverser an Array

/*
 function reverse(a[0..n - 1])
     allocate b[0..n - 1]
     for i from 0 to n - 1
         b[n − 1 − i] := a[i]
     return b
*/

/*
  function reverse_in_place(a[0..n-1])
     for i from 0 to floor((n-2)/2)
         tmp := a[i]
         a[i] := a[n − 1 − i]
         a[n − 1 − i] := tmp*/

import java.util.Arrays;

public class Swap {
    public static void main(String[] args) {
        int[] arr = {1, 34, 4, 23, 839, 7};
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
