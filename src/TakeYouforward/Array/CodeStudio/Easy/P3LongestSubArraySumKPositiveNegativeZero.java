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
        System.out.println(getLongestSubarray(arr,k));
    }

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

}
