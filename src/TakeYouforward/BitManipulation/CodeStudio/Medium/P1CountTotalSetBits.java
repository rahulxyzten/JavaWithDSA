package TakeYouforward.BitManipulation.CodeStudio.Medium;
//Problem
/*
Count total set bits

For a given integer 'N', you have to return the number of set bits in the binary representation of the numbers from 1 to 'N'.



In a binary number '1' is considered as a set bit and '0' as not set.



Example:
If 'N' is 4, then

1 has a binary representation of 1
2 has a binary representation of 10
3 has a binary representation of 11
4 has a binary representation of 100

Hence, number of set bits is 5.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
 7
Sample Output 1:
  12
Explanation of sample input 1:
1 has a binary representation of 1
2 has a binary representation of 10
3 has a binary representation of 11
4 has a binary representation of 100
5 has a binary representation of 101
6 has a binary representation of 110
7 has a binary representation of 111

Hence number of set bits is 12.
Sample Input 2:
 5
Sample Output 2:
  7
Constraints:
 1 <= N <= 10^9
 */

public class P1CountTotalSetBits {
    public static void main(String[] args) {
        System.out.println(countSetBits(4));
    }


    //Optimal solution
    //T(C) =  O(log^2n)
    //S(C) = O(longn) recursive stack



    //so the overal olf countSetBits(n) take
    //T(C) = O(logn * logn) = O(log^2n)
    public static int countSetBits(int n) {
        if (n == 0) return 0;

        int x = largestPowerOf2InRange(n);

        int bitTill2x = x * (1 << (x - 1));
        int msb2xTon = n - (1 << x) + 1;
        int rest = n - (1 << x);

        return bitTill2x + msb2xTon + countSetBits(rest);
    }

    //largestPowerOf2InRange(n) takes logn time
    public static int largestPowerOf2InRange(int n) {
        int x = 0;
        while ((1 << x) <= n) {
            x++;
        }
        return x - 1;
    }
}
