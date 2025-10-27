package KunalKushwaha.CP4Arrays.Leetcode.Easy;
/*
989. Add to Array-Form of Integer

The array-form of an integer num is an array representing its digits in left to right order.

For example, for num = 1321, the array form is [1,3,2,1].
Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.

Example 1:

Input: num = [1,2,0,0], k = 34
Output: [1,2,3,4]
Explanation: 1200 + 34 = 1234
Example 2:

Input: num = [2,7,4], k = 181
Output: [4,5,5]
Explanation: 274 + 181 = 455
Example 3:

Input: num = [2,1,5], k = 806
Output: [1,0,2,1]
Explanation: 215 + 806 = 1021
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P17ArrayAdd {
    public static void main(String[] args) {
//        int[] num = {1,2,0,0};
//        int k = 34;
        int[] num = {2, 1, 5};
        int k = 806;
        System.out.println(addToArrayForm(num, k));
    }

    // T((C) = O(n + log10 k)
    // O(n + d) extra space where n = num.length and d = number of digits in k (the output size). More simply O(n + log10 k). The returned list stores the sum digits; additional auxiliary space is O(1)
    public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();

        int len = num.length - 1;
        while (len >= 0 || k != 0) {
            if (len >= 0) {
                k += num[len--];
            }

            result.add(0, k % 10);
            k /= 10;
        }

        return result;
    }

//    public static List<Integer> addToArrayForm(int[] num, int k) {
//        LinkedList<Integer> result = new LinkedList<>();
//        int len = num.length - 1;
//
//        //Both the condition are required becz after adding k with number if len is going to zero also but
//        //there are some K values which is going to execute till k != 0
//        //if not understand then take the below example and do dry run
//        //Input: num = [2,1,5], k = 806
//        //Output: [1,0,2,1]
//        while(len >= 0 || k != 0){
//
//            if(len >= 0){
//                k += num[len--];
//            }
//
//            result.addFirst(k % 10);
//            k /= 10;
//        }
//
//        return result;
//    }
}
