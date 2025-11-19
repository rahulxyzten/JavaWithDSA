package AdityaVerma.Recursion.CodeStudio.Easy;
//problem
/*
Subset Sum

Problem statement
You are given an array 'A' of 'N' integers. You have to return true if there exists a subset of elements of 'A' that sums up to 'K'. Otherwise, return false.



For Example
'N' = 3, 'K' = 5, 'A' = [1, 2, 3].
Subset [2, 3] has sum equal to 'K'.
So our answer is True.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
4 13
4 3 5 2
Sample Output 1 :
No
Sample Input 2 :
5 14
4 2 5 6 7
Sample Output 2 :
Yes
Constraints :
1 <= 'N' <= 10^3
1 <= 'A[i]' <= 10^3
1 <= 'K' <= 10^3
Time Limit: 1 sec
 */

////////////Do this problem later in DP so that all the test cases pass/////////////////////
    /*This code works well for small inputs, but it shows a Time Limit Exceeded error for
    large inputs because 1 ≤ N ≤ 10³. Therefore, for larger inputs,
    the Dynamic Programming (DP) approach is the best solution. */

public class P2SubsetSumBoolean {
    public static void main(String[] args) {
//        int n = 3, k = 5;
//        int[] a = {1, 2, 3};
        int n = 4, k = 13;
        int[] a = {4, 3, 5, 2};
//        int n = 94, k = 84;
//       int[] a = {22, 17, 19, 46, 48, 27, 22, 39, 20, 13, 18, 50, 36, 45, 4, 12, 23, 34, 24, 15, 42, 12, 4, 19, 48, 45, 13, 8, 38, 10, 24, 42, 30, 29, 17, 36, 41, 43, 39, 7, 41, 43, 15, 49, 47, 6, 41, 30, 21, 1, 7, 2, 44, 49, 30, 24, 35, 5, 7, 41, 17, 27, 32, 9, 45, 40, 27, 24, 38, 39, 19, 33, 30, 42, 34, 16, 40, 9, 5, 31, 28, 7, 24, 37, 22, 46, 25, 23, 21, 30, 28, 24, 48, 13};

        System.out.println(isSubsetPresent(n, k, a));
    }

    //This is the good code for small input, but it is shows Time Limit exceed for big input like
    //        int n = 94, k = 84;
    //       int[] a = {22, 17, 19, 46, 48, 27, 22, 39, 20, 13, 18, 50, 36, 45, 4, 12, 23, 34, 24, 15, 42, 12, 4, 19, 48, 45, 13, 8, 38, 10, 24, 42, 30, 29, 17, 36, 41, 43, 39, 7, 41, 43, 15, 49, 47, 6, 41, 30, 21, 1, 7, 2, 44, 49, 30, 24, 35, 5, 7, 41, 17, 27, 32, 9, 45, 40, 27, 24, 38, 39, 19, 33, 30, 42, 34, 16, 40, 9, 5, 31, 28, 7, 24, 37, 22, 46, 25, 23, 21, 30, 28, 24, 48, 13};
    //So for this problem do th code in Dynamic Programing concept which is good for big output
    //and also the problem is DP problem

    // T(C) = O(2^N)
    // total number of node O(2^N)
    // work done by a node => O(1)
    // S(C) = O(N)
    // recursion stack (depth of the recursion)

    // Improvisation (avoiding unnecessary recursion)
    public static boolean isSubsetPresent(int n, int k, int[] a) {

        return solve(a, n, 0, k);
    }

    public static boolean solve(int[] a, int n, int i, int k) {
        if (k == 0) {
            return true;
        }
        if (k < 0) {
            return false;
        }
        if (i == n) return false;

        boolean b1 = solve(a, n, i + 1, k);
        boolean b2 = solve(a, n, i + 1, k - a[i]);

        return b1 || b2;
    }


//    public static boolean isSubsetPresent(int n, int k, int[] a) {
//
//        return solve(a, n, 0, 0, k);
//    }
//
//    public static boolean solve(int[] a, int n, int i, int sum, int k) {
//        if (i == n) {
//            return sum == k;
//        }
//
//        boolean b1 = solve(a, n, i + 1, sum, k);
//        sum += a[i];
//        boolean b2 = solve(a, n, i + 1, sum, k);
//
//        return b1 || b2;
//    }
}
