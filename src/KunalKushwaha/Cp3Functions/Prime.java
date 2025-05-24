package KunalKushwaha.Cp3Functions;

import java.util.Scanner;

public class Prime {
    static boolean prime(int num) {
        int c = 2;
        //base condition
        if (num <= 1) {
            return false;
        }
        while (c * c <= num) {
            if (num % c == 0) {
                return false;
            }
            c = c + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        int num;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a number : ");
        num = s.nextInt();
        boolean isprime = prime(num);
        if (isprime) {
            System.out.println(num + " is prime");
        } else {
            System.out.println(num + " is not prime");
        }
    }
}
