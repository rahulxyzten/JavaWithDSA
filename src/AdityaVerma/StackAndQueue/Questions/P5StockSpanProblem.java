package AdityaVerma.StackAndQueue.Questions;

import java.util.Arrays;
import java.util.Stack;

public class P5StockSpanProblem {
    public static void main(String[] args) {
//        int[] arr = {100, 80, 60, 70, 60, 75, 85};
        int[] arr = {2, 1, 2, 4};
        System.out.println(Arrays.toString(stockSpan(arr)));
    }

    /*(GFG Practice Problem) Done without using pair*/
    //T(C) = O(N) + O(N)
    //S(C) = (N)
    public static int[] stockSpan(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if (s.empty()) result[i] = i + 1;
            else result[i] = i - s.peek();
            s.push(i);
        }
        return result;
    }
}


