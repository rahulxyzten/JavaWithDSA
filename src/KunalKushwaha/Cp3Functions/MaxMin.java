package KunalKushwaha.Cp3Functions;

import java.util.Scanner;

public class MaxMin {
    static int maximum(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max;
    }

    static int minimum(int a, int b, int c) {
        int min = a;
        if (b < min) {
            min = b;
        }
        if (c < min) {
            min = c;
        }
        return min;
    }

    public static void main(String[] args) {
        int a, b, c;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter three numbers : ");
        a = s.nextInt();
        b = s.nextInt();
        c = s.nextInt();
        int result1 = maximum(a, b, c);
        int result2 = minimum(a, b, c);
        System.out.println("Maximum is " + result1 + " & Minimum is " + result2);
    }
}
