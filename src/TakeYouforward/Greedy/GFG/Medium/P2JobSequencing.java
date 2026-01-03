package TakeYouforward.Greedy.GFG.Medium;
// Problem
/*
Job Sequencing Problem

You are given two arrays: deadline[], and profit[], which represent a set of jobs, where each job is associated with a deadline, and a profit. Each job takes 1 unit of time to complete, and only one job can be scheduled at a time. You will earn the profit associated with a job only if it is completed by its deadline.

Your task is to find:

The maximum number of jobs that can be completed within their deadlines.
The total maximum profit earned by completing those jobs.
Examples :

Input: deadline[] = [4, 1, 1, 1], profit[] = [20, 10, 40, 30]
Output: [2, 60]
Explanation: Job1 and Job3 can be done with maximum profit of 60 (20+40).
Input: deadline[] = [2, 1, 2, 1, 1], profit[] = [100, 19, 27, 25, 15]
Output: [2, 127]
Explanation: Job1 and Job3 can be done with maximum profit of 127 (100+27).
Input: deadline[] = [3, 1, 2, 2], profit[] = [50, 10, 20, 30]
Output: [3, 100]
Explanation: Job1, Job3 and Job4 can be completed with a maximum profit of 100 (50 + 20 + 30).
Constraints:
1 ≤ deadline.size() = profit.size() ≤ 10^5
1 ≤ deadline[i] ≤ deadline.size()
1 ≤ profit[i] ≤ 500
 */

import java.util.*;

class Job {
    int id;
    int deadline;
    int profit;

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class P2JobSequencing {
    public static void main(String[] args) {
//        int[] deadline = {4, 1, 1, 1};
//        int[] profit = {20, 10, 40, 30};

        int[] deadline = {2, 1, 2, 1, 1};
        int[] profit = {100, 19, 27, 25, 15};
        System.out.println(jobSequencing(deadline, profit));
    }

    // Greedy Approach
    // T(C) = O(N * maxDeadLine) + O(NlogN)
    // S(C) = O(maxDeadLine) + O(N)
    public static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = profit.length;
        List<Job> ls = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ls.add(new Job(i + 1, deadline[i], profit[i]));
        }
        ls.sort((a, b) -> b.profit - a.profit);

        int maxDead = 0;
        for (int num : deadline) {
            maxDead = Math.max(maxDead, num);
        }
        int[] temp = new int[maxDead + 1];

        int countProfit = 0, count = 0;
        for (Job job : ls) {
            int dead = job.deadline;
            while (dead > 0) {
                // Not equal to zero according to GFG question
                // there is nothing like Day 0
                if (temp[dead] == 0) {
                    temp[dead] = job.id;
                    countProfit += job.profit;
                    count++;
                    break;
                }
                dead--;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(count);
        result.add(countProfit);
        return result;
    }
}
