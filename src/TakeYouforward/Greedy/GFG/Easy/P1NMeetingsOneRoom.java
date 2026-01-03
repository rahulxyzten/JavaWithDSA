package TakeYouforward.Greedy.GFG.Easy;
// Problem
/*
N meetings in one room

You are given timings of n meetings in the form of (start[i], end[i]) where start[i] is the start time of meeting i and end[i] is the finish time of meeting i. Return the maximum number of meetings that can be accommodated in a single meeting room, when only one meeting can be held in the meeting room at a particular time.

Note: The start time of one chosen meeting can't be equal to the end time of the other chosen meeting.

Examples :

Input: start[] = [1, 3, 0, 5, 8, 5], end[] =  [2, 4, 6, 7, 9, 9]
Output: 4
Explanation: Maximum four meetings can be held with given start and end timings. The meetings are - (1, 2), (3, 4), (5,7) and (8,9)
Input: start[] = [10, 12, 20], end[] = [20, 25, 30]
Output: 1
Explanation: Only one meetings can be held with given start and end timings.
Input: start[] = [1, 2], end[] = [100, 99]
Output: 1
Constraints:
1 ≤ n ≤ 10^5
0 ≤ start[i] < end[i] ≤ 10^6
 */

import java.util.ArrayList;
import java.util.List;

class Meeting {
    int start, end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class P1NMeetingsOneRoom {
    public static void main(String[] args) {
//        int[] start = {1, 3, 0, 5, 8, 5};
//        int[] end = {2, 4, 6, 7, 9, 9};

//        int[] start = {10, 12, 20};
//        int[] end = {20, 25, 30};

        int[] start = {1, 2};
        int[] end = {100, 99};
        System.out.println(maxMeetings(start, end));
    }

    // Greedy Approach
    // T(C) = O(N) + O(NlogN) + O(N)
    // S(C) = O(3N) = O(N)
    public static int maxMeetings(int start[], int end[]) {
        int n = start.length;
        List<Meeting> ls = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ls.add(new Meeting(start[i], end[i]));
        }
        ls.sort((a, b) -> a.end - b.end);

        int currentEnd = ls.get(0).end;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (ls.get(i).start > currentEnd) {
                count++;
                currentEnd = ls.get(i).end;
            }
        }

        return count;
    }
}
