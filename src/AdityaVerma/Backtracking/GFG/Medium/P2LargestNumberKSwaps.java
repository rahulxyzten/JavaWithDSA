package AdityaVerma.Backtracking.GFG.Medium;
//problem
/*
Largest number in K swaps

Given a number k and string s of digits denoting a positive integer, build the largest number possible by performing swap operations on the digits of s at most k times.

Examples :

Input: s = "1234567", k = 4
Output: 7654321
Explanation: Three swaps can make the input 1234567 to 7654321, swapping 1 with 7, 2 with 6 and finally 3 with 5.
Input: s = "3435335", k = 3
Output: 5543333
Explanation: Three swaps can make the input 3435335 to 5543333, swapping 3 with 5, 4 with 5 and finally 3 with 4.
Input: s = "1034", k = 2
Output: 4301
Explanation: Two swaps can make the input 1034 to 4301, swapping 1 with 4 and finally 0 with 3.
Constraints:
1 ≤ s.size() ≤ 15
1 ≤ k ≤ 7
 */

public class P2LargestNumberKSwaps {
    public static void main(String[] args) {
        String s = "1234567";
        int k = 4;
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

}
