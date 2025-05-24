package AdityaVerma.Heap.Leetcode.Hard;
//Problem(GFG Question)
/*
Merge k Sorted Arrays

Given K sorted arrays arranged in the form of a matrix of size K*K. The task is to merge them into one sorted array.
Example 1:

Input:
K = 3
arr[][] = {{1,2,3},{4,5,6},{7,8,9}}
Output: 1 2 3 4 5 6 7 8 9
Explanation:Above test case has 3 sorted
arrays of size 3, 3, 3
arr[][] = [[1, 2, 3],[4, 5, 6],
[7, 8, 9]]
The merged list will be
[1, 2, 3, 4, 5, 6, 7, 8, 9].
Example 2:

Input:
K = 4
arr[][]={{1,2,3,4},{2,2,3,4},
         {5,5,6,6},{7,8,9,9}}
Output:
1 2 2 2 3 3 4 4 5 5 6 6 7 8 9 9
Explanation: Above test case has 4 sorted
arrays of size 4, 4, 4, 4
arr[][] = [[1, 2, 2, 2], [3, 3, 4, 4],
[5, 5, 6, 6], [7, 8, 9, 9 ]]
The merged list will be
[1, 2, 2, 2, 3, 3, 4, 4, 5, 5,
6, 6, 7, 8, 9, 9].
Your Task:
You do not need to read input or print anything. Your task is to complete mergeKArrays() function which takes 2 arguments, an arr[K][K] 2D Matrix containing K sorted arrays and an integer K denoting the number of sorted arrays, as input and returns the merged sorted array ( as a pointer to the merged sorted arrays in cpp, as an ArrayList in java, and list in python)

Expected Time Complexity: O(K2*Log(K))
Expected Auxiliary Space: O(K2)

Constraints:
1 <= K <= 100
 */

import java.util.ArrayList;
import java.util.PriorityQueue;

class Pair {
    int data;
    int i;
    int j;

    Pair(int data, int row, int col) {
        this.data = data;
        this.i = row;
        this.j = col;
    }
}

public class P2MergeKSortedArrays {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(mergeKArrays(arr, 3));
    }


    //T(C) = O(n*klogk)
    //S(C) = O(K) + O(n * k)
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.data - b.data);

        //step1
        for (int i = 0; i < K; i++) {
            minHeap.add(new Pair(arr[i][0], i, 0));
        }

        //step2
        while (!minHeap.isEmpty()) {
            Pair min = minHeap.peek();
            result.add(min.data);
            minHeap.poll();

            int i = min.i;
            int j = min.j;
            if (j + 1 < arr[i].length) {
                minHeap.add(new Pair(arr[i][j + 1], i, j + 1));
            }

        }

        return result;
    }
}
