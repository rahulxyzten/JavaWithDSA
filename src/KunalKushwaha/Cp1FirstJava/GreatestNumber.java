package KunalKushwaha.Cp1FirstJava;

import java.util.Scanner;

public class GreatestNumber {
    public static void main(String[] args) {
        int a, b;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter two numbers : ");
        a = s.nextInt();
        b = s.nextInt();

        System.out.println("Greatest Number is : " + (Math.max(a, b)));
    }
}
