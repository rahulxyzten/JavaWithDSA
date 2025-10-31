package TakeYouforward.Array.LeetCode.Medium;
//Left rotate an array by k places

import java.util.Arrays;

public class P4LeftRotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
    }

    // Optimal Solution
    // T(C) = O(k) + O(n-k) + O(n) = O(2N)
    // S(C) = O(1)
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        reverse(nums, 0, n - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // Brute and Better Approach
    // T(C) = O(k) + O(n-k) + O(k) = O(n+k)
    // S(C) = O(k%n)
//    public static void rotate(int[] nums, int k) {
//        int n = nums.length;
//        k = k % n;
//        int[] temp = new int[k];
//        for (int i = 0; i < k; i++) {
//            temp[i] = nums[i];
//        }
//        for (int i = k; i < n; i++) {
//            nums[i - k] = nums[i];
//        }
//        for (int i = n - k; i < n; i++) {
//            nums[i] = temp[i - (n - k)];
//        }
//
//        System.out.println(Arrays.toString(nums));
//    }
}
