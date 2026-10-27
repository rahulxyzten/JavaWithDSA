package TakeYouforward.BinarySearch.LeetCode.Hard;
// Problem (GFG)
/*
Minimize Max Distance of Adjacent Gas Stations

We have a horizontal number line. On that number line, we have gas stations at positions stations[0], stations[1], ..., stations[n-1]. Now, we add k more gas stations so that d, the maximum distance between adjacent gas stations is minimized. Find the smallest possible value of d. Find the answer exactly to 6 decimal places.
Note: stations sorted is in a strictly increasing order.

Examples:

Input: stations[] = [1, 2, 3, 4, 5], k = 2
Output: 1.00
Explanation: Since all gaps are already equal (1 unit each), adding extra stations in between does not reduce the maximum distance.
Input: stations[] = [3, 6, 12, 19, 33], k = 3
Output: 6.00
Explanation: The largest gap is 14 (between 19 and 33). Adding 2 stations there splits it into approx 4.67. The next largest gap is 7 (between 12 and 19). Adding 1 station splits it into 3.5. Now the maximum gap left is 6.
Constraints:

2 ≤ stations.size() ≤ 10^5
0 ≤ stations[i] ≤ 10^6
0 ≤ k ≤ 10^5
 */

public class P2MinimizeMaxDistance {
    public static void main(String[] args) {
        int[] stations = {1, 2, 3, 4, 5};
        int k = 2;
        System.out.println(minMaxDist(stations, k));
    }

    public static double minMaxDist(int[] stations, int k) {
        double left = 0.0;
        double right = 0.0;

        for (int i = 0; i < stations.length - 1; i++) {
            right = Math.max(right, stations[i + 1] - stations[i]);
        }

        while (right - left > 1e-6){
            double mid = left + (right - left) / 2.0;
            if (isPossible(mid, stations, k)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return right;
    }

    public static boolean isPossible(double maxDistance, int[] stations, int k) {
        int requiredStations = 0;

        for (int i = 0; i < stations.length - 1; i++) {
            double distance = stations[i + 1] - stations[i];
            requiredStations += (int) Math.ceil(distance / maxDistance) - 1;
            if (requiredStations > k) {
                return false;
            }
        }

        return true;
    }
}
