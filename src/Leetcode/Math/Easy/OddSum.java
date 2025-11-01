package Leetcode.Math.Easy;

import java.util.Scanner;

// Print the cumulative sum of the first n odd numbers.
// Input: 5
// Output: 1, 4, 9, 16, 25
// Because the first n odd numbers are: 1, 3, 5, 7, 9
// And their cumulative sums are: 1, 4, 9, 16, 25

public class OddSum {
    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a number : ");
        n = s.nextInt();
        int sum = 0, count = 0, i = 0;

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
