package TakeYouforward.Array.LeetCode.Medium;

import java.util.Arrays;
/* Follow-up question */
//There might be more than one sub array with the maximum sum.
//We need to print any of them (Basically print the array with maximum sum)

public class P9MaximumSubArrayFollowup {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = {-2, -1, -3, -4, -1, -2, -1, -5, -4};
        System.out.println(maxSubArray(nums));
    }

    // T(C) = O(N) and S(C) = O(1)
    public static long maxSubArray(int[] arr) {
        int n = arr.length;
        long maxi = Long.MIN_VALUE, sum = 0;
        int start = 0, ansStart = -1, ansEnd = -1;

        for (int i = 0; i < n; i++) {
            if (sum == 0) start = i; // starting index
            sum += arr[i];
            if (sum > maxi) {
                maxi = sum;
                ansStart = start;
                ansEnd = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }

        // To consider the sum of the empty subarray
        // uncomment the following check:
        if (maxi < 0) maxi = 0;
        if (maxi == 0) {
            System.out.println(Arrays.toString(new int[]{}));
        } else {
            //printing the subarray:
            System.out.print("The subarray is: [");
            for (int i = ansStart; i <= ansEnd; i++) {
                System.out.print(arr[i] + ", ");
            }
            System.out.println("]");
        }
        return maxi;
    }

}
