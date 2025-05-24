//Take integer inputs till the user enters 0 and print the largest number from all.
package KunalKushwaha.Cp2ConditonalsLoop;

import java.util.Scanner;

public class Largest {
    public static void main(String[] args) {
        int num, max = 1;
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a number : ");
            num = s.nextInt();
            if (num == 0) {
                break;
            }
            if (num > max) {
                max = num;
            }

        }
        System.out.println("The Largest number of all input number is : " + max);
    }
}
