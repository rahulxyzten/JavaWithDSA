package AdityaVerma.Recursion.CodeStudio.Medium;
//problem
/*
Josephus

Problem statement
‘N’ people are standing in a circle numbered from ‘1’ to ‘N’ in clockwise order. First, the person numbered 1 will proceed in a clockwise direction and will skip K-1 persons including itself and will kill a Kth person. Now (K+1)th person from 1 will start and will kill the Kth person from itself.

You have to find the position of the last person surviving with respect to initial numbering.

Note:
A person can also kill himself.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1
2
4 2
7 3
Sample Output 1:
1
4
Explanation :-

For the first TestCase:-



The position of the last person is 1.Hence ans is 1.
For the second case:-
The first starting point is 1 and 3 is killed.
The starting point is 4 and 6 is killed.
The starting point is 7 and 2 is killed.
The starting point is 4 and 7 is killed.
The starting point is 1 and 1 is killed.
Sample Input 2
2
5 6
3 6
Sample Output2
4
1
 */

import java.util.Vector;

public class P4Josephus {
    public static void main(String[] args) {
        int n = 40, k = 7;
        System.out.println(josephus(n, k));
    }

    public static int josephus(int n, int k) {
        Vector<Integer> v = new Vector<>();
        for (int i = 1; i <= n; i++) {
            v.add(i);
        }
        k = k - 1;
        int index = 0, ans = -1;
        return solve(v, k, index, ans);
    }

    public static int solve(Vector<Integer> v, int k, int index, int ans) {
        if (v.size() == 1) {
            ans = v.get(0);
            return ans;
        }
        index = (index + k) % v.size();
        v.remove(index);
        return solve(v, k, index, ans);
    }
}
