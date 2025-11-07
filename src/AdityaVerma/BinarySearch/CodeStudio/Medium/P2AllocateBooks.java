package AdityaVerma.BinarySearch.CodeStudio.Medium;
//Question
/*
https://www.naukri.com/code360/problems/allocate-books_1090540
 */
//Allocate Books

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class P2AllocateBooks {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(12, 34, 67, 90));
        int n = 4;
        int m = 2;//no of student
        int ans = findPages(arr, n, m);
        System.out.println("The answer is: " + ans);

    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if (m > n) return -1;
        int start = Integer.MIN_VALUE, end = 0;
        for (int num : arr) {
            start = Math.max(start, num);
            end += num;
        }
        int result = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(arr, n, m, mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    public static boolean isValid(ArrayList<Integer> arr, int n, int m, int maxEle) {
        int student = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr.get(i);
            if (sum > maxEle) {
                student++;
                sum = arr.get(i);
            }
            if (student > m) return false;
        }

        return true;
    }


    //T(C) & S(C)
    /*
    Time Complexity: O(N * log(sum(arr[])-max(arr[])+1))
    where N = size of the array,
    sum(arr[]) = sum of all array elements,
    max(arr[]) = maximum of all array elements.
    Why + 1? start = 40 and end = 100, here the total element 60 to 100 which is 61 element(include 60 also)
    is log(n) = log(61) = log(100-40) + 1
    Reason: We are applying binary search on [max(arr[]), sum(arr[])]. Inside the loop, we are calling the isValid() function
    for the value of ‘mid’. Now, inside the isValid() function, we are using a loop that runs for N times.

    Space Complexity: O(1) as we are not using any extra space to solve this problem.
     */
}
