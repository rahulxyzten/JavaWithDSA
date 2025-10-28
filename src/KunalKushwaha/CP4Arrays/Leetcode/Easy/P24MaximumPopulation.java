package KunalKushwaha.CP4Arrays.Leetcode.Easy;
//Question
/*
1854. Maximum Population Year

You are given a 2D integer array logs where each logs[i] = [birthi, deathi] indicates the birth and death years of the ith person.

The population of some year x is the number of people alive during that year. The ith person is counted in year x's population if x is in the inclusive range [birthi, deathi - 1]. Note that the person is not counted in the year that they die.

Return the earliest year with the maximum population.

Example 1:
Input: logs = [[1993,1999],[2000,2010]]
Output: 1993
Explanation: The maximum population is 1, and 1993 is the earliest year with this population.

Example 2:
Input: logs = [[1950,1961],[1960,1971],[1970,1981]]
Output: 1960
Explanation:
The maximum population is 2, and it had happened in years 1960 and 1970.
The earlier year between them is 1960.


Constraints:

1 <= logs.length <= 100
1950 <= birthi < deathi <= 2050
 */
//Explanation
/*
https://leetcode.com/problems/maximum-population-year/solutions/1198978/java-o-n-solution-with-explanation-range-addition/
 */

public class P24MaximumPopulation {
    public static void main(String[] args) {
        int[][] logs = {{1993, 1999}, {2000, 2010}};
        System.out.println(maximumPopulation(logs));
    }

    // T(C) = O(n)
//    O(N) for looping through all the logs (N = logs.length, up to 100).
//    O(R) for looping through all the possible years (from 1950 to 2050 → 101 iterations).
//    Since both are small, overall: O(N + R) ≈ O(N)
    // S(C) = O(R) where R = 2051 (constant size)
    public static int maximumPopulation(int[][] logs) {
        int[] year = new int[2051];

        for (int[] log : logs) {
            year[log[0]] += 1;
            year[log[1]] -= 1;
        }

        int maxNum = year[1950], maxYear = 1950;

        for (int i = 1951; i < 2051; i++) {
            year[i] = year[i] + year[i - 1];// Generating Prefix Sum
            if (year[i] > maxNum) {
                maxNum = year[i];
                maxYear = i;
            }
        }
        return maxYear;
    }
}
