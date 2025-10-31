package TakeYouforward.Array.CodeStudio.Easy;
//Question
/*
https://www.naukri.com/code360/problems/ninja-and-the-second-order-elements_6581960
 */
//Find Second Smallest and Second-Largest Element in an array

import java.util.Arrays;

public class P1SecondLargestSmallestNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 7, 5};
//        int[] arr = {1};
        System.out.println(Arrays.toString(getSecondOrderElements(arr.length, arr)));
    }

    //    Time Complexity: O(N), Single-pass solution
//    O(N), one traversal
//    Space Complexity: O(1)
    public static int[] getSecondOrderElements(int n, int[] a) {
        if (n < 2) return new int[]{-1, -1};

        int max = Integer.MIN_VALUE;
        int sMax = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sMin = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (a[i] < min) {
                sMin = min;
                min = a[i];
            } else if (a[i] < sMin && a[i] != min) {
                sMin = a[i];
            }
        }

        //For dry run [1,2,4,7,7,5]
        for (int i = 0; i < n; i++) {
            if (a[i] > max) {
                sMax = max;
                max = a[i];
            } else if (a[i] > sMax && a[i] != max) {
                sMax = a[i];
            }
        }

        return new int[]{sMax, sMin};
    }


//    Time Complexity: O(N), We do two linear traversals in our array
//    O(N), still needed to do two traversals
//    Space Complexity: O(1)
//    public static int[] getSecondOrderElements(int n, int[] a) {
//        if (n < 2) return new int[]{-1, -1};
//        int max = Integer.MIN_VALUE;
//        int sMax = Integer.MIN_VALUE;
//        int min = Integer.MAX_VALUE;
//        int sMin = Integer.MAX_VALUE;
//
//        for (int i = 0; i < n; i++) {
//            max = Math.max(max, a[i]);
//            min = Math.min(min, a[i]);
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (a[i] > sMax && a[i] != max) sMax = a[i];
//            if (a[i] < sMin && a[i] != min) sMin = a[i];
//        }
//
//        return new int[]{sMax, sMin};
//    }
}
