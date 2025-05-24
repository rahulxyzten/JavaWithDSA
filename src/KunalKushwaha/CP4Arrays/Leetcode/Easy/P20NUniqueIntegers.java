package KunalKushwaha.CP4Arrays.Leetcode.Easy;
//Run the 2 code and check the text case if field then fix this
/*
1304. Find N Unique Integers Sum up to Zero

Given an integer n, return any array containing n unique integers such that they add up to 0.

Example 1:

Input: n = 5
Output: [-7,-1,1,3,4]
Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
Example 2:

Input: n = 3
Output: [-1,0,1]
Example 3:

Input: n = 1
Output: [0]

Constraints:
1 <= n <= 1000
 */
/*
Certainly! Let's walk through the example where n = 5:

You are tasked with generating an array of 5 unique integers such that their sum equals 0.

First, let's follow the approach of creating pairs of positive and negative integers:

Generate two positive integers: 1, 2
Generate two negative integers: -1, -2
Since n is odd (5), we can also add 0 to the array.
Now, combine the pairs and the 0 to create the array:
[1, -1, 2, -2, 0]

If you sum up these numbers: 1 + (-1) + 2 + (-2) + 0, you'll notice that they add up to 0.

So, for the given input n = 5, one possible array of unique integers that adds up to 0 is [1, -1, 2, -2, 0].
However, keep in mind that there can be other valid solutions as well, such as shuffling the order of
the integers or using different positive and negative integers that cancel each other out. The key is
to maintain the balance of positive and negative integers to ensure the sum is zero.
 */

import java.util.Arrays;

public class P20NUniqueIntegers {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumZero(5)));
    }

    /*Below code field some text case so best code is (BEST CODE)*/
    public static int[] sumZero(int n) {
        int[] result = new int[n];
        //Please carefully watch the condition and increment value
        for (int i = 0; i < n - 1; i += 2) {
            result[i] = i + 1;
            result[i + 1] = -(i + 1);
        }
        return result;
    }


//    public static int[] sumZero(int n) {
//        int[] result = new int[n];
//        for (int i = 0; i < (n - 1)/2; i ++) {
//            result[i] = i + 1;
//            result[n-1-i] = -(i + 1);
//        }
//        return result;
//    }


    //   //Wrong code//
//    public static int[] sumZero(int n) {
//        int[] result = new int[n];
//        for (int i = 0; i < (n - 1)/2; i ++) {
//            result[i] = i + 1;
//            result[i+1] = -(i + 1);
//        }
//        return result;
//    }

    /*
    *
Absolutely, let's go through the final version of your code step by step and understand how it works. Then, I'll provide the output for the given input n = 5.

java
Copy code
import java.util.Arrays;

public class NUniqueIntegers {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumZero(5))); // Print the array returned by sumZero(5)
    }

    public static int[] sumZero(int n) {
        int[] result = new int[n]; // Create an array to store the result
        for (int i = 0; i < (n - 1)/2; i++) {
            result[i] = i + 1;           // Assign a positive integer to the current index
            result[i + 1] = -(i + 1);    // Assign the corresponding negative integer to the next index
        }
        return result; // Return the generated array
    }
}
Here's the step-by-step explanation for n = 5:

The main method is called, and it prints the output of sumZero(5).

Inside sumZero:

Initialize an array called result with size 5: [0, 0, 0, 0, 0].
Enter the loop:

When i = 0:
Set result[0] to i + 1, which is 1. So, result[0] becomes 1.
Set result[1] to -(i + 1), which is -1. So, result[1] becomes -1.
When i = 1:
The loop condition (n - 1)/2 evaluates to (5 - 1)/2 which is 2, and 1 is less than 2.
Set result[1] to i + 1, which is 2. So, result[1] becomes 2.
Set result[2] to -(i + 1), which is -2. So, result[2] becomes -2.
The loop ends after the second iteration since i = 1.

The final array after the loop: [1, 2, -2, 0, 0].

The main method prints the array returned by sumZero(5), which is [1, 2, -2, 0, 0].

So, the output for the given code and input n = 5 is [1, 2, -2, 0, 0].*/
}
