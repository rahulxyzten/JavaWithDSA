package AdityaVerma.BinarySearch.Question;
//Allocate Minimum Number Of Pages
//Allocate Pages of Books

import java.util.Arrays;

public class P14AllocatePagesOfBooks {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        int student = 2;

//        int[] arr = {5, 4, 5, 2, 3, 4, 5, 6 };
//        int student = 5;
//        //o/p = 9 (This is question of the ship container given by Tnp CLASS
        System.out.println(allocatePagesBooks(arr, student));
    }

    public static int allocatePagesBooks(int[] arr, int k) {
        int n = arr.length;
        if (k > n) return -1;
        int start = Arrays.stream(arr).max().getAsInt();
        int end = Arrays.stream(arr).sum();
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(arr, n, k, mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    public static boolean isValid(int[] arr, int n, int k, int max) {
        int student = 1;
        int sum =0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
            if (sum > max) {
                student ++;
                sum = arr[i];
            }
            if (student > k) {
                return false;
            }
        }

        return true;
    }
    //T(C) & S(C)
    /*
    Time Complexity: O(N * log(sum(arr[])-max(arr[])+1)), where N = size of the array, sum(arr[]) = sum of all array elements,
     max(arr[]) = maximum of all array elements.
    Reason: We are applying binary search on [max(arr[]), sum(arr[])]. Inside the loop, we are calling the countStudents() function
    for the value of ‘mid’. Now, inside the countStudents() function, we are using a loop that runs for N times.

     Space Complexity:  O(1) as we are not using any extra space to solve this problem.
     */
}
