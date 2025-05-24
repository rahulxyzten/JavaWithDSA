package AdityaVerma.Recursion.CodeStudio.Medium;
//problem
/*
Subarrays with Sum ‘k'

Problem statement
You are given an array 'A' of size 'N' and an integer'K'’. You need to generate and return all subarrays of array ‘A’ whose sum = ‘K’.



Note: In the output, you will see the 2D array lexicographically sorted.



Example:
Input: ‘N’ = 6 ‘K’ = 3
‘A’ = [1, 2, 3, 1, 1, 1]
Output: 3
Explanation: Subarrays whose sum = ‘3’ are:
[1, 2], [3], and [1, 1, 1]
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
6 3
1 2 3 1 1 1
Sample Output 1:
3
Explanation Of Sample Input 1:
Input: ‘N’ = 6 ‘K’ = 3
‘A’ = [1, 2, 3, 1, 1, 1]
Output: 3
Explanation: Subarrays whose sum = ‘3’ are:
[1, 2], [3], and [1, 1, 1]
Sample Input 2:
4 2
1 2 1 3
Sample Output 2:
1
Sample Input 3:
5 16
9 5 6 5 5
Sample Output 3:
2
Constraints:
1 <= N, K <= 10^3
1 <= A[i] <= 10^9

Time Limit: 1-sec
 */
/* IMPORTANT */
//Sub array means the array element must be continuous of the parent element
//Sub-arrays with Sum ‘k' It is not a question of Recursion
// u can do it in recursion, but it is hard to do it in recursion, so
// it is a two pointer question which is optimal solution
//The below code is count the no of the subsets with Sum k and return the
//both count and all the unique subsets sum is equal to k
//unique subsets means if [9 5 6 5 5] then one subset[5 6 5] and another subsets [6 5 5]
//give sum k = 16 but both the subset are same so  give one subset [ 5 5 6 ] and count = 1

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class  P1SubarraysWithSumK {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1, 1, 1};
        int k = 3;
//        int[] a = {1, 2, 1, 3};
//        int k = 2;
//        int[] a = {9, 5, 6, 5, 5};
//        int k = 16;
        System.out.println(subarraysWithSumK(a, k));

    }

    public static List<List<Integer>> subarraysWithSumK(int[] a, long k) {
        Arrays.sort(a);
        // Sorting the array to ensure lexicographical order
        HashSet<List<Integer>> hs = new HashSet<>();
        List<Integer> op = new ArrayList<>();
        solve(a, 0, 0, k, op, hs);
        System.out.println(hs.size());
        return new ArrayList<>(hs);
    }

    public static void solve(int num[], int i, int sum, long k, List<Integer> op, HashSet<List<Integer>> hs) {
        if (i == num.length) {
            if (sum == k) {
                hs.add(op);
            }
            return;
        }
        solve(num, i + 1, sum, k, op, hs);
        op.add(num[i]);
        sum += num[i];
        solve(num, i + 1, sum, k, new ArrayList<>(op), hs);
        op.remove(op.size() - 1);
    }

}
