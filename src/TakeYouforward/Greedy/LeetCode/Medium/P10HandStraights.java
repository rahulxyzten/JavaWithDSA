package TakeYouforward.Greedy.LeetCode.Medium;
// Problem
/*
846. Hand of Straights

Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.

Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.



Example 1:

Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
Example 2:

Input: hand = [1,2,3,4,5], groupSize = 4
Output: false
Explanation: Alice's hand can not be rearranged into groups of 4.



Constraints:

1 <= hand.length <= 10^4
0 <= hand[i] <= 10^9
1 <= groupSize <= hand.length


Note: This question is the same as 1296: https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P10HandStraights {
    public static void main(String[] args) {

    }

    // Brute Force Approach
    // T(C) = O(n) + O(nlogn) + O(n)
    // S(C) = O(n)
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        Map<Integer, Integer> mpp = new HashMap<>();
        for (int num : hand) {
            mpp.put(num, mpp.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(hand);
        for (int num : hand) {
            if (mpp.get(num) > 0) {
                for (int i = num; i < num + groupSize; i++) {
                    if (mpp.getOrDefault(i, 0) == 0) return false;
                    mpp.put(i, mpp.get(i) - 1);
                }
            }
        }

        return true;
    }
}
