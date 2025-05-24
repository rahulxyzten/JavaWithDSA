package TakeYouforward.StackAndQueue.CodeStudio.Easy;
//Convert an Infix expression to Prefix expression

///////////////////////////////////////////////////////Not Done
import java.util.Stack;

public class P2InfixToPrefix {
    public static void main(String[] args) {
//        String exp = "(p+q)*(c-d)";
//        String exp = "((a+b)*(c-d))/(e*f-g)";
        String exp = "a*(b+c)/d";
//        String exp = "(4+7)/3-2";
        System.out.println(infixToPrefix(exp));
    }


    //////////////////////////////////////////////////////////Not Done
    //T(C) = O(N)
    //S(C) = O(N)
    public static String infixToPrefix(String exp) {
        char[] reverse = exp.toCharArray();
        String reverseExpression = reverse(reverse, 0, reverse.length - 1);
        reverse = reverseExpression.toCharArray();

        for (int i = 0; i < reverse.length; i++) {
            if (reverse[i] == '(') reverse[i] = ')';
            else if (reverse[i] == ')') reverse[i] = '(';
        }

        String prefix = solve(String.valueOf(reverse));

        prefix = reverse(prefix.toCharArray(), 0, prefix.length() - 1);
        return prefix;
    }

    static String reverse(char str[], int start, int end) {
        char temp;
        while (start < end) {
            temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(str);
    }

    public static String solve(String exp) {
        StringBuilder result = new StringBuilder(new String(""));
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            } else if (ch == '(') {
                s.push(ch);
            } else if (ch == ')') {
                while (!s.isEmpty() && s.peek() != ')') {
                    result.append(s.pop());
                }
                if (!s.isEmpty()){
                    s.pop();
                }
            } else {
                if (isOperator(s.peek())) {
                    while (!s.isEmpty() && precedence(ch) <= precedence(s.peek())) {
                        result.append(s.pop());
                    }
                    s.push(ch);
                }
            }
        }

        while (!s.isEmpty()) {
            if (s.peek() == '(') return "Invalid Expression";
            result.append(s.pop());
        }

        return result.toString();
    }

    static boolean isOperator(char c) {
        return (!Character.isLetter(c) && !Character.isDigit(c));
    }

    public static int precedence(char ch) {
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

}
