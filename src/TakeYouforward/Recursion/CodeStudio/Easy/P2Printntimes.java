package TakeYouforward.Recursion.CodeStudio.Easy;
//problem
/*
 Print n times
Easy
0/40
Contributed by
100 upvotes
Problem statement
You are given an integer ‘n’.



Print “Coding Ninjas ” ‘n’ times, without using a loop.



Example:
Input: ‘n’  = 4

Output:
Coding Ninjas Coding Ninjas Coding Ninjas Coding Ninjas

Explanation: “Coding Ninjas” is printed 4 times.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
3


Sample Output 1:
Coding Ninjas Coding Ninjas Coding Ninjas


Explanation of sample output 1:
“Coding Ninjas” is printed 3 times.

Sample Input 2:
5


Sample Output 2:
Coding Ninjas Coding Ninjas Coding Ninjas Coding Ninjas Coding Ninjas


Expected Time Complexity:
Try to solve this in O(n).


Expected Space Complexity:
Try to solve this in O(n).


Constraints:
1 <= 'n' <= 10^4

Time Limit: 1 sec
 */

import java.util.ArrayList;
import java.util.List;

public class P2Printntimes {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(printNtimes(n));
    }

    public static List<String> printNtimes(int n) {
        List<String> ls = new ArrayList<>();
        print(ls, n);
        return ls;
    }

    //IBH method of Recursion (Aditya Verma)
    public static void print(List<String> ls, int n) {
        if (n == 1){
            ls.add("Coding Ninjas");
            return;
        }
        print(ls, n -1);
        ls.add("Coding Ninjas");
    }
}
