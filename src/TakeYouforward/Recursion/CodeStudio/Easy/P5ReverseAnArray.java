package TakeYouforward.Recursion.CodeStudio.Easy;
//problem
/*
Reverse an Array
Easy
0/40
Average time to solve is 10m
Contributed by
84 upvotes
Asked in company
Problem statement
Given an array 'arr' of size 'n'.



Return an array with all the elements placed in reverse order.



Note:
You don’t need to print anything. Just implement the given function.
Example:
Input: n = 6, arr = [5, 7, 8, 1, 6, 3]

Output: [3, 6, 1, 8, 7, 5]

Explanation: After reversing the array, it looks like this [3, 6, 1, 8, 7, 5].
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
8
3 1 1 7 4 2 6 11
Sample Output 1:
11 6 2 4 7 1 1 3
Explanation Of Sample Input 1 :
After reversing the array, it looks like this [11, 6, 2, 4, 7, 1, 1, 3].
Sample Input 2:
4
8 1 3 2
Sample Output 2:
2 3 1 8
Explanation Of Sample Input 2 :
After reversing the array, it looks like this [2, 3, 1, 8].
Expected time complexity
The expected time complexity is O(n).
Constraints:
1 <= 'n' <= 10^6
-10^9 <= 'arr[i]' <=10^9
 */

import java.util.Arrays;

public class P5ReverseAnArray {
    public static void main(String[] args) {
        int[] nums = {5, 7, 8, 1, 6, 3};
        int n = nums.length;
        reverseArray(n, nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void reverseArray(int n, int[] nums) {
        int start = 0;
        int end = n - 1;
        swap(nums, start, end);
    }

    public static void swap(int[] nums, int start, int end) {
        //Don't use while loop while(start < end) because if the start and end are changing inside
        //while loop then while is good but here take if because it only checks
        //if else for condition checking
        //while loop for iteration
        if (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            swap(nums, start + 1, end - 1);
        }
    }
    //Error
    /*
     public static void swap(int[] nums, int start, int end) {
        while (start < end) { //eta pura bhul code ayee k ki start < end  always true
            //aau eta mane chage nai hebar while loop re ta eta khali execute heuthiba
            //na to start++ aau end -- aau recursion function call kebe nai huaa
            //If you have a while(start < end) so teh start and end must be increment and
            //decrement inside the while loop not outside the while loop
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
        start++;
        end--;
        swap(nums, start, end);
    }

     */

}
