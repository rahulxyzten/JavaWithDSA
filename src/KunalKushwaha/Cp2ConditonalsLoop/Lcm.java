//LCM Of Two Numbers
// LCM × GCD = Product of the two numbers
package KunalKushwaha.Cp2ConditonalsLoop;

import java.util.Scanner;

public class Lcm {
    public static void main(String[] args) {

        int num1, num2, gcd = 1;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter two numbers : ");
        num1 = s.nextInt();
        num2 = s.nextInt();
        int smaller = Math.min(num1, num2);
        for (int i = 1; i <= smaller; i++) {
            if (num1 % i == 0 & num2 % i == 0) {
                gcd = i;
            }
        }
        int lcm = (num1 * num2) / gcd;
        System.out.println("Lcm of " + num1 + " & " + num2 + " is " + lcm);
    }
}
