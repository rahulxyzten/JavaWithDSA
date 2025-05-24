package AdityaVerma.StackAndQueue.Questions;
//The Nearest Greater To left

import java.util.Arrays;
import java.util.Stack;

public class P2NearestGreaterToLeft {
    public static void main(String[] args) {
        int nums[] = {1, 3, 2, 4};
        System.out.println(Arrays.toString(nearestGreaterToLeft(nums)));
    }

    //T(C) = O(N) + O(N)
    //S(C) = (N)
    public static int[] nearestGreaterToLeft(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!s.isEmpty() && s.peek() <= nums[i]) {
                s.pop();
            }
            if (s.size() == 0) result[i] = -1;
            else result[i] = s.peek();
            s.push(nums[i]);
        }
        return result;
    }
}
