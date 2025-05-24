package KunalKushwaha.Cp1FirstJava;

import java.util.Scanner;

public class StringPalindrome {
    public static void main(String[] args) {
        String str;
        boolean isPalindrome = true;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a String : ");
        str = s.next();

        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println(str + " is palindrome");
        } else {
            System.out.println(str + " is not palindrome");
        }
    }
}
