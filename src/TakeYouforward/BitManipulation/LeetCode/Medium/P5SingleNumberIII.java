package TakeYouforward.BitManipulation.LeetCode.Medium;

import java.util.Arrays;

public class P5SingleNumberIII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};
        System.out.println(Arrays.toString(singleNumber(nums)));
    }

    //Optimal Solution
    //T(C) = O(2N)
    //S(C) = O(1)
    public static int[] singleNumber(int[] nums) {
        long xorr = 0;
        for (int num : nums) xorr = xorr ^ num;
        long rightMost = (xorr & xorr - 1) ^ xorr;
        int b1 = 0, b2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & rightMost) != 0)
                b1 = b1 ^ nums[i];
            else
                b2 = b2 ^ nums[i];
        }
        return new int[]{b1, b2};
    }
}
