package KunalKushwaha.Cp2ConditonalsLoop;

import java.util.Scanner;

public class Factors {
    public static void main(String[] args) {
        int num;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a number : ");
        num = s.nextInt();
        System.out.print("The factors of the " + num + " is ");
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                System.out.print(i + " ");
            }
        }


    }
}
