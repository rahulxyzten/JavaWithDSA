package AdityaVerma.StackAndQueue.Leetcode.Medium;
//Problem
/*
155. Min Stack
Medium
Topics
Companies
Hint
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.



Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2


Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.
 */

import java.util.Stack;

public class P3MinStack {
    public static void main(String[] args) {

    }
}

//Code with all testcases pass
//Without using extra space
//T(C) = O(1)
//S(C) = O(N)

class MinStack {
    Stack<Long> st = new Stack<>();

    long min = -1;


    public MinStack() {

    }

    public void push(int val) {
        long x = (long) val;
        if (st.size() == 0) {
            st.push(x);
            min = x;
        } else if (x >= min) {

            st.push(x);

        } else if (x < min) {
            st.push(2 * x - min);
            min = x;
        }
    }

    public void pop() {
        if (st.size() == 0) {
            return;
        } else if (st.peek() >= min) st.pop();
        else if (st.peek() < min) {
            long old = 2 * min - st.peek();
            min = old;
            st.pop();
        }
    }

    public int top() {
        if (st.size() == 0) return -1;

        long q = st.peek();
        if (q >= min) return (int) q;
        if (q < min) return (int) min;


        return 0;
    }

    public int getMin() {
        if (st.size() == 0) {
            return -1;
        }
        return (int) min;
    }
}


//Without using extra space
//T(C) = O(1)
//S(C) = O(N)
//For the below some test cases failed because it has given -231 <= val <= 231 - 1
//class MinStack {
//    Stack<Integer> s = new Stack<>();
//    int minEle;
//
//    public MinStack() {
//        minEle = Integer.MAX_VALUE;
//    }
//
//    public void push(int val) {
//        if (s.isEmpty()) {
//            s.push(val);
//            minEle = val;
//        } else {
//            if (val >= minEle) {
//                s.push(val);
//            } else if (val < minEle) {
//                s.push(2 * val - minEle);
//                minEle = val;
//            }
//        }
//    }
//
//    public void pop() {
//        if (s.isEmpty()) return;
//        else {
//            if (s.peek() >= minEle)
//                s.pop();
//            else if (s.peek() < minEle) {
//                minEle = 2 * minEle - s.peek();
//                s.pop();
//            }
//
//        }
//    }
//
//    public int top() {
//        if (s.isEmpty()) return -1;
//        else {
//            if (s.peek() >= minEle)
//                return s.peek();
//            else if (s.peek() < minEle)
//                return minEle;
//        }
//        return -1;
//    }
//
//    public int getMin() {
//        return minEle;
//    }
//}

//With using extra space
//T(C) = O(1)
//S(C) = O(2N)
//class MinStack {
//    Stack<Integer> s = new Stack<>();
//    Stack<Integer> ss = new Stack<>();
//
//    public MinStack() {
//
//    }
//
//    public void push(int val) {
//        s.push(val);
//        if (ss.size() == 0 || ss.peek() >= val)
//            ss.push(val);
//    }
//
//    public void pop() {
//        if (s.isEmpty()) return;
//        int ans = s.pop();
//        if (ss.peek() == ans)
//            ss.pop();
//    }
//
//    public int top() {
//        if (s.isEmpty()) return -1;
//        else return s.peek();
//    }
//
//    public int getMin() {
//        if (s.isEmpty()) return -1;
//        else return ss.peek();
//    }
//}
