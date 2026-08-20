// HCF or GCD Of Two Numbers Program
// Highest Common Factor or Greatest Common Divisor
// T(C) = O(min(num1,num2)), S(C) = O(1)

package KunalKushwaha.Cp2ConditonalsLoop;

import java.util.Scanner;

public class Hcf {
    public static void main(String[] args) {
        int num1, num2, smaller, hcf = 1;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter two numbers : ");
        num1 = s.nextInt();
        num2 = s.nextInt();
        smaller = Math.min(num1, num2);
        /*
        Brute Force / Better Approach
        Time Complexity: O(min(N1, N2))
        Space Complexity: O(1)
        */
//        for (int i = 1; i <= smaller; i++) {
//            if (num1 % i == 0 && num2 % i == 0) {
//                hcf = i;
//            }
//        }
        for (int i = smaller; i >= 1; i--) {
            if (num1 % i == 0 && num2 % i == 0) {
                hcf = i;
                break;
            }
        }

        System.out.print("The HCF of " + num1 + " & " + num2 + " is " + hcf);
    }

    /*
    Optimal Solution ( Euclidean Algorithm )
    Time Complexity: O(log(min(N1, N2)))
    Space Complexity: O(1)
    */
    public static int gcd(int num1, int num2) {
        while (num1 > 0 && num2 > 0) {
            if (num1 > num2) num1 %= num2;
            else num2 %= num1;
        }
        if (num1 == 0) return num2;
        return num1;
    }
}
