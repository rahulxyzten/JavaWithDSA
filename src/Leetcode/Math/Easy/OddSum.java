package Leetcode.Math.Easy;

import java.util.Scanner;

public class OddSum {
    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a number : ");
        n = s.nextInt();
        int sum = 0;
        int count = 0;
        int i = 0;
        while (count < n) {
            if (i % 2 != 0) {
                sum += i;
                System.out.print(sum + " ");
                count++;
            }
            i++;
        }
    }
}
