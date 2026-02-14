package TakeYouforward.Greedy.LeetCode.Medium;
// Problem (NeetCode)
/*
Meeting Rooms II

Given an array of meeting time interval objects consisting of start and end times [[start_1,end_1],[start_2,end_2],...] (start_i < end_i), find the minimum number of rooms required to schedule all meetings without any conflicts.

Note: (0,8),(8,10) is NOT considered a conflict at 8.

Example 1:

Input: intervals = [(0,40),(5,10),(15,20)]

Output: 2
Explanation:
day1: (0,40)
day2: (5,10),(15,20)

Example 2:

Input: intervals = [(4,9)]

Output: 1
Constraints:

0 <= intervals.length <= 500
0 <= intervals[i].start < intervals[i].end <= 1,000,000
 */

import java.util.Arrays;
import java.util.List;

class Interval {
    public int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}


public class P8MeetingRoomsII {
    public static void main(String[] args) {

    }

    // Optimal Approach
    // T(C) = O(n) + O(2nlogn) + O(n)
    // S(C) = O(2n)
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < intervals.size(); i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int i = 0, j = 0;
        int count = 0, maxCount = 0;

        while (i < n) {
            if (start[i] < end[j]) {
                count++;
                maxCount = Math.max(maxCount, count);
                i++;
            } else {
                count--;
                j++;
            }
        }

        return maxCount;
    }
}
