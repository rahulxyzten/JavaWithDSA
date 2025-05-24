package AdityaVerma.Heap.CodeStudio.Easy;
//Problem
/*
Replace Each Element Of Array With Its Corresponding Rank

Given an array of integers 'ARR’ of size ‘N’. Replace each element of this array with its corresponding rank and return the array.



The rank of an element is an integer between 1 to ‘N’ inclusive that represents how large the element is in comparison to other elements of the array. The following rules can also define the rank of an element:



1. It is an integer starting from 1.

2. The larger the element, the larger the rank. If two elements are equal, their rank must be the same.

3. It should be as small as possible.
For Example:
'ARR' = [4, 7, 2, 90]

Here, 2 is the smallest element, followed by 4, 7, and 90.

Hence rank of element 2 is 1, element 4 is 2, element 7 is 3, and element 90 is 4.

Hence we return [2, 3, 1, 4].
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
2
4 -1
Sample Output 1 :
2 1
Explanation Of Sample Input 1 :
Here, 4 is the largest element and -1 is the smallest element.

So, the rank of 4 is 2.

The rank of -1 is 1.

Thus after replacing elements with their rank we get [2, 1].
Sample Input 2 :
5
1 2 6 9 2
Sample Output 2 :
1 2 3 4 2
Explanation Of Sample Input 2 :
Here, 1 is the smallest element, 2 is the second-smallest element and 6 is the third-smallest element and 9 is the largest element.

So, the rank of 1 should be 1.

The rank of 2 should be 2.

The rank of 6 should be 3.

The rank of 9 should be 4.

Thus after replacing elements with their rank we get [1, 2, 3, 4, 2]
Constraints :
1 <= N <= 10^4
-10^9  <= ARR[i] <= 10^9

Where 'ARR[i]' denotes the 'ith' element of the array.

Time limit: 1 sec
 */

import java.util.*;

public class P5ReplaceElementOfArrayWithRank {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(4);
        arr.add(7);
        arr.add(2);
        arr.add(90);
        System.out.println(replaceWithRank(arr, arr.size()));
    }

    //Optimal Solution (Using Priority Queue)
    //T(C) = O(nlogn) + O(n) + O(n) = O(nlogn)
    //S(C) = O(n) + O(n) = O(n)
    public static List<Integer> replaceWithRank(List<Integer> arr, int n) {
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr) {
            minHeap.add(num);
        }

        int rank = 1;
        while (!minHeap.isEmpty()) {
            int min = minHeap.poll();
            if (!rankMap.containsKey(min)) {
                rankMap.put(min, rank++);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int num : arr) {
            result.add(rankMap.get(num));
        }

        return result;
    }


    //Brute Force Approach
    //T(C) = O(N^2)
    //S(C) = O(N)
//    public static List<Integer> replaceWithRank(List<Integer> arr, int n) {
//        List<Integer> result = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            Set<Integer> s = new HashSet<>();
//            for (int j = 0; j < n; j++) {
//                if (arr.get(i) > arr.get(j)) {
//                    s.add(arr.get(j));
//                }
//            }
//            int rank = s.size() + 1;
//            result.add(rank);
//        }
//
//        return result;
//    }
}
