package TakeYouforward.Greedy.LeetCode.Medium;
// Problem
/*
56. Merge Intervals

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.



Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
Example 3:

Input: intervals = [[4,7],[1,4]]
Output: [[1,7]]
Explanation: Intervals [1,4] and [4,7] are considered overlapping.


Constraints:

1 <= intervals.length <= 10^4
intervals[i].length == 2
0 <= starti <= endi <= 10^4
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P6MergeIntervals {
    public static void main(String[] args) {
//        int intervals[][] = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int intervals[][] = {{1, 4}, {4, 5}};
//        int intervals[][] = {{4, 7}, {1, 4}};
        int intervals[][] = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    // Optimal solution
    // T(C) = O(N logN) + O(2N)
    // S(C) = O(N) + O(N)
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, ((a, b) -> a[0] - b[0]));
        List<int[]> ls = new ArrayList<>();

        int min = intervals[0][0], max = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (max >= intervals[i][0]) { // see the >= here
                min = Math.min(min, intervals[i][0]);
                max = Math.max(max, intervals[i][1]);
            } else {
                ls.add(new int[]{min, max});
                min = intervals[i][0];
                max = intervals[i][1];
            }
        }
        ls.add(new int[]{min, max});

        int[][] result = new int[ls.size()][2];
        for (int i = 0; i < ls.size(); i++) {
            result[i] = ls.get(i);
        }

        return result;
    }
}
