package TakeYouforward.Array.CodeStudio.Easy;
//Question
/* https://www.codingninjas.com/studio/problems/longest-subarray-with-sum-k_6682399?leftPanelTabValue=PROBLEM */
//The Longest Sub array with given Sum K(Positives)

public class P2LongestSubArrayWithSumKPositiveZero {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 1, 1,};
        int k = 3;

//        int[] arr = {2,3,5,1,9};
//        int k = 10;

//        int[] arr = {1, 2, 1, 3};
//        int k = 2;
        System.out.println(longestSubarrayWithSumK(arr, k));
    }

    public static int longestSubarrayWithSumK(int[] a, long k) {
        int n = a.length;
        int left = 0, right = 0;
        long sum = a[0];
        int maxLen = 0;
        while (right < n) {
            //if sum > k reduce the sub array from left
            //until sum becomes less or equal
            while (left <= right && sum > k) {
                sum -= a[left];
                left++;
            }
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            //move forward the right pointer
            right++;
            if (right < n) sum += a[right];
        }

        return maxLen;
    }
}
