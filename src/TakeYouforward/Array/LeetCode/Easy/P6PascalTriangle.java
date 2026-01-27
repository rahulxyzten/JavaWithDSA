package TakeYouforward.Array.LeetCode.Easy;
// Problem
/*
118. Pascal's Triangle

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:




Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]


Constraints:

1 <= numRows <= 30
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P6PascalTriangle {
    public static void main(String[] args) {
//        int numRows = 5;
        int numRows = 1;
        System.out.println(generate(numRows));
    }


    /* Brute Force Approach */
    // T(C) = O(N^2)
    // S(C) = O(N^2) + O(N)
    // result stores all n rows with total elements {n(n+1)} / 2 = O(n^2)
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) temp.add(1);
                else {
                    temp.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(temp);
        }

        return result;
    }
}
