package AdityaVerma.Recursion.CodeStudio.Easy;
//problem
/*
Subset Sum

Problem statement
You are given an array 'nums' of ‘n’ integers.

Return all subset sums of 'nums' in a non-decreasing order.

Note:
Here subset sum means sum of all elements of a subset of 'nums'. A subset of 'nums' is an array formed by removing some (possibly zero or all) elements of 'nums'.


For example
Input: 'nums' = [1,2]

Output: 0 1 2 3

Explanation:
Following are the subset sums:
0 (by considering empty subset)
1
2
1+2 = 3
So, subset sum are [0,1,2,3].
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
3
1 2 3
Sample output 1 :
0 1 2 3 3 4 5 6
Explanation For Sample Output 1:
For the first test case,
Following are the subset sums:
0 (by considering empty subset)
1
2
1+2 = 3
3
1+3 = 4
2+3 = 5
1+2+3 = 6
So, subset-sums are [0,1,2,3,3,4,5,6]
 */

import java.util.ArrayList;
import java.util.Collections;

public class P1SubsetSum {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsetSum(nums));
    }
    public static ArrayList<Integer> subsetSum(int num[]) {
        ArrayList<Integer> result = new ArrayList<>();
        solve(num, 0, 0, result);
        Collections.sort(result);
        //If the output is required in sorted manner so add the above line
        //T(c) = O(2^n)+O(2^n log(2^n))
        //S(c) = O(2^n)
        //If the output is not required in sorted manner so
        //T(c) = (2^n) and S(c) = O(2^n)
        return result;
    }
    public static void solve(int num[], int i, int sum, ArrayList<Integer> result){
        if (i == num.length){
            result.add(sum);
            return;
        }
        solve(num, i+1, sum, result);
        sum += num[i];
        solve(num, i+1, sum, result);
        return;
    }
}
