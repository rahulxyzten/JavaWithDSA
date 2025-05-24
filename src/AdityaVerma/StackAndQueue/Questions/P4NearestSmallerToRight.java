package AdityaVerma.StackAndQueue.Questions;
//Next Smallest Element
//The Nearest Smaller To Right

import java.util.Arrays;
import java.util.Stack;

public class P4NearestSmallerToRight {
    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(nearestSmallerToRight(nums)));
    }

    //T(C) = O(N) + O(N)
    //S(C) = (N)
    public static int[] nearestSmallerToRight(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() >= nums[i]) {
                s.pop();
            }
            if (s.size() == 0) result[i] = -1;
            else result[i] = s.peek();
            s.push(nums[i]);
        }
        return result;
    }
}
