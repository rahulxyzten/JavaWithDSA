package TakeYouforward.Greedy.GFG.Medium;
// Problem
/*
Minimum Platforms

Given arrival arr[] and departure dep[] times of trains on the same day, find the minimum number of platforms needed so that no train waits. A platform cannot serve two trains at the same time; if a train arrives before another departs, an extra platform is needed.

Note: Time intervals are in the 24-hour format (HHMM) , where the first two characters represent hour (between 00 to 23 ) and the last two characters represent minutes (this will be <= 59 and >= 0). Leading zeros for hours less than 10 are optional (e.g., 0900 is the same as 900).

Examples:

Input: arr[] = [900, 940, 950, 1100, 1500, 1800], dep[] = [910, 1200, 1120, 1130, 1900, 2000]
Output: 3
Explanation: There are three trains during the time 9:40 to 12:00. So we need a minimum of 3 platforms.
Input: arr[] = [900, 1235, 1100], dep[] = [1000, 1240, 1200]
Output: 1
Explanation: All train times are mutually exclusive. So we need only one platform.
Input: arr[] = [1000, 935, 1100], dep[] = [1200, 1240, 1130]
Output: 3
Explanation: All 3 trains have to be there from 11:00 to 11:30
Constraints:
1 ≤ number of trains ≤ 50000
0000 ≤ arr[i] ≤ dep[i] ≤ 2359
 */

import java.util.Arrays;

public class P3MinimumPlatforms {
    public static void main(String[] args) {
//        int[] arr = {900, 940, 950, 1100, 1500, 1800};
//        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};

//        int[] arr = {900, 1235, 1100};
//        int[] dep = {1000, 1240, 1200};

//        int[] arr = {1000, 935, 1100};
//        int[] dep = {1200, 1240, 1130};

        int[] arr = {1114, 825, 357, 1415, 54};
        int[] dep = {1740, 1110, 2238, 1535, 2323};

        System.out.println(minPlatform(arr, dep));
    }

    // Optimal Approach
    // T(C) = O(2nlogn) + O(n)
    // S(C) = O(1)
    public static int minPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int maxCount = 0, count = 0;
        int i = 0, j = 0;
        // We will go till arr.length because for arrival array only the count is increase
        while (i < arr.length) {
            if (arr[i] <= dep[j]) {
                count++;
                maxCount = Math.max(maxCount, count);
                i++;
            } else { // arr[i] > dep[j]
                count--;
                j++;
            }
        }

        return maxCount;
    }


    // Brute Force Approach (Wrong)
    // Will do brute force letter
    // T(C) = O(N^2)
    // S(C) = O(1)
//    public static int minPlatform(int arr[], int dep[]) {
//        int maxCount = 0;
//        for (int i = 0; i < arr.length; i++) {
//            int count = 1;
//            for (int j = 0; j < arr.length; j++) {
//                if (j == i) continue;
//                if (arr[j] <= dep[i] && dep[j] >= arr[i]) {
//                    count++;
//                }
//            }
//            maxCount = Math.max(maxCount, count);
//        }
//
//        return maxCount;
//    }
}