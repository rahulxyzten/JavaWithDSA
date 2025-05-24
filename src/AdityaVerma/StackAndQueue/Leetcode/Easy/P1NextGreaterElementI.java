package AdityaVerma.StackAndQueue.Leetcode.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P1NextGreaterElementI {
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] num2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, num2)));
    }


    //Optimal solution
    //T(C) = O(N) + O(M)
    //N is length of nums1 and M is length of nums2
    //S(C) = O(N)
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Stack<Integer> s = new Stack<>();
        Map<Integer, Integer> mpp = new HashMap<>();
        int n = nums2.length;
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= nums2[i]) {
                s.pop();
            }
            if (s.size() == 0) mpp.put(nums2[i], -1);
            else mpp.put(nums2[i], s.peek());
            s.push(nums2[i]);
        }
        int j = 0;
        for (int num : nums1) {
            result[j++] = mpp.getOrDefault(num, -1);
        }
        return result;
    }
}
