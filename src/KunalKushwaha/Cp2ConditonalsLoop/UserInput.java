/*Take integer inputs till the user enters 0 and print the sum of all numbers (HINT: while loop) */
package KunalKushwaha.Cp2ConditonalsLoop;

import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        int num, sum = 0;
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a number : ");
            num = s.nextInt();
            if (num == 0) {
                break;
            }
            sum += num;
        }
        System.out.println("The sum of all the numbers is :" + sum);
    }
}
