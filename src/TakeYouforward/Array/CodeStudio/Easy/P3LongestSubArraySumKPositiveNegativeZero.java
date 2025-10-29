package TakeYouforward.Array.CodeStudio.Easy;
//Question
/*https://www.codingninjas.com/studio/problems/longest-subarray-with-sum-k_5713505 */
//The Longest Sub array with sum K [Positives and Negatives]

import java.util.HashMap;
import java.util.Map;

public class P3LongestSubArraySumKPositiveNegativeZero {
    public static void main(String[] args) {
        int[] arr = {-1, 1, 1};
        int k = 1;
        System.out.println(getLongestSubarray(arr, k));
    }

    // Optimal Approach
    // T(C) = O(N) - Every element is processed once in a single for-loop and
    // HashMap operations (get/containsKey/put) are O(1) on average, giving
    // linear time in n where n = nums.length
    // S(C) = O(N)

    public static int getLongestSubarray(int[] nums, int k) {
        int n = nums.length;
        Map<Long, Integer> preSumMap = new HashMap<>();
        long sum = 0L;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            long rem = sum - k;
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                //not understand above line go to copy and dry run above condition
                maxLen = Math.max(len, maxLen);
            }

            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }
        return maxLen;
    }


    // Brute Force Approach
    //  T(C) = O(N) and S(C) = O(1)
//    public static int getLongestSubarray(int[] nums, int k) {
//        int n = nums.length;
//        int maxLen = 0;
//        for (int i = 0; i < n; i++) {
//            int sum = 0;
//            for (int j = i; j < n; j++) {
//                sum += nums[j];
//                if (sum == k){
//                    maxLen = Math.max(maxLen, j - i + 1);
//                }
//            }
//        }
//        return maxLen;
//    }
}
