package KunalKushwaha.CP4Arrays.Assignment;
//Find all the sub array of a given array

import java.util.ArrayList;

public class SubArray {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        ArrayList<ArrayList<Integer>> subarrays = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                ArrayList<Integer> subarray = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    subarray.add(arr[k]);
                }
                subarrays.add(subarray);
            }
        }
        System.out.println(subarrays);
    }
}
