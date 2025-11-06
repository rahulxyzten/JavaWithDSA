package AdityaVerma.BinarySearch.CodeStudio.Medium;
//Question
/*
https://www.naukri.com/code360/problems/painter-s-partition-problem_1089557
 */
//Painter's Partition Problem

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class P3PainterPartitionProblem {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(10, 20, 30, 40));
        int k = 2;//no of painter
        int ans = findLargestMinDistance(arr, k);
        System.out.println("The answer is: " + ans);

    }

    public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
        int n = boards.size();
        if (k > n) return -1;
        int start = Integer.MIN_VALUE, end = 0;
        for (int num : boards) {
            start = Math.max(start, num);
            end += num;
        }
        int result = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(boards, n, k, mid)) {
                result = mid;
                end = mid - 1;
            } else start = mid + 1;
        }

        return result;
    }

    static boolean isValid(ArrayList<Integer> boards, int n, int m, int maxEle) {
        int student = 1;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum = sum + boards.get(i);
            if (sum > maxEle) {
                student++;
                sum = boards.get(i);
            }
            if (student > m) return false;
        }

        return true;
    }

    //T(C) & S(C)
    /*
    Time Complexity: O(N * log(sum(arr[])-max(arr[])+1))
    where N = size of the array,
    sum(arr[]) = sum of all array elements,
    max(arr[]) = maximum of all array elements.
    Reason: We are applying binary search on [max(arr[]), sum(arr[])]. Inside the loop, we are calling the isValid() function
    for the value of ‘mid’. Now, inside the isValid() function, we are using a loop that runs for N times.

    Space Complexity: O(1) as we are not using any extra space to solve this problem.
     */
}
