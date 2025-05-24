package KunalKushwaha.CP4Arrays.Leetcode.Easy;
/*
1295. Find Numbers with Even Number of Digits

Given an array nums of integers, return how many of them contain an even number of digits.

Example 1:

Input: nums = [12,345,2,6,7896]
Output: 2
Explanation:
12 contains 2 digits (even number of digits).
345 contains 3 digits (odd number of digits).
2 contains 1 digit (odd number of digits).
6 contains 1 digit (odd number of digits).
7896 contains 4 digits (even number of digits).
Therefore, only 12 and 7896 contain an even number of digits.
Example 2:

Input: nums = [555,901,482,1771]
Output: 1
Explanation:
Only 1771 contains an even number of digits.

Constraints:

1 <= nums.length <= 500
1 <= nums[i] <= 105
 */

public class P16EvenNumberDigits {
    public static void main(String[] args) {
        int[] nums = {12, 345, 2, 6, 7896};

        //For the below input the out should be 3 but gives 2 (ERROR)
//        int[] nums = {12, 345, 0002, 6, 7896};
        System.out.println(findNumbers(nums));
    }

    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (even(num)) count++;
        }
        return count;

    }

    private static boolean even(int num) {
        int noOfDigits = digits(num);
        return noOfDigits % 2 == 0;
    }

    private static int digits(int num) {
        if (num < 0) {
            num = num * -1;
        }
        if (num == 0) return 1;

        int count = 0;
        while (num > 0) {
            count++;
            num = num / 10;
        }
        return count;
//        return (int)(Math.log10(num)) + 1;
    }

//    public static int findNumbers(int[] nums) {
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int numberDigit = (int) Math.log10(nums[i]) + 1;
//            if (numberDigit % 2 == 0) {
//                ++count;
//            }
//        }
//        return count;
//    }


}


//    public static int findNumbers(int[] nums) {
//        int count=0;
//        for(int i =0 ; i< nums.length; i++){
//            if((nums[i]>9 && nums[i]<100) || (nums[i]>999 && nums[i]<10000) || nums[i]==100000){
//                count++;
//            }
//        }
//        return count;
//
//    }

//    public static int findNumbers(int[] nums) {
//        int c = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int n = nums[i];
//            int count = 0;
//            while (n!=0){
//                int rem = n % 10;
//                count ++;
//                n = n /10;
//            }
//            if (count % 2 == 0) c++;
//        }
//        return c;
//    }

