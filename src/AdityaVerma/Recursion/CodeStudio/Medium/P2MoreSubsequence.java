package AdityaVerma.Recursion.CodeStudio.Medium;
//problem
/*
More subsequence

Problem statement
You are given two strings 'A' and 'B' of length 'N' and 'M' respectively.



Return the string that has more distinct subsequences, if both strings have the same number of distinct subsequences, then return 'A'.



For Example:
'N' = 2, 'M' = 2, 'A' = "ab", 'B' = "dd".

'A' has distinct subsequences = ["a", "b", "ab"].
'B' has distinct subsequences = ["d", "dd"].
So our answer is "ab".
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
1 3
f
eeg
Sample Output 1:
eeg
Explanation of sample output 1:
'A' has distinct subsequences = ["f"].
'B' has distinct subsequences = ["e", "g", "eg", "ee", "eeg"].
So our answer is "eeg".
Sample Input 2:
3 4
abc
dddd
Sample Output 2:
abc
Constraints:
1 <= 'N', 'M' <= 30.

Time Limit: 1 sec
 */

////////////Do this problem later in DP so that all the test cases pass/////////////////////
    /*This code works well for small inputs, but it shows a Time Limit Exceeded error for
    large inputs. Therefore, for larger inputs, the Dynamic Programming (DP) approach is the best solution. */

//Do this problem latter in DP or not using recursion in hash map so that all the test cases pass
//because here the constraints of time limit not match with the solution
//for some input it match but for a large input it's going to fail
//because this is not design for recursion or recursive tree IP and OP method

import java.util.HashSet;


public class P2MoreSubsequence {
    public static void main(String[] args) {
//        String a = "ab";
//        String b = "dd";
        String a = "f";
        String b = "eeg";
        System.out.println(moreSubsequence(a.length(), b.length(), a, b));
    }

    // T(C) = O(2^N * N) + O(2^M * M) = O((2^N + 2^M) * max(N,M))
    // total number of node => O(2^N) and O(2^M)
    // work done by a node => substring & concatenation takes O(N) and O(M)
    // S(C) = O(2^N * N) + O(N) + O(2^M * M) + O(M) = O(2^N * N) + O(2^M * M)
    // total number of subsequences in HashSet * maximum length of HashSet element + recursion stack (depth of the recursion)
    public static String moreSubsequence(int n, int m, String a, String b) {
        HashSet<String> result1 = new HashSet<>();
        solve(a, "", result1);
        HashSet<String> result2 = new HashSet<>();
        solve(b, "", result2);
        if (result1.size() >= result2.size()) {
            return a;
        } else {
            return b;
        }
    }

    public static void solve(String ip, String op, HashSet<String> result) {
        if (ip.length() == 0) {
            result.add(op);
            return;
        }
        String op1 = op;
        String op2 = op;
        op2 = op2 + ip.charAt(0);
        ip = ip.substring(1);
        solve(ip, op1, result);
        solve(ip, op2, result);
    }
}
