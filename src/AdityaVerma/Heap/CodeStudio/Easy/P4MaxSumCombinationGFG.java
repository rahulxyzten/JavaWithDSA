package AdityaVerma.Heap.CodeStudio.Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
///////////////////////////////////////WRONG//////////////////////////////////
///////////////////////////////////////WRONG//////////////////////////////////
///////////////////////////////////////WRONG//////////////////////////////////
class Pair {
    int l;
    int m;

    Pair(int l, int m) {
        this.l = l;
        this.m = m;
    }
}

class PairSum {
    int sum;
    Pair pair;

    PairSum(int sum, int l, int m) {
        this.sum = sum;
        this.pair = new Pair(l, m);
    }

}

public class P4MaxSumCombinationGFG {
    public static void main(String[] args) {
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

            l = max.pair.l - 1;
            m = max.pair.m;
            if (l >= 0 && m >= 0 && !pairs.contains(new Pair(l, m))) {
                maxHeap.add(new PairSum((a[l] + b[m]), l, m));
                pairs.add(new Pair(l, m));
            }

            l = max.pair.l;
            m = max.pair.m - 1;
            if (l >= 0 && m >= 0 && !pairs.contains(new Pair(l, m))) {
                maxHeap.add(new PairSum((a[l] + b[m]), l, m));
                pairs.add(new Pair(l, m));
            }
        }

        return result;
    }
}

