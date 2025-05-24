package AdityaVerma.StackAndQueue.Questions;
//Next Smallest Element
//The Nearest Smaller To Left

import java.util.Arrays;
import java.util.Stack;

public class P3NearestSmallerToLeft {
    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(nearestSmallerToLeft(nums)));
    }

    //T(C) = O(N) + O(N)
    //S(C) = (N)
    public static int[] nearestSmallerToLeft(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
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
