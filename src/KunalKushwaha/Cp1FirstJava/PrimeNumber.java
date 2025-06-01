package KunalKushwaha.Cp1FirstJava;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        int num;
        boolean flag = true;
        Scanner s = new Scanner(System.in);

        System.out.println("Enter a number : ");
        num = s.nextInt();

        if (num <= 1) {
            System.out.println(num + " is neither prime nor composite.");
            flag = false;
        }
        int c = 2;
        while (c * c <= num){
            if (num % c == 0){
                System.out.println(num + " is not a prime number.");
                flag = false;
                break;
            }
            c = c + 1;
        }

        if (flag) System.out.println(num + " is a prime number.");
    }
}
