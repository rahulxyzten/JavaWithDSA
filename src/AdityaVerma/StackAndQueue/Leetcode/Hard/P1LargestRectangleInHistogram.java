package AdityaVerma.StackAndQueue.Leetcode.Hard;
/* LeetCode Hard*/
//Problem
/*
84. Largest Rectangle in Histogram

Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.



Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4


Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104
 */

import java.util.Stack;

public class P1LargestRectangleInHistogram {
    public static void main(String[] args) {
//        int[] heights = {2, 1, 5, 6, 2, 3};
        int[] heights = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(largestRectangleArea(heights));
    }

    //Optimal solution 1
    //T(C) = O(N) + O(N) + O(N) + O(N) + O(N) ==> O(N)
    //S(C) = O(3N)
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if (s.isEmpty()) left[i] = -1;
            else left[i] = s.peek();
            s.push(i);
        }

        while (!s.isEmpty()) s.pop();

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if (s.isEmpty()) right[i] = n;
            else right[i] = s.peek();
            s.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, (heights[i] * (right[i] - left[i] - 1)));
        }

        return maxArea;
    }

}
