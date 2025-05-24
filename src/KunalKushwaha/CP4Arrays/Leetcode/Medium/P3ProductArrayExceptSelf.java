package KunalKushwaha.CP4Arrays.Leetcode.Medium;
//Question
/*
238. Product of Array Except Self
Medium
19.6K
1.1K
Companies
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.



Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]


Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.


Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */

//Detailed Explanation
/*
https://leetcode.com/problems/product-of-array-except-self/solutions/1342916/3-minute-read-mimicking-an-interview/
*/

import java.util.Arrays;

public class P3ProductArrayExceptSelf {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4};

        //Calculating suffix (  suff[i] = suff[i + 1] * a[i + 1]  )
        //suffix of nums array is {24,12,4,1}
//        for(int i = len-1; i >= 0; i--){
//            output[i] = rightMult;
//            rightMult *= nums[i];
//        }
        //here right mul is iterated is for suff[i]

        // rightMult = 1 // suff[n - 1] = 1;
//        ans[3] = 1            rightMult = 1 * 4 = 4
//        ans[2] = 4            rightMult = 4 * 3 = 12
//        ans[1] = 12           rightMUlt = 12 * 2 = 24
//        ans[0] = 24

        //Calculating prefix (  pre[i] = pre[i - 1] * a[i - 1]  ) and the suffix
        // leftMult = 1
//        ans[0] = 24 * 1 = 24   leftMult = 1 * 1 = 1
//        ans[1] = 12 * 1 = 12   leftMult = 1 * 2 = 2
//        ans[2] = 4 * 2 = 8    leftMult = 2 * 3 = 6
//        ans[3] = 1 * 6 = 6


        int[] nums = {-1, 1, 0, -3, 3};

        // rightMult = 1
//        ans[4] = 1            rightMult = 1 * 3 = 3
//        ans[3] = 3            rightMult = 3 * -3 = -9
//        ans[2] = -9           rightMUlt = -9 * 0 = 0
//        ans[1] = 0           rightMUlt = 0 * 1 = 0
//        ans[0] = 0

        // leftMult = 1
//        ans[0] = 0 * 1 = 0   leftMult = 1 * -1 = -1
//        ans[1] = 0 * -1 = 0   leftMult = -1 * 1 = -1
//        ans[2] = -9 * -1 = 9    leftMult = -1 * 0 = 0
//        ans[3] = 3 * 0 = 0    leftMult = 0 * -3 = 0
//        ans[4] = 1 * 0 = 0
        System.out.println(Arrays.toString(productExceptSelf(nums)));

    }

    /* You must write an algorithm that runs in O(n) time and without using the
    division operation. */

    /* Approach 4 match all the condition with time complexity and space complexity */
    /* 4. Directly store the product of prefix and suffix into the final answer array
    The logic is, we don't actually need separate array to store prefix product and suffix products,
    we can do all the approach discussed in method 3 directly onto our final answer array.
    The Time Complexity would be O(n) but now, the Auxiliary Space is O(1) (excluding the final answer array).
    */

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        int leftMul = 1, rightMul = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] = rightMul;
            rightMul = rightMul * nums[i];
        }
        for (int i = 0; i < n; i++) {
            output[i] = output[i] * leftMul;
            leftMul = leftMul * nums[i];
        }
        return output;
    }



    /* Approach 3 match the condition but in extra space of O(n) */
    /*
    Similar to finding Prefix Sum Array, here we would intend to find the Prefix Product Array and Suffix Product Array for our original array,
    i.e. pre[i] = pre[i - 1] * a[i - 1] (yes, we multiply with a[i - 1] and not with a[i] on purpose) and similarly suff[i] = suff[i + 1] * a[i + 1].
    Now, at any index i our final answer ans[i] would be given by ans[i] = pre[i] * suff[i]. Why? Because the pre[i] * suff[i] contains product
    of every element before i and every element after i but not the element at index i (and that is the reson why we excluded a[i] in our prefix and suffix product).
    The Time Complexity would be O(n), but we are now using Auxilary Space of O(n) (excluding the final answer array).
     */
    //Calculating suffix (  suff[i] = suff[i + 1] * a[i + 1]  )
    //suffix of nums array is {24,12,4,1}
    //Calculating prefix (  pre[i] = pre[i - 1] * a[i - 1]  ) and the suffix
    //prefix of nums array is {1,1,2,6}

//    public static int[] productExceptSelf(int[] nums) {
//        int n = nums.length;
//        int pre[] = new int[n];
//        int suff[] = new int[n];
//        pre[0] = 1;
//        suff[n - 1] = 1;
//
//        for (int i = 1; i < n; i++) {
//            pre[i] = pre[i - 1] * nums[i - 1];
//        }
//        for (int i = n - 2; i >= 0; i--) {
//            suff[i] = suff[i + 1] * nums[i + 1];
//        }
//
//        int ans[] = new int[n];
//        for (int i = 0; i < n; i++) {
//            ans[i] = pre[i] * suff[i];
//        }
//        return ans;
//    }



    /* Approach 2 didn't match the condition */

//    //Below code gives O(n) time complexity but the code using the division operation
//    /*
//    What we would do is, we would find the product of all the numbers of our Array and then divide the product
//    with each element of the array to get the new element for that position in our final answer array.
//     */
//    /* Problem */
//    /*
//    One major con in going with this method is when we have an element as 0 in our array.
//    The problem is that, we can't perform a division by 0, as a result, we won't be able
//    to get corresponding values in our final answer array for the indices having 0 in
//    our initial array at that position.
//     */
//    public static int[] productExceptSelf(int[] nums) {
//        int n = nums.length;
//        int ans[] = new int[n];
//        int pro = 1;
//        for (int i : nums) {
//            pro *= i;
//        }
//
//        for (int i = 0; i < n; i++) {
//            ans[i] = pro / nums[i];
//        }
//        return ans;
//
//
//    }



    /* Approach 1 didn't match the condition */

//    //Below code give O(N^2) time complexity
//    public static int[] productExceptSelf(int[] nums) {
//        int[] arr = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            int sum = 1;
//            for (int j = 0; j < nums.length; j++) {
//                if (i != j) sum = sum * nums[j];
//            }
//            arr[i] = sum;
//        }
//        return arr;
//    }

}
