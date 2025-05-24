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
        //Horizontal Drifting
        solve(str, k, res, start + 1);
    }

    public static void swap(int i, int j, char[] str) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

}
/* C++ Code */
/*
#include <bits/stdc++.h>
using namespace std;

void swap(int i, int j, string &str)
{
    char c = str[i];
    str[i] = str[j];
    str[j] = c;
}

void solve(string &str, int k, string &res, int start)
{
    if (k == 0 || start == str.size() - 1)
        return;

    char maxval = str[start];
    for (int j = start + 1; j < str.size(); j++)
    {
        maxval = max(maxval, str[j]);
    }

    for (int i = start + 1; i < str.size(); i++)
    {
        if (str[start] < str[i] && str[i] == maxval)
        {
            swap(start, i, str);
            if (str.compare(res) > 0)
            {
                res = str;
            }
            solve(str, k - 1, res, start + 1);
            swap(start, i, str);
        }
    }
    solve(str, k, res, start + 1);
}

string findMaximum(string str, int k)
{
    string res = str;
    int start = 0;
    solve(str, k, res, start);
    return res;
}

int main()
{
    string str = "3435335";
    // string str = "1234567";

    int k = 3;

    string max = findMaximum(str, k);

    cout << max << endl;

    return 0;
}

 */
