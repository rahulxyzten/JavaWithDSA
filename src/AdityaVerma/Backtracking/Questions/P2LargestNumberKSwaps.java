package AdityaVerma.Backtracking.Questions;

import java.util.Arrays;

public class P2LargestNumberKSwaps {
    public static void main(String[] args) {
//        String s = "3435335";
//        int k = 3;
        String s = "1234567";
        int k = 4;
        System.out.println(findMaximumNum(s, k));
    }

    public static String findMaximumNum(String str, int k) {
        char[] charArray = str.toCharArray();
        char[] res = Arrays.copyOf(charArray, charArray.length);
        int start = 0;
        solve(charArray, k, res, start);
        return new String(res);
    }

    public static void solve(char[] str, int k, char[] res, int start) {
        if (k == 0 || start == str.length - 1) return;

        char maxVal = str[start];
        for (int j = start + 1; j < str.length; j++) {
            maxVal = (char) Math.max(maxVal, str[j]);
        }

        for (int i = start + 1; i < str.length; i++) {
            if (str[start] < str[i] && str[i] == maxVal) {
                swap(start, i, str);
                if (new String(str).compareTo(new String(res)) > 0) {
                    System.arraycopy(str, 0, res, 0, str.length);
                }
                solve(str, k - 1, res, start + 1);
                swap(start, i, str);
            }
        }

        // Horizontal Drifting
        solve(str, k, res, start + 1);
    }

    public static void swap(int i, int j, char[] str) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}


// C++ Code
// In C++, strings are passed by reference,
// In Java, they are passed by value.

// T(C) = O(N! * N)
// Total number of node => O(N!)
// Work done by a node => finding max and comparing strings takes O(N)
// S(C) = O(N) + O(N) = O(N)
// string res + recursion stack (depth of the recursion)

//    void swap(string& s, int i, int j){
//        char temp = s[i];
//        s[i] = s[j];
//        s[j] = temp;
//    }
//
//    void solve(string& s, int k, string& res, int start){
//        if(k == 0 || start == s.size() - 1) return;
//
//        char maxVal = s[start];
//        for(int i = start + 1; i < s.size(); i++){
//            maxVal = max(maxVal, s[i]);
//        }
//
//        for(int i = start + 1; i < s.size(); i++){
//            if(s[start] < s[i] && s[i] == maxVal){
//                swap(s, start, i);
//                if(s.compare(res) > 0){
//                    res = s;
//                }
//
//                solve(s, k - 1, res, start + 1);
//                swap(s, start, i);
//            }
//        }
//
//        // Horizontal Drifting
//        solve(s, k, res, start + 1);
//    }
//
//    public:
//    string findMaximumNum(string& s, int k) {
//        string res = s;
//        int start = 0;
//        solve(s, k, res, start);
//        return res;
//    }
