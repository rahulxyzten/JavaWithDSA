package AdityaVerma.Heap.CodeStudio.Easy;
//Problem
/*
Day 29 : K Max Sum Combinations

You are given two arrays/lists ‘A’ and ‘B’ of size ‘N’ each. You are also given an integer ‘K’.



You must return ‘K’ distinct maximum and valid sum combinations from all the possible sum combinations of the arrays/lists ‘A’ and ‘B’.



Sum combination adds one element from array ‘A’ and another from array ‘B’.



For example :
A : [1, 3]
B : [4, 2]
K: 2

The possible sum combinations can be 5(3 + 2), 7(3 + 4), 3(1 + 2), 5(1 + 4).

The 2 maximum sum combinations are 7 and 5.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
3 2
1 3 5
6 4 2
Sample Output 1 :
11 9
Explanation of Sample Output 1 :
For the given arrays/lists, all the possible sum combinations are:
7(1 + 6), 5(1 + 4), 3(1 + 2), 9(3 + 6), 7(3 + 4), 5(3 + 2), 11(6 + 5), 9(5 + 4), 7(5 + 2).

The two maximum sum combinations from the above combinations are 11 and 9.
Sample Input 2 :
2 1
1 1
1 1
Sample Output 2 :
2
Explanation of sample input 2 :
For the given arrays/lists, two possible sum combinations are 2(1 + 1), and 2(1 + 1).
Constraints :
1 <= N <= 100
1 <= K <= N
-10^5 <= A[i], B[i] <= 10^5

'A[i]' and 'B[i]' denote the ith element in the given arrays/lists.

Time limit: 1 sec
 */

import java.util.*;
///////////////////////////////////////WRONG//////////////////////////////////
///////////////////////////////////////WRONG//////////////////////////////////
///////////////////////////////////////WRONG//////////////////////////////////
public class P3MaxSumCombination {
    public static void main(String[] args) {
//        int[] a = {3, 2};
//        int[] b = {1, 4};
//        int n = a.length;//a.length = b.length
//        int k = 2;
//        int[] a = {1, 4, 2, 3};
//        int[] b = {2, 5, 1, 6};
//        int n = a.length;
//        int k = 3;
        int[] a = {371, 349, 552, 343, 331, 721, 46, 572, 512, 469, 890, 608, 917, 719, 830, 104, 159};
        int[] b = {681, 150, 595, 597, 209, 778, 666, 965, 203, 658, 273, 404, 389, 898, 847, 253, 959};
        int n = a.length;
        int k = 6;
        System.out.println(Arrays.toString(kMaxSumCombination(a, b, n, k)));
    }

    public static int[] kMaxSumCombination(int[] a, int[] b, int n, int k) {
        int[] result = new int[k];
        int j = 0;
        Arrays.sort(a);
        Arrays.sort(b);

        PriorityQueue<PairSum> maxHeap = new PriorityQueue<>((p1, p2) -> p2.sum - p1.sum);
        HashSet<Pair> pairs = new HashSet<>();

        int l = n - 1;
        int m = n - 1;

        pairs.add(new Pair(l, m));
        maxHeap.add(new PairSum((a[l] + b[m]), l, m));

        for (int i = 0; i < k; i++) {
            PairSum max = maxHeap.poll();
            result[j++] = max.sum;

            int x = max.pair.l;
            int y = max.pair.m;
            if (x - 1 >= 0 && !pairs.contains(new Pair(x - 1, y))) {
                maxHeap.add(new PairSum(a[x - 1] + b[y], x - 1, y));
                pairs.add(new Pair(x - 1, y));
            }
            if (y - 1 >= 0 && !pairs.contains(new Pair(x, y - 1))) {
                maxHeap.add(new PairSum(a[x] + b[y - 1], x, y - 1));
                pairs.add(new Pair(x, y - 1));
            }
        }

        return result;
    }
}
