package AdityaVerma.Recursion.CodeStudio.Medium;
//problem
/*
Binary strings with no consecutive 1s.

Problem statement
You have been given an integer 'N'. Your task is to generate and return all binary strings of length 'N' such that there are no consecutive 1's in the string.

A binary string is that string which contains only ‘0’ and ‘1’.

For Example:
Let ‘N'=3, hence the length of the binary string would be 3.

We can have the following binary strings with no consecutive 1s:
000 001 010 100 101
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
4
Sample Output 1:
0000 0001 0010 0100 0101 1000 1001 1010
Explanation of sample input 1:
For N = 4 we get the following Strings:

0000 0001 0010 0100 0101 1000 1001 1010

Note that none of the strings has consecutive 1s. Also, note that they are in a lexicographically increasing order.
Sample Input 2:
2
Sample Output 2:
00 01 10
Constraints:
1 <= 'N' <= 20

Time limit: 1 second
 */

import java.util.ArrayList;
import java.util.List;

public class P3BinaryStringNoConsecutive1S {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(generateString(n));
    }

    public static List<String> generateString(int N) {
        List<String> result = new ArrayList<>();
        String op = "";
        solve(N, op, result);
        return result;
    }

    public static void solve(int n, String op, List<String> result) {
        if (n == 0) {
            result.add(op);
            return;
        }
        String op1 = op;
        op1 = op1 + '0';
        solve(n - 1, op1, result);
        if (op.length() == 0 || op.charAt(op.length() - 1) != '1') {
            String op2 = op;
            op2 = op2 + '1';
            solve(n - 1, op2, result);
        }
        return;
    }
}
