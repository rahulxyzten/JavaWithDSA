package TakeYouforward.BinarySearch.CodeStudio.Easy;
//Problem
/*
Find Nth Root Of M
Easy
0/40
Average time to solve is 10m
Contributed by
450 upvotes
Asked in companies
Problem statement
You are given two positive integers 'n' and 'm'. You have to return the 'nth' root of 'm', i.e. 'm(1/n)'. If the 'nth root is not an integer, return -1.



Note:
'nth' root of an integer 'm' is a number, which, when raised to the power 'n', gives 'm' as a result.


Example:
Input: ‘n’ = 3, ‘m’ = 27

Output: 3

Explanation:
3rd Root of 27 is 3, as (3)^3 equals 27.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
3 27


Sample Output 1:
3


Explanation For Sample Input 1:
3rd Root of 27 is 3, as (3)^3 equals 27.


Sample Input 2:
4 69


Sample Output 2:
-1


Explanation For Sample Input 2:
4th Root of 69 is not an integer, hence -1.


Expected Time Complexity:
Try to do this in O(log(n+m)).


Constraints:
1 <= n <= 30
1 <= m <= 10^9

Time Limit: 1 sec.
 */


public class P5FindNthRootOfM {
    public static void main(String[] args) {
//        int n = 3, m = 27;
//        int n = 4, m = 69;
//        int n = 9, m = 1953125;
        int n = 5, m = 32768;
        System.out.println(NthRoot(n, m));
    }


    //Optimal Solution T(C) = O(logn) & S(C) = O(1)
    public static int NthRoot(int n, int m) {
        int start = 1, end = m;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int mulOfMid = func(mid, n, m);
            if (mulOfMid == 1) {
                return mid;
            } else if (mulOfMid == 0) {
                start = mid + 1;
            } else { //mulOfMid == 2
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int func(int mid, int n, int m) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * mid;
            if (ans > m) return 2;
        }
        if (ans == m) return 1;
        return 0;
    }

}
