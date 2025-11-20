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

import java.util.ArrayList;
import java.util.List;

public class P4Josephus {
    public static void main(String[] args) {
        int n = 40, k = 7;
        System.out.println(josephus(n, k));
    }

    // T(C) = O(N * N) = O(N^2)
    // N recursive calls, each call performs a remove() operation that takes O(N)
    // S(C) = O(N) + O(N) = O(N)
    // Size of the List + recursion stack (depth of the recursion)
    public static int josephus(int n, int k) {
        List<Integer> person = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            person.add(i);
        }
        k = k - 1;
        int index = 0;
        int[] result = {-1};

        solve(person, k, index, result);
        return result[0];
    }

    public static void solve(List<Integer> person, int k, int index, int[] result) {
        if (person.size() == 1) {
            result[0] = person.get(0);
            return;
        }

        int killIndex = (index + k) % person.size();
        person.remove(killIndex);
        solve(person, k, killIndex, result);
    }
}
