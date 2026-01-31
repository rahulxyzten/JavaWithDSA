package TakeYouforward.Greedy.LeetCode.Easy;
// Problem
/*
3074. Apple Redistribution into Boxes

You are given an array apple of size n and an array capacity of size m.

There are n packs where the ith pack contains apple[i] apples. There are m boxes as well, and the ith box has a capacity of capacity[i] apples.

Return the minimum number of boxes you need to select to redistribute these n packs of apples into boxes.

Note that, apples from the same pack can be distributed into different boxes.



Example 1:

Input: apple = [1,3,2], capacity = [4,3,1,5,2]
Output: 2
Explanation: We will use boxes with capacities 4 and 5.
It is possible to distribute the apples as the total capacity is greater than or equal to the total number of apples.
Example 2:

Input: apple = [5,5,5], capacity = [2,4,2,7]
Output: 4
Explanation: We will need to use all the boxes.


Constraints:

1 <= n == apple.length <= 50
1 <= m == capacity.length <= 50
1 <= apple[i], capacity[i] <= 50
The input is generated such that it's possible to redistribute packs of apples into boxes.
 */

import java.util.Arrays;
import java.util.Collections;

public class P4AppleRedistributionBoxes {
    public static void main(String[] args) {
//        int[] apple = {1, 3, 2};
//        int[] capacity = {4, 3, 1, 5, 2};

        int[] apple = {5, 5, 5};
        int[] capacity = {2, 4, 2, 7};
        System.out.println(minimumBoxes(apple, capacity));

    }

    // Greedy Approach
    // T(C) = O(n) + O(mlogm) + O(m/2) + O(m)
    // S(C) = O(1)
    public static int minimumBoxes(int[] apple, int[] capacity) {
        int totApple = 0;
        for (int a : apple) {
            totApple += a;
        }

        Arrays.sort(capacity);
        for (int i = 0; i < capacity.length / 2; i++) {
            int temp = capacity[i];
            capacity[i] = capacity[capacity.length - 1 - i];
            capacity[capacity.length - 1 - i] = temp;
        }
        // Direct Reverse
        // Integer[] capArray = new Integer[capacity.length];
        // for (int i = 0; i < capacity.length; i++) {
        //    capArray[i] = capacity[i];
        // }
        // Arrays.sort(capArray, Collections.reverseOrder());

//        int i = 0, m = capacity.length;
//        while (i < m) {
//            totApple -= capacity[i];
//            if (totApple <= 0) return i + 1;
//            i++;
//        }
//        return m;

        int need = 0;
        while (totApple > 0) {
            totApple -= capacity[need];
            need += 1;
        }

        return need;
    }
}
