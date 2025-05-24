package TakeYouforward.BinarySearch.CodeStudio.Easy;

//Problem
/*
https://www.naukri.com/code360/problems/row-with-maximum-1-s_1112656
 */
import java.util.ArrayList;
import java.util.Arrays;

public class P3FindRowWithMaxNumberOf1S {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(0, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 0)));
        int n = 3, m = 3;
        System.out.println(rowMaxOnes(matrix, n, m));
    }
    public static int rowMaxOnes(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        int countMax = 0, index = -1;
        for (int i = 0; i < n; i++) {
            int countRow1S = m - firstOccurrence(mat.get(i), m, 1);
            if (countRow1S > countMax) {
                countMax = countRow1S;
                index = i;
            }
        }
        return index;
    }

    public static int firstOccurrence(ArrayList<Integer> arr, int m, int ele) {
        int start = 0, end = m - 1;
        int index = m;
        //here the default of index must be change to -1 to m becz
        //if the array has not one then it return -1
        //if the i = 2 then countrow1s = 3 - (-1) = 4 but it has to 0
        //so if m return then countrow1s = 3 - 3 = 0 that is right
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (ele == arr.get(mid)) {
                index = mid;
                end = mid - 1;
            } else if (ele < arr.get(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return index;
    }
}
