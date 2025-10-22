package KunalKushwaha.Cp3Functions;

import java.util.Scanner;

public class Prime {

    // Brute Force Approach
    // for (int i = 2; i <= n; i++)
    // T(C) = O(N)
    // S(C) = O(1)


    // Optimal Approach
    /* We can optimise the algorithm by only iterating up to the square root of n when
       checking for factors. This is because if n has a factor greater than its
        square root, it must also have a factor smaller than its square root.
     */
    /* For the num 36
            1 x 36
            2 x 18
            3 x 12
            4×9
            6 x 6
            9 x 4 ( repeat )
            12 x 3
            18 x 2
            36 x 1
     */
    // Time Complexity: O(sqrt(N))
    // Space Complexity : O(1)

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
//        for (int i = 2; i * i <= n; i++) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int num;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a number : ");
        num = s.nextInt();
        boolean isprime = isPrime(num);
        if (isprime) {
            System.out.println(num + " is prime");
        } else {
            System.out.println(num + " is not prime");
        }
    }
}
