package AdityaVerma.Backtracking.Questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class P1PermutationsString {
    public static void main(String[] args) {
//        String s = "abc";
//        String s = "aab";
        String s = "aabbc";
        List<String> result = new ArrayList<>();
//      permute(s, "", result);
        permute(s, 0, result);
        System.out.println(result);
        System.out.println(result.size());
    }

    //Using Backtracking
    //T(C) = O(N * N!)   &  S(C) = (N * N!)
    public static void permute(String s, int start, List<String> result) {
        if (start == s.length() - 1) {
            result.add(s);
            return;
        }
        HashSet<Character> mpp = new HashSet<>();
        for (int i = start; i < s.length(); i++) {
            if (!mpp.contains(s.charAt(i))) {
                mpp.add(s.charAt(i));
                s = swap(i, start, s);
                permute(s, start + 1, result);
                s = swap(i, start, s);
            }
        }
        return;
    }

    public static String swap(int i, int j, String s) {
        StringBuilder sb = new StringBuilder(s);
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
        s = sb.toString();
        return s;
    }

//    //Using Recursion
//    //T(C) = O(n! n^3) = O(n)  &  S(C) = O(n!)
//    public static void permute(String ip, String op, List<String> result) {
//        if (ip.length() == 0) {
//            result.add(op);
//            return;
//        }
//        HashSet<Character> mpp = new HashSet<>();
//        for (int i = 0; i < ip.length(); i++) {
//            if (!mpp.contains(ip.charAt(i))) {
//                mpp.add(ip.charAt(i));
//                String newIp = ip.substring(0, i) + ip.substring(i + 1);
//                String newOp = op + ip.charAt(i);
//                permute(newIp, newOp, result);
//            }
//        }
//        return;
//    }
}
