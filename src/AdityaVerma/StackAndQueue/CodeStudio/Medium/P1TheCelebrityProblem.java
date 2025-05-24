package AdityaVerma.StackAndQueue.CodeStudio.Medium;
//Explanation by Love Babbar

//Problem (codeStudio)
/*
The Celebrity Problem

There are ‘N’ people at a party. Each person has been assigned a unique id between 0 to 'N' - 1(both inclusive). A celebrity is a person who is known to everyone but does not know anyone at the party.

Given a helper function ‘knows(A, B)’, It will returns "true" if the person having id ‘A’ know the person having id ‘B’ in the party, "false" otherwise. Your task is to find out the celebrity at the party. Print the id of the celebrity, if there is no celebrity at the party then print -1.

Note:
1. The helper function ‘knows’ is already implemented for you.
2. ‘knows(A, B)’ returns "false", if A doesn't know B.
3. You should not implement helper function ‘knows’, or speculate about its implementation.
4. You should minimize the number of calls to function ‘knows(A, B)’.
5. There are at least 2 people at the party.
6. At most one celebrity will exist.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 50
2 <= N <= 10^4

Where ‘T’ is the total number of test cases, ‘N’ is the number of people at the party.

Time Limit: 1sec
Sample Input 1:
1
2
Call function ‘knows(0, 1)’ // returns false
Call function ‘knows(1, 0)’ // returns true
Sample Output 1:
0
Explanation For Sample Input 1:
In the first test case, there are 2 people at the party. When we call function knows(0,1), it returns false. That means the person having id ‘0’ does not know a person having id ‘1'. Similarly, the person having id ‘1’  knows a person having id ‘0’ as knows(1,0) returns true. Thus a person having id ‘0’ is a celebrity because he is known to everyone at the party but doesn't know anyone.
Sample Input 2:
1
2
Call ‘knows(0, 1)’ // returns true
Call ‘knows(1, 0)’ // returns true
2
Call ‘knows(0, 1)’ // returns false
Call ‘knows(1, 0)’ // returns false
Sample Output 2:
-1
-1
Explanation For Sample Input 2:
In first test case, there are 2 people at the party. The person having id ‘0’  knows a person having id ‘1’. The person having id ‘1’  knows a person having id ‘0’. Thus there is no celebrity at the party, because both know each other.
In second test case, there are 2 people at the party. The person having id ‘0’ does not knows a person having id ‘1’. The person having id ‘1’  also does not knows a person having id ‘0’. Thus there is no celebrity at the party, because both does not know each other.
 */

//Problem (GFG)
/*
The Celebrity Problem

A celebrity is a person who is known to all but does not know anyone at a party. If you go to a party of N people, find if there is a celebrity in the party or not.
A square NxN matrix M[][] is used to represent people at the party such that if an element of row i and column j  is set to 1 it means ith person knows jth person. Here M[i][i] will always be 0.
Return the index of the celebrity, if there is no celebrity return -1.
Note: Follow 0 based indexing.
Follow Up: Can you optimize it to O(N)


Example 1:

Input:
N = 3
M[][] = {{0 1 0},
         {0 0 0},
         {0 1 0}}
Output: 1
Explanation: 0th and 2nd person both
know 1. Therefore, 1 is the celebrity.

Example 2:

Input:
N = 2
M[][] = {{0 1},
         {1 0}}
Output: -1
Explanation: The two people at the party both
know each other. None of them is a celebrity.

Your Task:
You don't need to read input or print anything. Complete the function celebrity() which takes the matrix M and its size N as input parameters and returns the index of the celebrity. If no such celebrity is present, return -1.


Expected Time Complexity: O(N^2)
Expected Auxiliary Space: O(1)


Constraints:
2 <= N <= 3000
0 <= M[][] <= 1
 */

import java.util.Stack;

public class P1TheCelebrityProblem {
    public static void main(String[] args) {
        //GFG input
        int[][] M = {{0, 1, 0}, {0, 0, 0}, {0, 1, 0}};
        System.out.println(celebrity(M, M.length));

        //CodeStudio input
//        System.out.println(findCelebrity(2));
    }

    //codeStudio Problem
    //Optimal Solution
    //T(C) = O(N)
    //S(C) = O(N)
    //here knows() is helper function
    //for call the knows() => Runner.Knows is used
//    public static int findCelebrity(int n) {
//        Stack<Integer> s = new Stack<>();
//
//        //Step 1
//        for (int i = 0; i < n; i++) {
//            s.push(i);
//        }
//
//        //Step 2
//        while (s.size() > 1) {
//            int a = s.peek();
//            s.pop();
//
//            int b = s.peek();
//            s.pop();
//
//            if (Runner.knows(a, b)) s.push(b);
//            else s.push(a);
//        }
//        int celebrity = s.peek();
//        boolean knowAny = false, knownToAll = true;
//
//        // Verify whether the celebrity knows any other person.
//        for (int i = 0; i < n; i++) {
//            if (Runner.knows(celebrity, i)) {
//                knowAny = true;
//                break;
//            }
//        }
//
//        // Verify whether the celebrity is known to all the other person.
//        for (int i = 0; i < n; i++) {
//            if (i != celebrity && !Runner.knows(i, celebrity)) {
//                knownToAll = false;
//                break;
//            }
//        }
//
//        if (knowAny || !knownToAll) celebrity = -1;
//
//        return celebrity;
//    }


    //GFG Problem
    //Optimal Solution
    //T(C) = O(N)
    //S(C) = O(N)
    public static int celebrity(int[][] M, int n) {
        Stack<Integer> s = new Stack<>();

        //Step 1
        for (int i = 0; i < n; i++) {
            s.push(i);
        }

        //Step 2
        while (s.size() > 1) {
            int a = s.peek();
            s.pop();

            int b = s.peek();
            s.pop();

            if (knows(a, b, M)) s.push(b);
            else s.push(a);
        }

        //step 3 (Verification step)
        int ans = s.peek();

        //Row zero check
        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            if (M[ans][i] == 0) zeroCount++;
        }
        if (zeroCount != n) return -1;

        //Column one check
        int oneCount = 0;
        for (int i = 0; i < n; i++) {
            if (M[i][ans] == 1) oneCount++;
        }
        if (oneCount != n - 1) return -1;

        return ans;
    }

    public static boolean knows(int a, int b, int[][] M) {
        return M[a][b] == 1;
    }
}
