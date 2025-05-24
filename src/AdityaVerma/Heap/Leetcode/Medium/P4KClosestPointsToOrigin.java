package AdityaVerma.Heap.Leetcode.Medium;
//Problem
/*
973. K Closest Points to Origin

Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).



Example 1:


Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 */

import java.util.Arrays;
import java.util.PriorityQueue;

class Pair2 {
    int a;
    int b;

    Pair2(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

class Pair1 {
    int distance;
    Pair2 pair;

    Pair1(int distance, int a, int b) {
        this.distance = distance;
        this.pair = new Pair2(a, b);
    }
}

public class P4KClosestPointsToOrigin {
    public static void main(String[] args) {
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;
        System.out.println(Arrays.deepToString(kClosest(points, k)));
    }

    //Using pair class
    //T(C) = O(nlgok)
    //S(C) = O(K)
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair1> maxHeap = new PriorityQueue<>((a, b) -> b.distance - a.distance);
        for (int[] point : points) {
            maxHeap.add(new Pair1((point[0] * point[0] + point[1] * point[1]), point[0], point[1]));
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        int[][] result = new int[k][2];
        int i = k - 1;
        while (!maxHeap.isEmpty()) {
            result[i][0] = maxHeap.peek().pair.a;
            result[i][1] = maxHeap.peek().pair.b;
            maxHeap.poll();
            i--;
        }

        return result;
    }

    //Using array
    //T(C) = O(nlogk)
    //S(C) = O(K)
//    public static int[][] kClosest(int[][] points, int k) {
//        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((p1, p2) -> Integer.compare((p2[0] * p2[0] + p2[1] * p2[1]), (p1[0] * p1[0] + p1[1] * p1[1])));
//
//        for (int[] point : points) {
//            maxHeap.add(point);
//            if (maxHeap.size() > k) {
//                maxHeap.poll();
//            }
//        }
//
//        int[][] result = new int[k][2];
//        int i = k - 1;
//        while (!maxHeap.isEmpty()) {
//            result[i] = maxHeap.poll();
//            i--;
//        }
//
//        return result;
//    }
}
