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
        int start = Collections.max(boards);
        int end = boards.stream().mapToInt(Integer::intValue).sum();
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(boards, n, k, mid)){
                result = mid;
                end = mid - 1;
            }
            else start = mid + 1;
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
}
