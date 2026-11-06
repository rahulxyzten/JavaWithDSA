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

import java.util.PriorityQueue;

class Pair {
    double distance;
    int index;

    Pair(double distance, int index) {
        this.distance = distance;
        this.index = index;
    }
}

public class P2MinimizeMaxDistance {
    public static void main(String[] args) {
//        int[] stations = {1, 2, 3, 4, 5};
//        int k = 4;
        int[] stations = {3, 6, 12, 19, 33};
        int k = 3;
        System.out.println(minMaxDist(stations, k));
    }

    // Optimal Approach (Using Binary Search)
    // T(C) = O(n) + O(nlog(maxSectionLength / 10^-6))
    // S(C) = O(1)
    public static double minMaxDist(int[] stations, int k) {
        int n = stations.length;
        double start = 0, end = 0;
        for (int i = 0; i < (n - 1); i++) {
            end = Math.max(end, (stations[i + 1] - stations[i]));
        }

        while (end - start > 1e-6) {
            double mid = start + (end - start) / 2.0;
            if (stationsCount(stations, n, mid) > k) start = mid;
            else end = mid;
        }

        return end;
    }

    public static int stationsCount(int[] stations, int n, double maxLength) {
        int count = 0;
        for (int i = 0; i < (n - 1); i++) {
            int diff = stations[i + 1] - stations[i];
            count += (int) Math.ceil(diff / maxLength) - 1;
        }

        return count;
    }


    // Better Approach (Using Priority Queue)
    // T(C) = O(n * logn) + O(k * logn) = O((n+k)logn)
    // S(C) = O(2(n-1))
//    public static double minMaxDist(int[] stations, int k) {
//        int n = stations.length;
//        int[] howManyStations = new int[n - 1];
//        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.distance, a.distance));
//
//        for (int i = 0; i < (n - 1); i++) {
//            int diff = stations[i + 1] - stations[i];
//            pq.add(new Pair(diff, i));
//        }
//
//        for (int i = 0; i < k; i++) {
//            Pair top = pq.poll();
//            int sectionIndex = top.index;
//            howManyStations[sectionIndex]++;
//
//            int originalDiff = stations[sectionIndex + 1] - stations[sectionIndex];
//            double newSectionLength = (double) originalDiff / (howManyStations[sectionIndex] + 1);
//            pq.add(new Pair(newSectionLength, sectionIndex));
//        }
//
//        return pq.peek().distance;
//    }


    // Brute Force Approach (Gives Time Limit Exceeded)
    // T(C) = O(k * n) + O(n) = O(k * n)
    // S(C) = O(n-1)
//    public static double minMaxDist(int[] stations, int k) {
//        int n = stations.length;
//        int[] howManyStations = new int[n - 1];
//
//        for (int i = 0; i < k; i++) {
//            double maxSectionLength = 0;
//            int maxSectionIndex = 0;
//            for (int j = 0; j < (n - 1); j++) {
//                int diff = stations[j + 1] - stations[j];
//                double sectionLength = (double) diff / (howManyStations[j] + 1);
//                if (sectionLength > maxSectionLength) {
//                    maxSectionLength = sectionLength;
//                    maxSectionIndex = j;
//                }
//            }
//
//            howManyStations[maxSectionIndex]++;
//        }
//
//        double maxDistance = 0;
//        for (int i = 0; i < (n - 1); i++) {
//            int diff = stations[i + 1] - stations[i];
//            double distance = (double) diff / (howManyStations[i] + 1);
//            maxDistance = Math.max(maxDistance, distance);
//        }
//
//        return maxDistance;
//    }
}
