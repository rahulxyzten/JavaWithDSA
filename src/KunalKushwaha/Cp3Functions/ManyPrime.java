//The idea is to use the fact that even numbers (except 2) are not primes.
/* Time Complexity: O(N2), Where N is the difference between the range
        Auxiliary Space: O(1) */
package KunalKushwaha.Cp3Functions;

import java.util.Scanner;

public class ManyPrime {
    static Boolean prime(int num) {
        if (num == 0 || num == 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        for (int j = 2; j * j <= num; j++) {
            if (num % j == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n1, n2;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the range with n1 and n2 : ");
        n1 = s.nextInt();
        n2 = s.nextInt();
        for (int i = n1; i <= n2; i++) {
            if (prime(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
