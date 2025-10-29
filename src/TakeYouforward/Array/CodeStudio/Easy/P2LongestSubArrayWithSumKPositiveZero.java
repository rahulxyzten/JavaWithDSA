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

    // Optimal approach(Using Two Pointer)
    //T(C) = O(2*N), where N = size of the given array.
    /*
    Reason: The outer while loop i.e. the right pointer can move up to
    index n-1(the last index). Now, the inner while loop i.e. the left pointer
     can move up to the right pointer at most. So, every time the inner
     loop does not run for n times rather it can run for n times in total.
     So, the time complexity will be O(2N) instead of O(N2).
    O(2*N) ≈ O(N)
    Each element is visited at most twice — once by the right pointer and once by the left.*/
    // S(C) = O(1)
    public static int longestSubarrayWithSumK(int[] a, long k) {
        int n = a.length;
        int left = 0, right = 0;
        long sum = a[0];
        // see sum is type of long for edge test cases
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
