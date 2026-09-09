package TakeYouforward.Array.CodeStudio.Easy;
// Question
/*
https://www.naukri.com/code360/problems/ninja-and-the-second-order-elements_6581960
 */
// Find Second Smallest and Second-Largest Element in an array

import java.util.Arrays;

public class P1SecondLargestSmallestNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 7, 5};
//        int[] arr = {1};
        System.out.println(Arrays.toString(getSecondOrderElements(arr.length, arr)));
    }

    //    T(C) = O(N), one traversal
//    S(C) = O(1)
    public static int[] getSecondOrderElements(int n, int[] a) {
        if (n < 2) return new int[]{-1, -1};

        int max = Integer.MIN_VALUE;
        int sMax = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sMin = Integer.MAX_VALUE;

        for (int num : a) {
            if (num < min) {
                sMin = min;
                min = num;
            } else if (num < sMin && num != min) {
                sMin = num;
            }
        }

        // For dry run [1,2,4,7,7,5]
        for (int num : a) {
            if (num > max) {
                sMax = max;
                max = num;
            } else if (num > sMax && num != max) {
                sMax = num;
            }
        }

        return new int[]{sMax, sMin};
    }


    //    T(C) = O(N), still needed to do two traversals
//    S(C) = O(1)
//    public static int[] getSecondOrderElements(int n, int[] a) {
//        if (n < 2) return new int[]{-1, -1};
//        int max = Integer.MIN_VALUE;
//        int sMax = Integer.MIN_VALUE;
//        int min = Integer.MAX_VALUE;
//        int sMin = Integer.MAX_VALUE;
//
//        for (int num : a) {
//            max = Math.max(max, num);
//            min = Math.min(min, num);
//        }
//
//        for (int num : a) {
//            if (num > sMax && num != max) sMax = num;
//            if (num < sMin && num != min) sMin = num;
//        }
//
//        return new int[]{sMax, sMin};
//    }
}
