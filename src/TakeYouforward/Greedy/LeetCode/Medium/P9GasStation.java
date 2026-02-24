package TakeYouforward.Greedy.LeetCode.Medium;
// Problem
/*
134. Gas Station

There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.

Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique.



Example 1:

Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
Output: 3
Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.
Example 2:

Input: gas = [2,3,4], cost = [3,4,3]
Output: -1
Explanation:
You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 0. Your tank = 4 - 3 + 2 = 3
Travel to station 1. Your tank = 3 - 3 + 3 = 3
You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
Therefore, you can't travel around the circuit once no matter where you start.


Constraints:

n == gas.length == cost.length
1 <= n <= 105
0 <= gas[i], cost[i] <= 104
The input is generated such that the answer is unique.
 */

public class P9GasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));

        int[] gas1 = {2, 3, 4};
        int[] cost1 = {3, 4, 3};
        System.out.println(canCompleteCircuit(gas1, cost1));

        int[] gas2 = {5, 1, 2, 3, 4};
        int[] cost2 = {4, 4, 1, 5, 1};
        System.out.println(canCompleteCircuit(gas2, cost2));
    }

    // Optimal Approach (Greedy) (Single iteration)
    // T(C) = O(N)
    // S(C) = O(1)
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totGas = 0, totCost = 0;
        int total = 0, result = 0;

        for (int i = 0; i < n; i++) {
            totGas += gas[i];
            totCost += cost[i];

            total += (gas[i] - cost[i]);
            if (total < 0) {
                total = 0;
                result = i + 1;
            }
        }

        if (totGas < totCost) {
            return -1;
        }

        return result;
    }

    // Optimal Approach (Greedy)
    // T(C) = O(3N) = O(N)
    // S(C) = O(1)
//    public static int canCompleteCircuit(int[] gas, int[] cost) {
//        if (sumOfArray(gas) < sumOfArray(cost)) return -1;
//
//        int n = gas.length;
//        int total = 0, result = 0;
//        for (int i = 0; i < n; i++) {
//            total += (gas[i] - cost[i]);
//            if (total < 0) {
//                total = 0;
//                result = i + 1;
//            }
//        }
//
//        return result;
//    }
//
//    public static int sumOfArray(int[] nums) {
//        int sum = 0;
//        for (int num : nums) sum += num;
//        return sum;
//    }

    // Brute Force Approach (35 / 40 Time Limit Exceeded)
    // T(C) = O(N^2)
    // S(C) = O(1)
//    public static int canCompleteCircuit(int[] gas, int[] cost) {
//        int n = gas.length;
//
//        for (int i = 0; i < n; i++) {
//            int tank = gas[i] - cost[i];
//            if (tank < 0) continue;
//
//            int j = (i + 1) % n;
//            while (j != i) {
//                tank += gas[j] - cost[j];
//                if (tank < 0) break;
//                j = (j + 1) % n;
//            }
//
//            if (j == i) return i;
//        }
//
//        return -1;
//    }
}
