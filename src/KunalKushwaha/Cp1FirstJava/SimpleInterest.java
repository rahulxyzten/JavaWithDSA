package KunalKushwaha.Cp1FirstJava;

import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args) {
        long p;
        int t;
        float r;
        double si;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the principle value : ");
        p = s.nextLong();
        System.out.print("Enter the Time : ");
        t = s.nextInt();
        System.out.print("Enter the rate : ");
        r = s.nextFloat();

        si = (p * t * r) / 100;
        System.out.println("Simple interest is : " + si);


    }
}
