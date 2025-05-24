//HCF or GCD Of Two Numbers Program
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
        for (int i = 1; i <= smaller; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                hcf = i;
            }
        }
        System.out.print("The HCF of " + num1 + " & " + num2 + " is " + hcf);

    }

}
