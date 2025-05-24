package AdityaVerma.StackAndQueue.Questions;
//Next Greatest Element (Variant 1)
/////////////*Go for TUF Code for teh above Problem which is implemented below*//////////////
//Next Largest Element
//The Nearest Greater To Right


import java.util.*;

public class P1NearestGreaterToRight {
    public static void main(String[] args) {
        int nums[] = {1, 3, 2, 4};
//        int nums[] = {5, 7, 1, 7, 6, 0};
        System.out.println(Arrays.toString(nearestGreaterToRight(nums)));
    }

    //TUF Solution (Best Solution)
    //T(C) = O(2N)
    //S(C) = (N)
    public static int[] nearestGreaterToRight(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= nums[i]) {
                s.pop();
            }
            if (s.size() == 0) result[i] = -1;
            else result[i] = s.peek();
            s.push(nums[i]);
        }
        return result;
    }

    //Aditya Verma Solution
    //T(C) = O(2N)
    //S(C) = (N)
//    public static int[] nearestGreaterToRight(int[] nums) {
//        int[] result = new int[nums.length];
//        Stack<Integer> s = new Stack<>();
//        for (int i = nums.length - 1; i >= 0; i--) {
//            if (s.size() == 0) {
//                result[i] = -1;
//            } else if (s.peek() > nums[i]) {
//                result[i] = s.peek();
//            } else if (s.size() > 0 && s.peek() <= nums[i]) {
//                while (s.size() > 0 && s.peek() <= nums[i]) {
//                    s.pop();
//                }
//                if (s.size() == 0) result[i] = -1;
//                else result[i] = s.peek();
//            }
//            s.push(nums[i]);
//        }
//        return result;
//    }
}
